package com.mes.control.groovy

import com.mes.common.framework.config.ConfigHelper
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.common.utils.StringUtils
import com.mes.control.device.RemoteConfig
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.*
import com.mes.entity.control.DpDataDictionary
import com.mes.entity.control.DpProduceProcessConfig
import com.mes.entity.control.PdBomAffiliated
import com.mes.entity.control.PdBomWork

import java.util.stream.IntStream

/**
 * 产品测试标准XML
 *
 * Created by xiuyou.xu on 2017/8/30.
 */

JsonViewObject jsonViewObject = new JsonViewObject();
try {
    String xml = parameter.getRequestMap().get("taskInfo");
    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml)
    String produceProcessId = taskInfoItem.getTaskInfo().getProcedureId()
    String deviceId = taskInfoItem.getTaskInfo().getMachineId()
    IDpProduceStandardTestProvider dpProduceStandardTestProvider = (IDpProduceStandardTestProvider) ServiceBeanContext.getInstance().getBean("dpProduceStandardTestProvider")
    IDpProduceStandardTestOrderProvider dpProduceStandardTestOrderProvider = (IDpProduceStandardTestOrderProvider) ServiceBeanContext.getInstance().getBean("dpProduceStandardTestOrderProvider")
    List<Map<String, Object>> standards = dpProduceStandardTestProvider.getDownload(produceProcessId)
    List<Map<String, Object>> orders = dpProduceStandardTestOrderProvider.getDownload(produceProcessId)
    StringBuilder sb = new StringBuilder()
    // 产品零件号，为产品单项配置
    String clientNo = "pl_client_number"
    String bomWorkId = taskInfoItem.getTaskInfo().getMaterialId()
    IPdBomWorkProvider pdBomWorkProvider = (IPdBomWorkProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkProvider")
    PdBomWork bomWork = pdBomWorkProvider.findById(bomWorkId)
    sb.append("<ProductInfo>")
    //测试顺序
    if (orders.size() < 2) {
        sb.append("<order><test_orders dim=\"[1]\"><test_order><name>0</name><orders>0</orders><signal>0</signal></test_order></test_orders></order>")
    } else {
        sb.append("<order>").append("<test_orders dim=\"[").append(orders.size() - 1).append("]\">")
        IntStream.range(1, orders.size()).mapToObj { i -> orders.get(i) }.each { Map<String, Object> order ->
            sb.append("<test_order>")
                    .append("<name>").append(order.get("column0")).append("</name>")
                    .append("<orders>").append(order.get("column1")).append("</orders>")
                    .append("<signal>").append(order.get("column2")).append("</signal>")
                    .append("</test_order>")
        }
        sb.append("</test_orders>").append("</order>")

    }
    //测试标准
    if (standards.size() < 2) {
        sb.append("<test_standard><test_standard_array dim=\"[1]\"><test_item><ti_id>1</ti_id><ti_name>0</ti_name><ti_standard>0</ti_standard><ti_upper>0</ti_upper><ti_lower>0</ti_lower></test_item></test_standard_array></test_standard>")
    } else {
        sb.append("<test_standard>").append("<test_standard_array dim=\"[").append(standards.size() - 1).append("]\">")
        IntStream.range(1, standards.size()).mapToObj { i -> standards.get(i) }.each { Map<String, Object> standard ->
            sb.append("<test_item>")
                    .append("<ti_id>").append(standard.get("column0")).append("</ti_id>")
                    .append("<ti_name>").append(standard.get("column1")).append("</ti_name>")
                    .append("<ti_standard>").append(standard.get("column2")).append("</ti_standard>")
                    .append("<ti_upper>").append(standard.get("column3")).append("</ti_upper>")
                    .append("<ti_lower>").append(standard.get("column4")).append("</ti_lower>")
                    .append("</test_item>")
        }

        sb.append("</test_standard_array>").append("</test_standard>")

    }
    //温度上下限
    String temperatureTopKey = "procedure_top"
    String temperatureBottomKey = "procedure_bottom"
    IDpProduceProcessConfigProvider dpProduceProcessConfigProvider = (IDpProduceProcessConfigProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessConfigProvider")
    DpProduceProcessConfig temperatureTop = dpProduceProcessConfigProvider.getConfig(temperatureTopKey, produceProcessId)
    if (temperatureTop != null) {
        sb.append("<procedure_top>").append(temperatureTop.getValue()).append("</procedure_top>")
    } else {
        sb.append("<procedure_top>0</procedure_top>")
    }
    DpProduceProcessConfig temperatureBottom = dpProduceProcessConfigProvider.getConfig(temperatureBottomKey, produceProcessId)
    if (temperatureBottom != null) {
        sb.append("<procedure_bottom>").append(temperatureBottom.getValue()).append("</procedure_bottom>")
    } else {
        sb.append("<procedure_bottom>0</procedure_bottom>")
    }
    sb.append("<procedure_id type=\"String\">").append(produceProcessId).append("</procedure_id>")
    //实现方式
    //获取远程配置类型id
    String typeKey = ConfigHelper.getValue("device.dic.type");
    IDpDataDictionaryProvider dataDictionaryProvider = ServiceBeanContext.getInstance().getBean("dpDataDictionaryProvider");
    List<DpDataDictionary> dataDictionaryList = dataDictionaryProvider.findDictionaryByTypeKey(typeKey);
    String deviceConfigType = ""
    for (DpDataDictionary dataDictionary : dataDictionaryList) {
        if (dataDictionary.getValuev().equals("1")) {
            deviceConfigType = dataDictionary.getId()
        }
    }
    IFtyDeviceConfigInfoProvider ftyDeviceConfigInfoProvider = (IFtyDeviceConfigInfoProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceConfigInfoProvider")
    String str = ftyDeviceConfigInfoProvider.getRemoteConfigXml("", produceProcessId, deviceId, deviceConfigType)
    String implementMode = "";
    if (str != null && !str.isEmpty()) {
        RemoteConfig remoteConfig = JaxbUtil.unmarshal(RemoteConfig.class, str)
        if (remoteConfig != null && remoteConfig.getItems() != null && !remoteConfig.getItems().isEmpty()) {
            remoteConfig.getItems().each { item ->
                if ("产品实现方式".equals(item.getName())) {
                    implementMode = item.getValue()
                }
            }
        }
    }
    if (StringUtils.isNotBlank(implementMode)) {
        sb.append("<implement_mode>").append(implementMode).append("</implement_mode>")
    } else {
        sb.append("<implement_mode>1</implement_mode>")
    }
    if (bomWork != null) {
        //产品零件号
        String bomProduceId = bomWork.getBomProduceId()
        IPdBomAffiliatedProvider pdBomAffiliatedProvider = (IPdBomAffiliatedProvider) ServiceBeanContext.getInstance().getBean("pdBomAffiliatedProvider")
        List<PdBomAffiliated> pdBomAffiliateds = pdBomAffiliatedProvider.findAffiliates(bomWork.getPdId(), clientNo, bomProduceId)
        if (pdBomAffiliateds != null && !pdBomAffiliateds.isEmpty()) {
            sb.append("<pl_client_number>").append(pdBomAffiliateds.get(0).getValue()).append("</pl_client_number>")
        } else {
            sb.append("<pl_client_number>0</pl_client_number>")
        }
    } else {
        return jsonViewObject.pack(ErrorCodes.NO_WORK_BOM, "")
    }
    sb.append("</ProductInfo>")
    return jsonViewObject.noErrorPack(sb.toString())
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;