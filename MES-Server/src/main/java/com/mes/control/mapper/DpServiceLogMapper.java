package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpServiceLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-服务日志
 */
public interface DpServiceLogMapper extends BaseInterfaceMapper<DpServiceLog> {
    /**
     * 按时间段查询服务调用统计结果
     *
     * @param serviceId
     * @param start
     * @param end
     * @param periodType
     * @param status
     * @return
     */
    List<Map<String, Object>> query(@Param("serviceId") String serviceId, @Param("start") Date start, @Param("end") Date end, @Param("periodType") String periodType, @Param("status") int status);
}
