package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdWorkOrderBatch;

/**
 * 产品管理-工单批次
*/
public interface IPdWorkOrderBatchProvider extends DubboBaseInterface<PdWorkOrderBatch> {
    public PdWorkOrderBatch findByWorkOrderId(String workOrderId) throws DubboProviderException;
}
