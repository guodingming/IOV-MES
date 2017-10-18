package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider
import com.mes.entity.control.PdProductInfoNumber

/**
 * 根据字节内容获取跟踪号
 *
 * Created by xiuyou.xu on 2017/9/1.
 */

JsonViewObject jsonViewObject = new JsonViewObject()
try {
// 输入条码
    String barCode = parameter.getRequestMap().get("barCode")
    String xml = parameter.getRequestMap().get("taskInfo")
    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml)
    IPdProductInfoNumberProvider pdProductInfoNumberProvider = (IPdProductInfoNumberProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberProvider")
    Map<String, Object> map = Maps.newHashMap()
    map.put("number", barCode)
    List<PdProductInfoNumber> pdProductInfoNumbers = pdProductInfoNumberProvider.findByMap(map)
    if (pdProductInfoNumbers != null && !pdProductInfoNumbers.isEmpty()) {
        // TODO 跟踪号对应的type需要根据实际修改
        String type = "unique"
        String productInfoId = pdProductInfoNumbers.get(0).getPdProductInfoId()
        map.clear()
        map.put("type", type)
        map.put("pdProductInfoId", productInfoId)
        pdProductInfoNumbers = pdProductInfoNumberProvider.findByMap(map)
        if (pdProductInfoNumbers != null && !pdProductInfoNumbers.isEmpty()) {
            jsonViewObject.noErrorPack(pdProductInfoNumbers.get(0).getNumber())
        } else {
            jsonViewObject.pack(ErrorCodes.NO_PRODUCT_NUMBERS, "")
        }
    } else {
        jsonViewObject.pack(ErrorCodes.NO_PRODUCT_NUMBERS, "")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;