package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.control.mapper.DpProductInfoLogMapper;
import com.mes.control.mapper.PdProductInfoMapper;
import com.mes.control.mapper.PdProductInfoNumberMapper;
import com.mes.control.utils.WorkFlowConstants;
import com.mes.dubbo.interprovider.control.IPdProductInfoProvider;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.entity.control.PdProductInfo;
import com.mes.entity.control.PdProductInfoNumber;
import com.mes.entity.control.PdWorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品明细（按工单移）
 */

public class PdProductInfoProviderImpl extends BaseProviderImpl<PdProductInfo> implements IPdProductInfoProvider {
    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;

    @Autowired
    @Qualifier("pdProductInfoNumberMapper")
    private PdProductInfoNumberMapper pdProductInfoNumberMapper;

    @Autowired
    @Qualifier("dpProductInfoLogMapper")
    private DpProductInfoLogMapper dpProductInfoLogMapper;

    @Override
    public PdProductInfoMapper getBaseInterfaceMapper() {
        return pdProductInfoMapper;
    }

    @Override
    public boolean addProductInfo(Map<String, Object> map) throws DubboProviderException {
        boolean flag = false;
        try {
            //流程实例ID
            String instanceId = (String) map.get(WorkFlowConstants.workflow.WF_INSTANCEID);
            //产品ID
            String pdId = (String) map.get(WorkFlowConstants.workflow.PD_ID);
            //工单ID workOrderId
            String workOrderId = (String) map.get(WorkFlowConstants.workflow.PD_WORKORDERID);
            PdProductInfo pdProductInfo = new PdProductInfo();
            pdProductInfo.setPdId(pdId);
            pdProductInfo.setInstanceId(instanceId);
            pdProductInfo.setStatus("1");
            pdProductInfo.setWorkOrderId(workOrderId);
            flag = true;
        } catch (Exception e) {
            log.error("添加产品失败！",e);
        }

        return flag;
    }


    @Override
    public List<PdProductInfo> getProduceInfoByNumber(String number, PdWorkOrder workOrder) throws DubboProviderException {
        List<PdProductInfo> productInfoList = Lists.newArrayList();
        try {
            if (null != workOrder) {
                int num = workOrder.getNum();
                for (int i = 0; i < num; i++) {
                    int index = Integer.valueOf(number.substring(number.length() - 2, number.length())) + i;
                    String sn = number.substring(0, number.length() - 2) + (index > 9 ? index : "0"+index) + "";
                    PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(sn);
                    if (null != productInfoNumber) {
                        PdProductInfo productInfo = this.pdProductInfoMapper.findById(productInfoNumber.getPdProductInfoId());
                        productInfo.setsN(productInfoNumber.getNumber());
                        productInfoList.add(productInfo);
                    }
                }

            }
        }catch (Exception e){
            log.error("根据产品条码获取连板产品信息失败");
            throw new DubboProviderException(e.getMessage(),e);
        }
        return productInfoList;
    }

    @Override
    public JsonViewObject checkPassProcess(String number, String produceProcessId) throws DubboProviderException {
        JsonViewObject result = new JsonViewObject();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            if (productInfoNumber != null) {
                Map<String, Object> query = Maps.newHashMap();
                query.put("pdProductInfoId", productInfoNumber.getPdProductInfoId());
                query.put("produceProcessId", produceProcessId);
                List<DpProductInfoLog> productInfoLogList = this.dpProductInfoLogMapper.findByMap(query);
                if (productInfoLogList.isEmpty()) {
                    result.setContent(false);
                } else {
                    result.setContent(true);
                    boolean flag = false;
                    for (DpProductInfoLog productInfoLog : productInfoLogList) {
                        if (productInfoLog.getIsSuccess().equals("1")) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        result.setStatus("1");
                    } else {
                        result.setStatus("0");
                    }
                }
            }else {
                result.setContent(false);
            }
        }catch (Exception e){
            log.error("校验产品条码是否生产失败!");
            throw new DubboProviderException(e.getMessage(),e);
        }
        return result;
    }
}
