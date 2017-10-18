package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.FtyDeviceProcessAnnex;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FtyDeviceProcessAnnexMapper extends BaseInterfaceMapper<FtyDeviceProcessAnnex> {
    Map<String, Object> getDeviceAnnexInfo(@Param("deviceId") String deviceId, @Param("annexTypeName") String annexTypeName, @Param("produceProcessId") String produceProcessId);

    /**
     * 根据设备工序ID查询工序工装
     *
     * @param query
     * @return
     */
    public List<FtyDeviceProcessAnnex> findAnnexByDeviceProcessId(Map<String, Object> query);
    /**
     * 根据设备工序ID查询工序工装类型
     *
     * @param query
     * @return
     */
    public List<FtyDeviceProcessAnnex> findAnnexTypeByDeviceProcessId(Map<String, Object> query);
}
