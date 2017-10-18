package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.FtyDeviceConfig;
import com.mes.entity.control.FtyDeviceConfigTypes;

public interface IFtyDeviceConfigProvider extends DubboBaseInterface<FtyDeviceConfig> {
    /**
     * 关联设备到多个设备配置类型
     *
     * @param ftyDeviceConfigTypes
     * @return
     */
    boolean saveDeviceConfigTypes(FtyDeviceConfigTypes ftyDeviceConfigTypes) throws DubboProviderException;

    /**
     * 根据设备id删除设备和其配置类型关联关系
     *
     * @param deviceId
     */
    void deleteAll(String deviceId) throws DubboProviderException;
}
