package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.function.BaseCall
import com.mes.common.function.FunctionParameter
import com.mes.common.utils.ErrorCodes
import com.mes.dubbo.interprovider.control.IPdExecSystemModuleCopyProvider

/**
 * Created by xiuyou.xu on 2017/8/29.
 */

JsonViewObject jsonViewObject = new JsonViewObject();

def service = [
        actionCall: { FunctionParameter parameter ->
            String systemName = parameter.getRequestMap().get("systemName");
            IPdExecSystemModuleCopyProvider pdExecSystemModuleCopyProvider = (IPdExecSystemModuleCopyProvider) ServiceBeanContext.getInstance().getBean("pdExecSystemModuleCopyProvider")
            List<Map<String, Object>> relationTables = pdExecSystemModuleCopyProvider.getRelationTables(systemName)
            if (relationTables != null && !relationTables.isEmpty()) {
                StringBuilder sb = new StringBuilder()
                sb.append("<NewDataSet>")
                relationTables.stream().each { table ->
                    sb.append("<test>")
                    table.keySet().stream().each { key ->
                        sb.append("<").append(key).append(">").append(table.get(key)).append("</").append(key).append(">")
                    }
                    sb.append("</test>")
                }
                sb.append("</NewDataSet>")

                Map<String, Object> res = Maps.newHashMap()
                res.put("content", sb.toString())
                parameter.setResponseMap(res)
            }
            return parameter
        }] as BaseCall
try {
    param = service.actionCall(parameter)
    if (param.getResponseMap() == null || param.getResponseMap().isEmpty()) {
        jsonViewObject.pack(ErrorCodes.NO_RELATION_TABLES, "")
    } else {
        jsonViewObject.noErrorPack(param.getResponseMap().get("content"))
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;