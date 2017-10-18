package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpProduceProcessConfig;
import org.apache.ibatis.annotations.Param;

/**
 * 开发平台-生产工序配置属性
*/
public interface DpProduceProcessConfigMapper extends BaseInterfaceMapper<DpProduceProcessConfig> {
    DpProduceProcessConfig getConfig(@Param("key") String dicKey, @Param("produceProcessId") String produceProcessId);
}
