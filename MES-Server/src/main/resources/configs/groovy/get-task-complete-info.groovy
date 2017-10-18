package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.function.FunctionParameter
import com.mes.common.utils.ErrorCodes
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IDpProductInfoLogProvider
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider
import com.mes.entity.control.PdWorkOrder


/**
 * Created by dengyun.le on 2017/9/1.
 */
def service = [
        actionCall: { FunctionParameter parameter ->
            String xml = parameter.getRequestMap().get("taskInfo");
            TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml)
            String produceId = taskInfoItem.getTaskInfo().getProcedureId();
            String workOrderNum = taskInfoItem.getTaskInfo().getBillNo()

            IPdWorkOrderProvider pdWorkOrderProvider = (IPdWorkOrderProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderProvider")
            PdWorkOrder pdWorkOrder = pdWorkOrderProvider.findByWorkOrderNum(workOrderNum)
            String workOrderId = ""
            if (pdWorkOrder != null) {
                workOrderId = pdWorkOrder.getId()
            }
            IDpProductInfoLogProvider dpProductInfoLogProvider = ServiceBeanContext.instance.getBean("dpProductInfoLogProvider")
            Map map = Maps.newHashMap();
            map.put("produceProcessId", produceId);
            map.put("workOrderId", workOrderId)
            map.put("isSuccess", "");
            int completeNumber = dpProductInfoLogProvider.countByCondition(map)
            map.put("isSuccess", "1");
            int successNumber = dpProductInfoLogProvider.countByCondition(map)
            map.put("isSuccess", "0");
            int failNumber = dpProductInfoLogProvider.countByCondition(map)

            Map<String, Object> res = Maps.newHashMap()
            res.put("completeNumber", completeNumber)
            res.put("successNumber", successNumber)
            res.put("failNumber", failNumber)
            parameter.setResponseMap(res)
            return parameter
        }]
JsonViewObject jsonViewObject = new JsonViewObject();
try {
    param = service.actionCall(parameter)
    if (param != null) {
        def strXML = "<Procedure_Data>" + "<complete_number>" + param.getResponseMap().get("completeNumber") + "</complete_number>" +
                "<success_number>" + param.getResponseMap().get("successNumber") + "</success_number>" + "<fail_number>" +
                param.getResponseMap().get("failNumber") + "</fail_number>" + "</Procedure_Data>"
        jsonViewObject.setErrorCode(ErrorCodes.NO_ERROR)
        jsonViewObject.setContent(strXML)
    } else {
        jsonViewObject.setErrorCode(ErrorCodes.COMPLETE_INFO);
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject