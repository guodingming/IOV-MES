package com.mes.control.provider;

import com.mes.control.mapper.PdSchedulingWorkOrderMapper;
import com.mes.dubbo.interprovider.control.IPdSchedulingWorkOrderProvider;
import com.mes.entity.control.PdSchedulingWorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 产品管理-工单班次
*/
public class PdSchedulingWorkOrderProviderImpl extends BaseProviderImpl<PdSchedulingWorkOrder> implements IPdSchedulingWorkOrderProvider {
	@Autowired
	@Qualifier("pdSchedulingWorkOrderMapper")
	private PdSchedulingWorkOrderMapper pdSchedulingWorkOrderMapper;

	@Override
	public PdSchedulingWorkOrderMapper getBaseInterfaceMapper() {
		return pdSchedulingWorkOrderMapper;
	}
}
