package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdExecSystemModuleCopy;

import java.util.List;
import java.util.Map;

/**
 * $table.description
 * Created by xiuyou.xu on 2017/09/01.
 */
public interface PdExecSystemModuleCopyMapper extends BaseInterfaceMapper<PdExecSystemModuleCopy> {

    /**
     * 查询关联表
     *
     * @param systemName
     * @return
     */
    List<Map<String,Object>> getRelationTables(String systemName);
}
