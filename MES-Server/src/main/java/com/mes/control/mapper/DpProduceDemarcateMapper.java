package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpProduceChip;
import com.mes.entity.control.DpProduceDemarcate;

import java.util.List;

/**
 * 开发平台-产品标定
 * Created by xiuyou.xu on 2017/08/30.
 */
public interface DpProduceDemarcateMapper extends BaseInterfaceMapper<DpProduceDemarcate> {

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
    List<DpProduceDemarcate> findByProduceProcessId(String produceProcessId);

}
