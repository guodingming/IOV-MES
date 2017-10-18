package com.mes.control.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.control.device.MaterialInfo
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IPdBomMaterialsProvider
import com.mes.dubbo.interprovider.control.IPdFileResourcesProvider
import com.mes.entity.control.PdBomMaterials
/**
 * 软件路径
 *
 * Created by xiuyou.xu on 2017/8/29.
 */

JsonViewObject jsonViewObject = new JsonViewObject()
try {
    String erpCode = parameter.getRequestMap().get("erpCode")
// 硬件子料信息XML
    String materialXml = parameter.getRequestMap().get("materialXml")
    MaterialInfo materialInfo = JaxbUtil.unmarshal(MaterialInfo.class, materialXml)
    if (materialInfo != null && materialInfo.getItems() != null && !materialInfo.getItems().isEmpty()) {
        String bomWorkId = materialInfo.getItems().get(0).getMaterialId()
        IPdBomMaterialsProvider pdBomMaterialsProvider = (IPdBomMaterialsProvider) ServiceBeanContext.getInstance().getBean("pdBomMaterialsProvider")
//        Map<String, Object> map = Maps.newHashMap()
//        map.put("code", erpCode)
//        List<PdBomMaterials> pdBomMaterials = pdBomMaterialsProvider.findByMap(map)
//        if (pdBomMaterials != null && pdBomMaterials.size() == 1) {
        PdBomMaterials materials = pdBomMaterialsProvider.findMaterial(erpCode, bomWorkId)
        if (materials != null) {
            IPdFileResourcesProvider pdFileResourcesProvider = (IPdFileResourcesProvider) ServiceBeanContext.getInstance().getBean("pdFileResourcesProvider")
            List<String> paths = pdFileResourcesProvider.getMaterialResourceFiles(materials.getId())
            if (paths != null && paths.size() == 1) {
                jsonViewObject.noErrorPack(paths.get(0))
            } else {
                if (paths == null || paths.isEmpty()) {
                    jsonViewObject.pack(ErrorCodes.NO_MATERIAL_RESOURCE_FILE, "")
                } else if (paths.size() > 1) {
                    jsonViewObject.pack(ErrorCodes.MULTI_MATERIAL_RESOURCE_FILES, "")
                }
            }
        } else {
            jsonViewObject.pack(ErrorCodes.NO_MATERIAL, "")
        }
//        } else {
//            if (pdBomMaterials == null) {
//                jsonViewObject.pack(ErrorCodes.NO_MATERIAL, "")
//            } else if (pdBomMaterials.size() > 1) {
//                jsonViewObject.pack(ErrorCodes.MULTI_MATERIALS, "")
//            }
//        }
    } else {
        jsonViewObject.pack(ErrorCodes.NO_MATERIAL, "")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}
return jsonViewObject;