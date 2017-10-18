package com.mes.control.groovy

import com.mes.common.framework.config.ConfigHelper
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.common.utils.StringUtils
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigInfoProvider
import com.mes.entity.control.DpDataDictionary
/**
 * 根据类型获取设备相关配置文件
 *
 * Created by xiuyou.xu on 2017/8/31.
 */

JsonViewObject jsonViewObject = new JsonViewObject();
try {
// 数字表示1,2等，用chip-op-dic.xml中的file_type类别中的value映射为name，即配置类别编码，在mes_fty_device_config_type中根据code即可查询对应的配置类型
    String fileTypeCode = parameter.getRequestMap().get("fileTypeCode");
    String produceProcessId = parameter.getRequestMap().get("produceProcessId");
    String deviceId = parameter.getRequestMap().get("deviceId");

//    Map<String, Map<String, Object>> dic = ChipOpDictionaryUtil.reverseIndex()
//    Map<String, Object> fileTypes = dic.get("file_type")
    IDpDataDictionaryProvider dataDictionaryProvider = ServiceBeanContext.getInstance().getBean("dpDataDictionaryProvider");
    String typeKey = ConfigHelper.getValue("device.dic.type");
    List<DpDataDictionary> dataDictionaryList = dataDictionaryProvider.findDictionaryByTypeKey(typeKey);
//    String deviceConfigTypeCode = ""
    String deviceConfigType = ""
//    fileTypes.keySet().each { key ->
//        if (fileTypeCode.equals(fileTypes.get(key))) {
//            deviceConfigTypeCode = key
//        }
//    }
    for (DpDataDictionary dataDictionary : dataDictionaryList) {
        if (dataDictionary.getValuev().equals(fileTypeCode)) {
//            deviceConfigTypeCode = dataDictionary.getCnName();
            deviceConfigType = dataDictionary.getId()
        }
    }
//    IFtyDeviceConfigTypeProvider ftyDeviceConfigTypeProvider = (IFtyDeviceConfigTypeProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceConfigTypeProvider")
//    Map<String, Object> map = Maps.newHashMap()
//    map.put("code", deviceConfigTypeCode)
//    List<FtyDeviceConfigType> types = ftyDeviceConfigTypeProvider.findByMap(map)
    if (StringUtils.isNotBlank(deviceConfigType)) {
//        deviceConfigType = types.get(0).getId()
        IFtyDeviceConfigInfoProvider ftyDeviceConfigInfoProvider = (IFtyDeviceConfigInfoProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceConfigInfoProvider")
        String xml = ftyDeviceConfigInfoProvider.getRemoteConfigXml(fileTypeCode, produceProcessId, deviceId, deviceConfigType)
        if (StringUtils.isNotBlank(xml)) {
            jsonViewObject.noErrorPack(xml)
        } else {
            jsonViewObject.pack(ErrorCodes.NO_REMOTE_CONFIG_XML, "")
        }
    } else {
        jsonViewObject.pack(ErrorCodes.DEVICE_FILE_TYPE_NOT_FOUND, "")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;