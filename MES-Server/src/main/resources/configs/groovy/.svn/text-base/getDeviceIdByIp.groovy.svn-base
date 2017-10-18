package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.function.FunctionParameter
import com.mes.common.utils.ErrorCodes
import com.mes.dubbo.interprovider.control.IFtyDeviceProvider

/**
 * Created by dengyun.le on 2017/8/29.
 */
def service = [
        actionCall: { FunctionParameter parameter ->
            println(parameter.getRequestMap())
            String ip = parameter.getRequestMap().get("ip")
            IFtyDeviceProvider iFtyDeviceProvider = ServiceBeanContext.instance.getBean("ftyDeviceProvider")
            String id = iFtyDeviceProvider.findByIp(ip);
            Map<String, Object> res = Maps.newHashMap()
            res.put("id", id)
            parameter.setResponseMap(res)
            return parameter
        }]
JsonViewObject jsonViewObject = new JsonViewObject();
try {
    param = service.actionCall(parameter)
    if (param != null) {
        def deviceId = param.getResponseMap().get("id")
        jsonViewObject.setErrorCode(ErrorCodes.NO_ERROR)
        jsonViewObject.setContent(deviceId)
    } else {
        jsonViewObject.setErrorCode(ErrorCodes.DEVICE_NOT_EXISTS);
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject