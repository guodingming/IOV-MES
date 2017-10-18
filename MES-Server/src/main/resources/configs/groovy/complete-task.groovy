package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.control.utils.ProcessLogUtil
import com.mes.dubbo.interprovider.control.IDpRoutesProvider
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider
import com.mes.dubbo.interprovider.control.IPdProductInfoProvider
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider
import com.mes.entity.control.PdProductInfo
import com.mes.entity.control.PdProductInfoNumber
import com.mes.entity.control.PdWorkOrder
import org.apache.log4j.lf5.LogLevel

/**
 * 产品过站
 *
 * Created by xiuyou.xu on 2017/8/29.
 */

JsonViewObject jsonViewObject = new JsonViewObject()
try {
    String barCode = parameter.getRequestMap().get("barCode")
    String userId = parameter.getRequestMap().get("userId")
    String produceProcessId = parameter.getRequestMap().get("procedureId")
    String isSuccess = parameter.getRequestMap().get("isSuccess")

    IPdProductInfoNumberProvider pdProductInfoNumberProvider = (IPdProductInfoNumberProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberProvider")
    Map<String, Object> map = Maps.newHashMap()
    map.put("number", barCode)
    List<PdProductInfoNumber> numbers = pdProductInfoNumberProvider.findByMap(map)
    if (numbers != null && !numbers.isEmpty()) {
        String pdProductInfoId = numbers.get(0).getPdProductInfoId()

        IDpRoutesProvider dpRoutesProvider = (IDpRoutesProvider) ServiceBeanContext.getInstance().getBean("dpRoutesProvider")
        boolean result = dpRoutesProvider.completeTask(pdProductInfoId, userId, produceProcessId, isSuccess)
        if (result) {
            jsonViewObject.noErrorPack("过站成功")
        } else {
            jsonViewObject.pack(ErrorCodes.COMPLETE_TASK_FAILED, "")
        }

        IPdProductInfoProvider pdProductInfoProvider = (IPdProductInfoProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoProvider")
        PdProductInfo pdProductInfo = pdProductInfoProvider.findById(pdProductInfoId)
        if (pdProductInfo != null) {
            IPdWorkOrderProvider pdWorkOrderProvider = (IPdWorkOrderProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderProvider")
            PdWorkOrder pdWorkOrder = pdWorkOrderProvider.findById(pdProductInfo.getWorkOrderId())

            if (pdWorkOrder != null) {
                ProcessLogUtil.log(LogLevel.INFO, barCode, pdWorkOrder.getWorkOrderNum(), produceProcessId, "产品过站，产品条码：" + barCode)

                ProcessLogUtil.log(LogLevel.INFO, barCode, pdWorkOrder.getWorkOrderNum(), produceProcessId, "产品过站，过站" + (result ? "成功" : "失败"))
            }
        }
    } else {
        jsonViewObject.pack(ErrorCodes.NO_PRODUCT_NUMBERS, "")
        ProcessLogUtil.log(LogLevel.INFO, barCode, "", produceProcessId, "产品过站，过站失败，未找到该条码对应的产品信息")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}
return jsonViewObject;