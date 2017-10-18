package com.mes.control.groovy

import com.google.common.collect.Lists
import com.mes.common.framework.config.ConfigHelper
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.control.device.DeviceTooling
import com.mes.control.device.RemoteConfig
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigInfoProvider
import com.mes.dubbo.interprovider.control.IFtyDeviceProcessAnnexProvider
import com.mes.entity.control.DpDataDictionary

/**
 * 只获取远程配置的工装名称、通道数据、传感器数量
 *
 * Created by xiuyou.xu on 2017/8/29.
 */

JsonViewObject jsonViewObject = new JsonViewObject();
try {
    String xml = parameter.getRequestMap().get("taskInfo");
    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml)
    String deviceId = taskInfoItem.getTaskInfo().getMachineId()
    String produceProcessId = taskInfoItem.getTaskInfo().getProcedureId()
    IFtyDeviceProcessAnnexProvider ftyDeviceProcessAnnexProvider = (IFtyDeviceProcessAnnexProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceProcessAnnexProvider")
    Map<String, Object> annexInfo = ftyDeviceProcessAnnexProvider.getDeviceAnnexInfo(deviceId, "工装", produceProcessId)
    if (annexInfo != null) {
        DeviceTooling deviceTooling = new DeviceTooling()
        List<DeviceTooling.PreMachineTb> preMachineTbs = Lists.newArrayList()
        DeviceTooling.PreMachineTb preMachineTb = new DeviceTooling.PreMachineTb()
        preMachineTb.setMachineId(annexInfo.get("id"))
        preMachineTb.setMachineName(annexInfo.get("name"))
        IDpDataDictionaryProvider dataDictionaryProvider = ServiceBeanContext.getInstance().getBean("dpDataDictionaryProvider");
        //获取远程配置类型id
        String typeKey = ConfigHelper.getValue("device.dic.type");
        List<DpDataDictionary> dataDictionaryList = dataDictionaryProvider.findDictionaryByTypeKey(typeKey);
        String deviceConfigType = ""
        for (DpDataDictionary dataDictionary : dataDictionaryList) {
            if (dataDictionary.getValuev().equals("1")) {
                deviceConfigType = dataDictionary.getId()
            }
        }
        IFtyDeviceConfigInfoProvider ftyDeviceConfigInfoProvider = (IFtyDeviceConfigInfoProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceConfigInfoProvider")

        String str = ftyDeviceConfigInfoProvider.getRemoteConfigXml("", produceProcessId, deviceId, deviceConfigType)
        if (str != null && !str.isEmpty()) {
            RemoteConfig remoteConfig = JaxbUtil.unmarshal(RemoteConfig.class, str)
            if (remoteConfig != null && remoteConfig.getItems() != null && !remoteConfig.getItems().isEmpty()) {
                remoteConfig.getItems().each { item ->
                    if ("通道数量".equals(item.getName())) {
                        preMachineTb.setChannelNumber(item.getValue())
                    }
                    if ("实现方式".equals(item.getName())) {
                        preMachineTb.setRealizeType(item.getValue())
                    }
                    if ("温度传感器".equals(item.getName())) {
                        preMachineTb.setTemperatureSensor(item.getValue())
                    }
                }
            }

            preMachineTbs.add(preMachineTb)
            deviceTooling.setPreMachineTbs(preMachineTbs)

            jsonViewObject.noErrorPack(JaxbUtil.marshal(DeviceTooling.class, deviceTooling))
        } else {
            jsonViewObject.pack(ErrorCodes.NO_REMOTE_CONFIG_XML, "")
        }
    } else {
        jsonViewObject.pack(ErrorCodes.NO_DEVICE_ANNEX, "")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;