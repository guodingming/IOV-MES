package com.mes.control.mapper;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdWorkOrderBatch;

/**
 * 产品管理-工单批次
*/
public interface PdWorkOrderBatchMapper extends BaseInterfaceMapper<PdWorkOrderBatch> {
    public PdWorkOrderBatch findByWorkOrderId(String workOrderId);
}
