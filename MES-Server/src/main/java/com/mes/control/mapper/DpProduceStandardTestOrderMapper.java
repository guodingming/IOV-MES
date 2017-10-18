package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpProduceStandardTestOrder;

import java.util.List;

/**
 * 开发平台-产品测试标准-测试顺序
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface DpProduceStandardTestOrderMapper extends BaseInterfaceMapper<DpProduceStandardTestOrder> {

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
    List<DpProduceStandardTestOrder> findByProduceProcessId(String produceProcessId);
}
