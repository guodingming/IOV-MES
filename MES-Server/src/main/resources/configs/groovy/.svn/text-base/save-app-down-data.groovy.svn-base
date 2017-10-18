package configs.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.common.utils.IDGenerator
import com.mes.control.device.ChipOperateData
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IPdExecSoftinjectTbProvider
import com.mes.entity.control.PdExecSoftinjectTb

/**
 * 保存软注结果
 * Created by xiuyou.xu on 2017/9/14.
 */

JsonViewObject jsonViewObject = new JsonViewObject()

try {
    String xml1 = parameter.getRequestMap().get("taskInfo")
    String xml2 = parameter.getRequestMap().get("downloadResult")
    // 产品条码
    String materialInfo = parameter.getRequestMap().get("materialInfo")

    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml1)
    ChipOperateData chipOperateData = JaxbUtil.unmarshal(ChipOperateData.class, xml2)

    IPdExecSoftinjectTbProvider pdExecSoftinjectTbProvider = (IPdExecSoftinjectTbProvider) ServiceBeanContext.getInstance().getBean("pdExecSoftinjectTbProvider")
    List<ChipOperateData.ChipOperateUnit> chipOperateUnits = chipOperateData.getChipOperateUnits()
    if (chipOperateUnits != null && !chipOperateUnits.isEmpty()) {
        for (int i = 0; i < chipOperateUnits.size(); i++) {
            ChipOperateData.ChipOperateUnit result = chipOperateUnits.get(i)
            PdExecSoftinjectTb pdExecSoftinjectTb = new PdExecSoftinjectTb()
//            pdExecSoftinjectTb.setSerialId((i + 1) + "")
            pdExecSoftinjectTb.setSerialId(IDGenerator.getID())
            pdExecSoftinjectTb.setProductSerialId(materialInfo)
            pdExecSoftinjectTb.setAddr(result.getAddress())
            pdExecSoftinjectTb.setContent(result.getContent())
            pdExecSoftinjectTb.setPreContent(result.getOldContent())
            pdExecSoftinjectTb.setOperDate(new Date())

            pdExecSoftinjectTbProvider.save(pdExecSoftinjectTb)
        }
    }

    jsonViewObject.noErrorPack("保存成功")
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;