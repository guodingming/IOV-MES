package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdWorkOrderBatchMapper;
import com.mes.dubbo.interprovider.control.IPdWorkOrderBatchProvider;
import com.mes.entity.control.PdWorkOrderBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 产品管理-工单批次
*/
public class PdWorkOrderBatchProviderImpl extends BaseProviderImpl<PdWorkOrderBatch> implements IPdWorkOrderBatchProvider {
	@Autowired
	@Qualifier("pdWorkOrderBatchMapper")
	private PdWorkOrderBatchMapper pdWorkOrderBatchMapper;

	@Override
	public PdWorkOrderBatchMapper getBaseInterfaceMapper() {
		return pdWorkOrderBatchMapper;
	}
	public PdWorkOrderBatch findByWorkOrderId(String workOrderId) throws DubboProviderException{
		PdWorkOrderBatch pdWorkOrderBatch = pdWorkOrderBatchMapper.findByWorkOrderId(workOrderId);
		return pdWorkOrderBatch;
	}
}
