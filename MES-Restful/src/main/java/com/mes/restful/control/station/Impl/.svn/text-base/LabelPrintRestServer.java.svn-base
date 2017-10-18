package com.mes.restful.control.station.Impl;

import com.google.common.collect.Lists;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IAgentProvider;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider;
import com.mes.dubbo.interprovider.control.IPdProductPdLableProvider;
import com.mes.entity.control.*;
import com.mes.restful.control.station.StationBaseRestServer;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by bo.zhou1 on 2017/9/27.
 */
@Api(value = "工作站-标签打印", description = "工作站-标签打印")
@Path(RestConstants.RestPathPrefix.STATION + "/label")
public class LabelPrintRestServer extends StationBaseRestServer {

    private IAgentProvider agentProvider = ControlConsumer.getAgentProvider();

    private IPdProductInfoNumberProvider pdProductInfoNumberProvider = ControlConsumer.getPdProductInfoNumberProvider();

    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    private IPdProductPdLableProvider pdProductPdLableProvider = ControlConsumer.getPdProductPdLableProvider();

    /**
     * 标签打印
     *
     * @param number
     * @return
     */
    @GET
    @Path("/operation")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "标签打印", notes = "标签打印", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject labelPrint(@ApiParam(value = "产品条码", required = true) @QueryParam("number") String number, @ApiParam(value = "AgentID", required = true) @QueryParam("agentId") String agentId) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (session != null) {
                if (StringUtils.isNotBlank(number)) {
                    User user = super.getSessionUser();
                    DpProduceProcess dpProduceProcess = super.getSessionProduceProcess();
                    PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberProvider.findByNumber(number);
                    if (null != productInfoNumber) {
                        boolean processValidate = this.dpRoutesProvider.checkProductProcess(productInfoNumber.getPdProductInfoId(), dpProduceProcess.getId());
                        if (processValidate) {
                            boolean flag = agentProvider.printProductLabel(agentId, productInfoNumber.getPdProductInfoId());
                            if (flag) {
                                PdProductPdLable pdProductPdLable = this.pdProductPdLableProvider.findByProductInfoId(productInfoNumber.getPdProductInfoId());
                                if (pdProductPdLable != null) {
                                    this.dpRoutesProvider.completeTask(productInfoNumber.getPdProductInfoId(), user.getId(), dpProduceProcess.getId(), "1");
                                }
                                jsonView.successPack(true, "标签打印成功");
                            } else {
                                jsonView.failPack(false, "标签打印失败,服务器异常");
                            }
                        } else {
                            PdProductPdLable pdProductPdLable = this.pdProductPdLableProvider.findByProductInfoId(productInfoNumber.getPdProductInfoId());
                            if (null != pdProductPdLable) {
                                agentProvider.printProductLabel(agentId, productInfoNumber.getPdProductInfoId());
                                jsonView.successPack(true, "标签打印成功");
                            } else {
                                jsonView.failPack(false, "标签打印失败,当前产品任务不在当前工序");
                            }
                        }
                    } else {
                        jsonView.failPack(false, "标签打印失败,该条码不存在");
                    }
                } else {
                    jsonView.failPack(false, "标签打印失败,请输入产品条码");
                }
            } else {
                jsonView.failPack(false, "标签打印失败,请重新登录");
            }
        } catch (Exception e) {
            jsonView.failPack(false, "标签打印失败,服务器异常");
            this.addOperationLog("标签打印", "", false);
            log.error("LabelPrintRestServer labelPrint is error", e);
        }
        return jsonView;
    }

    /**
     * 获取Agent
     *
     * @return
     */
    @GET
    @Path("/getAgent")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取Agent", notes = "获取Agent", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getAgent() {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (session != null) {
                List<Agent> agentList = this.agentProvider.findAll();
                jsonView.successPack(agentList, "获取Agent成功");
            } else {
                jsonView.failPack(Lists.newArrayList(), "获取Agent失败,请重新登录");
            }
        } catch (Exception e) {
            jsonView.failPack(Lists.newArrayList(), "获取Agent失败,服务器异常");
            this.addOperationLog("获取Agent失败", "", false);
            log.error("LabelPrintRestServer getAgent is error", e);
        }
        return jsonView;
    }
}
