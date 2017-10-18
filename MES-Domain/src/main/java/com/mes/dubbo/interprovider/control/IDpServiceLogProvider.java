package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpServiceLog;
import com.mes.entity.control.ServiceMonitorLineData;

/**
 * 开发平台-服务日志
*/
public interface IDpServiceLogProvider extends DubboBaseInterface<DpServiceLog> {
    /**
     * 查询服务调用统计结果折线图数据
     *
     * @param serviceId
     * @param year
     * @param month
     * @return
     */
    ServiceMonitorLineData queryLineData(String serviceId, String year, String month);
}
