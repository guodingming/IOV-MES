package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProduceProcessDeviceConfig;

import java.util.Map;

/**
 * 开发平台-设备配置信息
*/
public interface IDpProduceProcessDeviceConfigProvider extends DubboBaseInterface<DpProduceProcessDeviceConfig> {


    /**
     * 根据工序ID 设备配置信息ID拷贝保存生产工序设备配置信息
     * @param dpProduceProcessDeviceConfig
     * @return
     * @throws DubboProviderException
     */
    public Map<String, Object> saveCopyConfig(DpProduceProcessDeviceConfig dpProduceProcessDeviceConfig) throws DubboProviderException;

}
