package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.FtyDeviceType;

import java.util.List;

public interface FtyDeviceTypeMapper extends BaseInterfaceMapper<FtyDeviceType> {
    /**
     * 根据设备id查询设备配置类型列表
     *
     * @param deviceId
     * @return
     */
    List<DpDataDictionary> getDeviceConfigTypes(String deviceId);

    int countUsage(String deviceTypeId);
}
