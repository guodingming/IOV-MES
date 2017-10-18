package com.mes.control.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.common.utils.IDGenerator
import com.mes.control.device.SoftwareInjectionResult1
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IPdExecSoftinjectTbProvider
import com.mes.entity.control.PdExecSoftinjectTb

/**
 * 保存芯片操作结果
 *
 * Created by xiuyou.xu on 2017/9/1.
 */

JsonViewObject jsonViewObject = new JsonViewObject()
try {
    String xml1 = parameter.getRequestMap().get("taskInfo")
    String xml2 = parameter.getRequestMap().get("softwareInjectionResult")
    String barCode = parameter.getRequestMap().get("barCode")
    SoftwareInjectionResult1 result = JaxbUtil.unmarshal(SoftwareInjectionResult1.class, xml2)
    IPdExecSoftinjectTbProvider pdExecSoftinjectTbProvider = (IPdExecSoftinjectTbProvider) ServiceBeanContext.getInstance().getBean("pdExecSoftinjectTbProvider")
    List<SoftwareInjectionResult1.ChipOperateResult> chipOperateResults = result.getChipOperateResults()
    if (chipOperateResults != null && !chipOperateResults.isEmpty()) {
        chipOperateResults.each { chipOperateResult ->
            PdExecSoftinjectTb pdExecSoftinjectTb = new PdExecSoftinjectTb()
            pdExecSoftinjectTb.setSerialId(IDGenerator.getID())
            pdExecSoftinjectTb.setProductSerialId(barCode)
            pdExecSoftinjectTb.setAddr(chipOperateResult.getAddress())
            pdExecSoftinjectTb.setContent(chipOperateResult.getContent())
            pdExecSoftinjectTb.setPreContent(chipOperateResult.getOldContent())

            pdExecSoftinjectTbProvider.save(pdExecSoftinjectTb)
        }
    }

    jsonViewObject.noErrorPack("保存成功")
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;