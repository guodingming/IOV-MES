package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.ExpandTableConfig;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
public interface ExpandTableConfigMapper extends BaseInterfaceMapper<ExpandTableConfig> {
    /**
     * 根据实体类名称获取对应的扩展表名
     * @param entityClass
     * @return
     */
    String getExpandTableName(String entityClass);

    /**
     * 根据扩展表名称查询扩展表关联主表外键字段名称
     * @param expandTableName
     * @return
     */
    String getExpandTablePkColumnName(String expandTableName);

    public ExpandTableConfig findByTableId(String tableId);

}
