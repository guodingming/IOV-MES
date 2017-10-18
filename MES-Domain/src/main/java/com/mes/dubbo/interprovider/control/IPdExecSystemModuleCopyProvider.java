package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdExecSystemModuleCopy;

import java.util.List;
import java.util.Map;

/**
 * $table.description
 * Created by xiuyou.xu on 2017/09/01.
 */
public interface IPdExecSystemModuleCopyProvider extends DubboBaseInterface<PdExecSystemModuleCopy> {
    /**
     * 查询关联表
     *
     * @param systemName
     * @return
     */
    List<Map<String, Object>> getRelationTables(String systemName);
}
