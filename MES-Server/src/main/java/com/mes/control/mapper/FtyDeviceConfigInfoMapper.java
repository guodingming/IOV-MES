package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.FtyDeviceConfigInfo;

import java.util.List;
import java.util.Map;

public interface FtyDeviceConfigInfoMapper extends BaseInterfaceMapper<FtyDeviceConfigInfo> {
    /**
     * 根据设备id和设备配置类型id分页查询设备配置信息
     *
     * @param params
     * @return
     */
    int getCountByConfigType(Map<String, Object> params);

    /**
     * 根据设备id和设备配置类型id分页查询设备配置信息
     *
     * @param params
     * @return
     */
    List findByPageByConfigType(Map<String, Object> params);

    /**
     * 根据设备ID及设备配置分类ID查询设备配置信息
     * @param params
     * @return
     */
    List<FtyDeviceConfigInfo> findAllByConfigType(Map<String, Object> params);

    /**
     * 查询远程配置文件路径
     * @param params
     * @return
     */
    String getRemoteConfig(Map<String, Object> params);
}
