package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.FtyDevice;

import java.util.List;

public interface FtyDeviceMapper extends BaseInterfaceMapper<FtyDevice> {
    /**
     * 根据工单id查询对应的设备列表
     *
     * @param workOrderId
     * @return
     */
    List<FtyDevice> getDevicesByWorkOrder(String workOrderId);

    /**
     * 根据processId查询对应的设备列表
     *
     * @param processId
     * @return
     */
    List<FtyDevice> findDevicesByProcess(String processId);

    public FtyDevice findByIp(String ip);
}
