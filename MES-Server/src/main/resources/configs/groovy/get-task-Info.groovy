package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.function.FunctionParameter
import com.mes.common.utils.ErrorCodes
import com.mes.dubbo.interprovider.control.IDpProduceProcessProvider
import com.mes.dubbo.interprovider.control.IFtyProcessProvider
import com.mes.dubbo.interprovider.control.IPdProvider
import com.mes.dubbo.interprovider.control.IPdWorkOrderBatchProvider
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider
import com.mes.entity.control.DpProduceProcess
import com.mes.entity.control.FtyProcess
import com.mes.entity.control.Pd
import com.mes.entity.control.PdWorkOrder
import com.mes.entity.control.PdWorkOrderBatch

/**
 * Created by dengyun.le on 2017/8/30.
 */
def service = [
        actionCall: { FunctionParameter parameter ->
            println(parameter.getRequestMap())
            String id = parameter.getRequestMap().get("produceId")
            IDpProduceProcessProvider dpProduceProcessProvider = ServiceBeanContext.instance.getBean("dpProduceProcessProvider")
            DpProduceProcess dpProduceProcess = dpProduceProcessProvider.findById(id)
            String processId = dpProduceProcess.getProcessId()
            IFtyProcessProvider ftyProcessProvider = ServiceBeanContext.instance.getBean("ftyProcessProvider")
            FtyProcess ftyProcess = ftyProcessProvider.findById(processId)
            String produceName = ftyProcess.getName()
            String workOrderNum = parameter.requestMap.get("workOrderNum")
            IPdWorkOrderProvider pdWorkOrderProvider = ServiceBeanContext.instance.getBean("pdWorkOrderProvider")
            PdWorkOrder pdWorkOrder = pdWorkOrderProvider.findByWorkOrderNum(workOrderNum)
            String workOrderId = pdWorkOrder.getId();
            IPdWorkOrderBatchProvider pdWorkOrderBatchProvider = ServiceBeanContext.instance.getBean("pdWorkOrderBatchProvider")
            PdWorkOrderBatch pdWorkOrderBatch = pdWorkOrderBatchProvider.findByWorkOrderId(workOrderId)
            String batchNum = pdWorkOrderBatch.getBatchNum()
            String materialId = pdWorkOrder.getBomWorkId()
            String pdId = pdWorkOrder.getPdId()
            IPdProvider pdProvider = ServiceBeanContext.instance.getBean("pdProvider")
            Pd pd = pdProvider.findById(pdId)
            String productCode = pd.getCode();
            String machineId = parameter.getRequestMap().get("deviceId")
            Map<String, Object> res = Maps.newHashMap()
            res.put("produceId", id)
            res.put("workOrderNum", workOrderNum)
            res.put("produceName", produceName)
            res.put("batchNum", batchNum)
            res.put("pdId", pdId)
            res.put("materialId", materialId)
            res.put("productCode", productCode)
            res.put("machineId", machineId)
            res.put("amount", pdWorkOrder.getWorkOrderTotal())

            parameter.setResponseMap(res)
            return parameter
        }]
JsonViewObject jsonViewObject = new JsonViewObject();
try {
    param = service.actionCall(parameter)
    if (param != null) {
        def strXML = "<NewDataSet><taskinfo>" + "<bill_no>" + param.getResponseMap().get("workOrderNum") + "</bill_no>" + "<procedure_name>" +
                param.getResponseMap().get("produceName") + "</procedure_name>" + "<procedure_id>" + param.getResponseMap().get("produceId") +
                "</procedure_id>" + "<batch>" + param.getResponseMap().get("batchNum") + "</batch>" + "<product_id>" + param.getResponseMap().get("pdId") +
                "</product_id>" + "<material_id>" + param.getResponseMap().get("materialId") + "</material_id>" +
                "<product_code>" + param.getResponseMap().get("productCode") + "</product_code>" + "<machine_id>" + param.getResponseMap().get("machineId") +
                "</machine_id>" + "<task_mode>0</task_mode>" + "<procedure_type>1</procedure_type><amount>" + param.getResponseMap().get("amount") + "</amount><procedure_flag>0</procedure_flag></taskinfo></NewDataSet>";

        jsonViewObject.setErrorCode(ErrorCodes.NO_ERROR)
        jsonViewObject.setContent(strXML)
    } else {
        jsonViewObject.setErrorCode(ErrorCodes.TASK_INFO);
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject