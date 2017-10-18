package com.mes.control.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider
import com.mes.dubbo.interprovider.control.IUserProvider
import com.mes.entity.control.PdWorkOrder
import com.mes.entity.control.User
import com.mes.entity.control.UserProcess

/**
 * Created by dengyun.le on 2017/8/30.
 */
JsonViewObject jsonViewObject = new JsonViewObject();
try {
    String username = parameter.getRequestMap().get("username")
    String produceProcessId = parameter.getRequestMap().get("processId")
    String password = parameter.getRequestMap().get("password")
    String workOrderNum = parameter.getRequestMap().get("workOrderNum")
    String workOrderId = null
    IPdWorkOrderProvider pdWorkOrderProvider = ServiceBeanContext.instance.getBean("pdWorkOrderProvider")
    PdWorkOrder pdWorkOrder = pdWorkOrderProvider.findByWorkOrderNum(workOrderNum)
    if (pdWorkOrder != null) {
        workOrderId = pdWorkOrder.getId()
    }

    UserProcess userProcess = new UserProcess();
    userProcess.setUsername(username)
    userProcess.setProcessId(produceProcessId)
    userProcess.setPassword(password)
    userProcess.setWorkOrderId(workOrderId)
    IUserProvider userProvider = ServiceBeanContext.instance.getBean("userProvider")
    JsonViewObject jvo = userProvider.authDevice(userProcess)
    if (jvo.getContent() != null) {
        Map map = (Map) jvo.getContent()
        User uu = (User) map.get("userInfo")
        String userId = uu.getId()
        String Group = "01"

        Map<String, String> map1 = new HashMap()
        map1.put("strUserID", userId)
        map1.put("strUser", username)
        map1.put("strGroup", Group)

        jsonViewObject.noErrorPack(map1)
    } else {
        jsonViewObject.setErrorCode(ErrorCodes.SHOW_LOGIN)
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}
return jsonViewObject