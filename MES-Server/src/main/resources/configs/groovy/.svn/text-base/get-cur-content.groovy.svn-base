package com.mes.control.groovy

import com.mes.common.framework.groovy.GroovyUtil
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.common.utils.StringUtils
import com.mes.control.device.ProdInfosIn
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IDpFunctionProvider
import com.mes.entity.control.DpFunction
/**
 * 字节操作内容转换
 *
 * Created by xiuyou.xu on 2017/9/4.
 */

JsonViewObject jsonViewObject = new JsonViewObject();

try {
    String xml1 = parameter.getRequestMap().get("taskInfo")
    String xml2 = parameter.getRequestMap().get("prodInfosIn")
    String barCode = parameter.getRequestMap().get("barCode")
    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml1)
    // work bom id
    String materialId = taskInfoItem.getTaskInfo().getMaterialId()
//    String erpCode = taskInfoItem.getTaskInfo().getProductCode()
    ProdInfosIn prodInfosIn = JaxbUtil.unmarshal(ProdInfosIn.class, xml2)
    ProdInfosIn.ProdInfo prodInfo = prodInfosIn.getProdInfos().get(0)
//    String content = prodInfo.getContent()
    String sourceType = prodInfo.getSourceType()

    IDpFunctionProvider dpFunctionProvider = (IDpFunctionProvider) ServiceBeanContext.getInstance().getBean("dpFunctionProvider")
    DpFunction fn = dpFunctionProvider.findByBySourceType(sourceType)
    if (fn != null && StringUtils.isNotBlank(fn.getScript())) {
        Map<String, Object> ret = GroovyUtil.evalScript(fn.getScript(), GroovyUtil.buildMap("barCode", barCode, "taskInfoItem", taskInfoItem, "prodInfo", prodInfo))
        if (ret != null && !ret.isEmpty()) {
            jsonViewObject.noErrorPack(ret)
        } else {
            jsonViewObject.pack(ErrorCodes.TRANSFORM_FAILED, "")
        }
    } else {
        jsonViewObject.pack(ErrorCodes.NO_SOURCE_TYPE_HANDLER, "")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}
return jsonViewObject;