package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.Table;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
public interface TableMapper extends BaseInterfaceMapper<Table> {
    /**
     * 删除所有表信息
     */
    void deleteAll();
}
