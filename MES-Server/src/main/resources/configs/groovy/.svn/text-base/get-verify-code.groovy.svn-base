package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.dubbo.interprovider.control.IPdBomMaterialsProvider
import com.mes.entity.control.PdBomMaterials

/**
 * 获取程序文件校验和
 *
 * Created by xiuyou.xu on 2017/8/31.
 */

JsonViewObject jsonViewObject = new JsonViewObject()
try {
    String erpCode = parameter.getRequestMap().get("erpCode")
// 硬件子料信息XML
    String materialXml = parameter.getRequestMap().get("materialXml")
    IPdBomMaterialsProvider pdBomMaterialsProvider = (IPdBomMaterialsProvider) ServiceBeanContext.getInstance().getBean("pdBomMaterialsProvider")
    Map<String, Object> map = Maps.newHashMap()
    map.put("code", erpCode)
    List<PdBomMaterials> pdBomMaterials = pdBomMaterialsProvider.findByMap(map)
    if (pdBomMaterials != null && pdBomMaterials.size() == 1) {
        jsonViewObject.noErrorPack(pdBomMaterials.get(0).getChecksum())
    } else {
        if (pdBomMaterials == null) {
            jsonViewObject.pack(ErrorCodes.NO_MATERIAL, "")
        } else if (pdBomMaterials.size() > 1) {
            jsonViewObject.pack(ErrorCodes.MULTI_MATERIALS, "")
        }
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;