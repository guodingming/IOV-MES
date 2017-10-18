package com.mes.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.function.BaseCall
import com.mes.common.function.FunctionParameter

def service = [
        actionCall: { FunctionParameter parameter ->
            println(parameter.getRequestMap())
            String ip = parameter.getRequestMap().get("ip")
            Map<String, Object> res = Maps.newHashMap()
            res.put("xyz", 123)
            parameter.setResponseMap(res)
            return parameter
        }] as BaseCall
param = service.actionCall(parameter)
JsonViewObject jsonViewObject = new JsonViewObject()
jsonViewObject.noErrorPack("xml string")

return jsonViewObject