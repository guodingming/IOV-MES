package com.mes.control.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.dubbo.interprovider.control.IDpProduceDemarcateProvider
import com.mes.dubbo.interprovider.control.IDpProduceProcessProvider
import com.mes.dubbo.interprovider.control.IPdProvider
import com.mes.entity.control.DpProduceProcess
import com.mes.entity.control.Pd

/**
 * 获取标定数据
 *
 * Created by xiuyou.xu on 2017/8/29.
 */

JsonViewObject jsonViewObject = new JsonViewObject();
try {
    String machineId = parameter.getRequestMap().get("machineId")
    String produceProcessId = parameter.getRequestMap().get("procedureId")
    String toolId = parameter.getRequestMap().get("toolId")
    String demarcateVersion = parameter.getRequestMap().get("demarcateVersion")

    IDpProduceProcessProvider dpProduceProcessProvider = (IDpProduceProcessProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessProvider")
    DpProduceProcess dpProduceProcess = dpProduceProcessProvider.findById(produceProcessId)
    IPdProvider pdProvider = (IPdProvider) ServiceBeanContext.getInstance().getBean("pdProvider")
    Pd pd = null;
    if (dpProduceProcess != null) {
        pd = pdProvider.findById(dpProduceProcess.getPdId())
    }
    IDpProduceDemarcateProvider dpProduceDemarcateProvider = (IDpProduceDemarcateProvider) ServiceBeanContext.getInstance().getBean("dpProduceDemarcateProvider")
    List<Map<String, Object>> list = dpProduceDemarcateProvider.getDownload(produceProcessId)

    StringBuilder sb = new StringBuilder()
    sb.append("<demarcate_item_array>")
    if (list != null && !list.isEmpty()) {
        sb.append("<demarcate_items dim=\"[").append(list.size()).append("]\">")
        for (int i = 1; i < list.size(); i++) {
            Map<String, Object> it = list.get(i)
            sb.append("<demarcate_item><sd_id>").append(it.get("column0")).append("</sd_id><sd_name>").
                    append(it.get("column1")).append("</sd_name><sd_data>").append(it.get("column2")).append("</sd_data></demarcate_item>")
        }
        sb.append("</demarcate_items>")
    }
    if (pd != null) {
        sb.append("<product_type>").append(pd.getName()).append("</product_type>")
    }
    sb.append("</demarcate_item_array>")

    jsonViewObject.noErrorPack(sb.toString())
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}
return jsonViewObject;