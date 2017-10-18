package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpProduceProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 产品管理--产品生产工序
 */
public interface DpProduceProcessMapper extends BaseInterfaceMapper<DpProduceProcess> {
    List<Map<String,Object>> getProduceProcesses(@Param("pdId") String pdId, @Param("isAuto") String isAuto);
}
