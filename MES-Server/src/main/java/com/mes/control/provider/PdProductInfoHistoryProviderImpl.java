package com.mes.control.provider;

import com.mes.control.mapper.PdProductInfoHistoryMapper;
import com.mes.dubbo.interprovider.control.IPdProductInfoHistoryProvider;
import com.mes.entity.control.PdProductInfoHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-产品明细（按工单移）历史表
*/
public class PdProductInfoHistoryProviderImpl extends BaseProviderImpl<PdProductInfoHistory> implements IPdProductInfoHistoryProvider {
	@Autowired
	@Qualifier("pdProductInfoHistoryMapper")
	private PdProductInfoHistoryMapper pdProductInfoHistoryMapper;

	@Override
	public PdProductInfoHistoryMapper getBaseInterfaceMapper() {
		return pdProductInfoHistoryMapper;
	}
}
