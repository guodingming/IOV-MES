package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdWorkOrder;

/**
 * 产品管理-工单管理
*/
public interface PdWorkOrderMapper extends BaseInterfaceMapper<PdWorkOrder> {

    public PdWorkOrder findByWorkOrderNum(String workOrderNum);
}
