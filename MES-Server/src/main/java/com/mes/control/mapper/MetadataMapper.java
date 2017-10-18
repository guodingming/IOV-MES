package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.Metadata;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
public interface MetadataMapper extends BaseInterfaceMapper<Metadata> {
    /**
     * 删除所有元数据信息
     */
    void deleteAll();

    public List<Metadata> findByTableId(String tableId);

    public boolean deleteByTableId(String tableId);
}
