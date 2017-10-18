package com.mes.control.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IPdBomWorkAmountProvider
import com.mes.entity.control.PdBomMaterials

/**
 * 获取软件物料树
 *
 * Created by xiuyou.xu on 2017/8/31.
 */

JsonViewObject jsonViewObject = new JsonViewObject();
try {
    String xml = parameter.getRequestMap().get("taskInfo");
    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml)
    String materialId = taskInfoItem.getTaskInfo().getMaterialId()
    IPdBomWorkAmountProvider pdBomWorkAmountProvider = (IPdBomWorkAmountProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkAmountProvider")
    // TODO 软件物料type为6，或13？
    List<PdBomMaterials> materials = pdBomWorkAmountProvider.getBomMaterialsByType(materialId, "4")
    StringBuilder sb = new StringBuilder()
    if (materials != null && !materials.isEmpty()) {
        sb.append("<MaterialInfo>")
        materials.each { material ->
            sb.append("<item>")
                    .append("<is_main>").append("1").append("</is_main>")
                    .append("<material_batch>").append("").append("</material_batch>")
                    .append("<material_code>").append(material.getCode()).append("</material_code>")
                    .append("<material_id>").append(materialId).append("</material_id>")
                    .append("</item>");
        }
        sb.append("</MaterialInfo>")

        jsonViewObject.noErrorPack(sb.toString())
    } else {
        jsonViewObject.pack(ErrorCodes.NO_BOM_MATERIAL, "")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;