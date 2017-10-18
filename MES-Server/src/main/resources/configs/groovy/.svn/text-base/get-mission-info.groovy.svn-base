package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.dubbo.interprovider.control.*
import com.mes.entity.control.*

/**
 * 显示任务信息
 *
 * Created by xiuyou.xu on 2017/9/6.
 */

JsonViewObject jsonViewObject = new JsonViewObject();

try {
    String produceProcessId = parameter.getRequestMap().get("procedureId");
    String deviceId = parameter.getRequestMap().get("machineId")
    // 工单号
    String workOrderId = parameter.getRequestMap().get("workOrderId")

    IDpProduceProcessProvider dpProduceProcessProvider = (IDpProduceProcessProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessProvider")
    IPdProvider pdProvider = (IPdProvider) ServiceBeanContext.getInstance().getBean("pdProvider")
    IPdBomMaterialsProvider pdBomMaterialsProvider = (IPdBomMaterialsProvider) ServiceBeanContext.getInstance().getBean("pdBomMaterialsProvider")
    IFtyProcessProvider ftyProcessProvider = (IFtyProcessProvider) ServiceBeanContext.getInstance().getBean("ftyProcessProvider")
    IPdWorkOrderProvider pdWorkOrderProvider = (IPdWorkOrderProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderProvider")
    IPdWorkOrderBatchProvider pdWorkOrderBatchProvider = (IPdWorkOrderBatchProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderBatchProvider")
    IPdBomProduceAmountProvider pdBomProduceAmountProvider = (IPdBomProduceAmountProvider) ServiceBeanContext.getInstance().getBean("pdBomProduceAmountProvider")

    DpProduceProcess dpProduceProcess = dpProduceProcessProvider.findById(produceProcessId)
    if (dpProduceProcess != null) {
        Pd pd = pdProvider.findById(dpProduceProcess.getPdId())

        FtyProcess ftyProcess = ftyProcessProvider.findById(dpProduceProcess.getProcessId())

        StringBuilder sb = new StringBuilder()
        sb.append("<MissionPlay>")

        if (pd != null) {
            sb.append("<item><name>产品名称</name><value>").append(pd.getName()).append("</value></item>")

            Map<String, Object> map = Maps.newHashMap()
            map.put("name", pd.getName())
            List<PdBomMaterials> materials = pdBomMaterialsProvider.findByMap(map)

            if (materials != null && !materials.isEmpty()) {
                sb.append("<item><name>产品ERP编码</name><value>").append(materials.get(0).getCode()).append("</value></item>")
            }
        }

        if (ftyProcess != null) {
            sb.append("<item><name>工序名称</name><value>").append(ftyProcess.getName()).append("</value></item>")
        }

        sb.append("<item><name>任务类型</name><value>").append("正式生产").append("</value></item>")


        Map<String, Object> map1 = Maps.newHashMap()
        map1.put("workOrderNum", workOrderId)
        List<PdWorkOrder> pdWorkOrders = pdWorkOrderProvider.findByMap(map1)
        if (pdWorkOrders != null && !pdWorkOrders.isEmpty()) {
            PdWorkOrder pdWorkOrder = pdWorkOrders.get(0)
            if (pdWorkOrder != null) {
                sb.append("<item><name>工单号</name><value>").append(pdWorkOrder.getWorkOrderNum()).append("</value></item>")
            }

            map1.clear()
            map1.put("workOrderId", pdWorkOrder.getId())
            List<PdWorkOrderBatch> pdWorkOrderBatches = pdWorkOrderBatchProvider.findByMap(map1)
            if (pdWorkOrderBatches != null && !pdWorkOrderBatches.isEmpty()) {
                sb.append("<item><name>生产批次</name><value>").append(pdWorkOrderBatches.get(0).getBatchNum()).append("</value></item>")
            }

            if (pdWorkOrder != null) {
                sb.append("<item><name>任务数量</name><value>").append(pdWorkOrder.getWorkOrderTotal()).append("</value></item>")
            }
        }

        List<Map<String, Object>> materials = pdBomProduceAmountProvider.getMaterialVersions(dpProduceProcess.getBomProduceId())
        if (materials != null && !materials.isEmpty()) {
            materials.each { material ->
                sb.append("<item><name>").append(material.get("name")).append("</name><value>").append(material.get("inVersion")).append("</value></item>")
            }
        }

        sb.append("</MissionPlay>")
        jsonViewObject.noErrorPack(sb.toString())
    } else {
        jsonViewObject.pack(ErrorCodes.PRODUCE_PROCESS_NOT_FOUND, "")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}
return jsonViewObject;