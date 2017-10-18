package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdSchedulingDevice;

import java.util.List;
import java.util.Map;

/**
 * 产品管理--排班-设备
*/
public interface IPdSchedulingDeviceProvider extends DubboBaseInterface<PdSchedulingDevice> {

    void saveWorkstations(PdSchedulingDevice pdSchedulingDevice);

    List<PdSchedulingDevice> getRestWorkstation(Map<String,Object> map);
}
