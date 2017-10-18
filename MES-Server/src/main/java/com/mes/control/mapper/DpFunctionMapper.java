package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpFunction;

import java.util.List;

/**
 * 开发平台-脚本
*/
public interface DpFunctionMapper extends BaseInterfaceMapper<DpFunction> {
    public List<DpFunction> findByFuntionTypeId(String funtionTypeId);
}
