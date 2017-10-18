package com.mes.control.provider;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.framework.netty.Message;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.*;
import com.mes.control.utils.NettyServer;
import com.mes.dubbo.interprovider.control.IAgentProvider;
import com.mes.entity.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;
import java.util.UUID;

/**
 * 平台管理-工作站Agent管理
 * Created by xiuyou.xu on 2017/7/4.
 */
public class AgentProviderImpl extends BaseProviderImpl<Agent> implements IAgentProvider {
    private static Logger logger = LoggerFactory.getLogger(AgentProviderImpl.class);

    @Autowired
    @Qualifier("agentMapper")
    private AgentMapper agentMapper;

    @Autowired
    @Qualifier("pdProductPdLableMapper")
    private PdProductPdLableMapper pdProductPdLableMapper;

    @Autowired
    @Qualifier("dpBoxMapper")
    private DpBoxMapper dpBoxMapper;
    @Autowired
    @Qualifier("dpBoxRuleMapper")
    private DpBoxRuleMapper dpBoxRuleMapper;

    @Autowired
    @Qualifier("dpLabelMapper")
    private DpLabelMapper dpLabelMapper;

    @Autowired
    @Qualifier("dpFunctionMapper")
    private DpFunctionMapper dpFunctionMapper;

    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;

    @Override
    public AgentMapper getBaseInterfaceMapper() {
        return agentMapper;
    }

    @Override
    public void updateStatusByIp(String ip, String status) throws DubboProviderException {
        Agent agent = new Agent();
        agent.setIp(ip);
        agent.setStatus(status);
        agentMapper.updateStatusByIp(agent);
    }

    @Override
    public boolean printProductLabel(String agentId, String pdProductInfoId) throws DubboProviderException {
        boolean flag = false;
        try {
            Agent agent = findById(agentId);
            if (agent != null) {
                PdProductInfo pdProductInfo = pdProductInfoMapper.findById(pdProductInfoId);
                if (pdProductInfo != null) {
                    PdProductPdLable productPdLable = this.pdProductPdLableMapper.findByProductInfoId(pdProductInfo.getId());
                    String cmd = "";
                    if (null != productPdLable) {
                        cmd = productPdLable.getContent();
                    } else {
                        String pdId = pdProductInfo.getPdId();
                        DpLabel dpLabel = this.dpLabelMapper.findByPdAndCode(pdId, "3");
                        if (dpLabel != null) {
                            String template = dpLabel.getTemplateOrder();
                            String fnId = dpLabel.getFunctionId();
                            DpFunction fn = dpFunctionMapper.findById(fnId);
                            // TODO 不同产品的标签打印指令应该使用不同的脚本生成
                            Map<String, Object> map = Maps.newHashMap();
                            map.put("template", template);
                            map.put("pdProductInfoId", pdProductInfoId);
                            cmd = (String) GroovyUtil.evalScript(fn.getScript(), map);
                        }
                    }
                    this.sendPrint(cmd, "usb", agent.getIp(), 9100, agent);
                    if (null == productPdLable) {
                        PdProductPdLable pdProductPdLable = new PdProductPdLable();
                        pdProductPdLable.setId(IDGenerator.getID());
                        pdProductPdLable.setPdProductInfoId(pdProductInfo.getId());
                        pdProductPdLable.setContent(cmd);
                        this.pdProductPdLableMapper.save(pdProductPdLable);
                    }
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
        return flag;
    }

    @Override
    public boolean printBoxLabel(String agentId, PdWorkOrder pdWorkOrder, String boxKey) throws DubboProviderException {
        boolean flag = false;
        try {
            Agent agent = findById(agentId);
            if (agent != null) {
                String cmd = "";
                DpLabel label = this.dpLabelMapper.findByPdAndCode(pdWorkOrder.getPdId(), "1");
                if (label != null) {
                    String template = label.getTemplateOrder();
                    String fnId = label.getFunctionId();
                    DpFunction fn = dpFunctionMapper.findById(fnId);
                    // TODO 不同产品的标签打印指令应该使用不同的脚本生成
                    Map<String, Object> map = Maps.newHashMap();
                    map.put("template", template);
                    map.put("pdWorkOrder", pdWorkOrder);
                    map.put("boxKey", boxKey);
                    cmd = (String) GroovyUtil.evalScript(fn.getScript(), map);
                    this.sendPrint(cmd, "usb", agent.getIp(), 9100, agent);
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
        return flag;
    }

    @Override
    public boolean printBoxBarCode(String agentId, String boxId, int num) throws DubboProviderException {
        return false;
    }

    /**
     * @param cmd       打印指令
     * @param portType  打印机连接端口类型 usb，serial，tcp
     * @param printIp   打印机IP 网络打印机需要
     * @param printPort 打印机端口 网络打印机需要
     * @param agent     驱动打印机的Agent
     */
    private void sendPrint(String cmd, String portType, String printIp, int printPort, Agent agent) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("cmd", cmd);
        map.put("type", Message.BizType.LABEL_PRINT);
        map.put("printerPort", portType);
        map.put("ip", printIp);
        map.put("port", printPort);
        Message message = new Message();
        message.setMessageId(UUID.randomUUID().toString());
        message.setBody(JSON.toJSONString(map));
        message.setType(Message.Type.MES2AGENT_DATA);
        NettyServer.getInstance().getServer().send(message, agent.getIp());
    }
}
