package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpSampleInspection;

import java.util.List;

/**
 * 产品管理-抽检管理
 * Created by xiuyou.xu on 2017/09/12.
 */
public interface DpSampleInspectionMapper extends BaseInterfaceMapper<DpSampleInspection> {

    /**
     * 根据工单查询抽检信息
     *
     * @param workOrderId
     * @return
     */
    public List<DpSampleInspection> findByWorkOrder(String workOrderId);

}
