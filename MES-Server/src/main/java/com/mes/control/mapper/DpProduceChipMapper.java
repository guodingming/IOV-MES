package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpProduceChip;

import java.util.List;

/**
 * 开发平台-产品芯片
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface DpProduceChipMapper extends BaseInterfaceMapper<DpProduceChip> {

    /**
     * 根据生产工序id删除
     *
     * @param produceProcessId
     */
    void deleteByProduceProcessId(String produceProcessId);

    /**
     * 根据生产工序id查询
     *
     * @param produceProcessId
     * @return
     */
    List<DpProduceChip> findByProduceProcessId(String produceProcessId);
}
