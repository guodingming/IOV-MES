package com.mes.control.provider;

import com.mes.control.mapper.PdProductInfoNumberHistoryMapper;
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberHistoryProvider;
import com.mes.entity.control.PdProductInfoNumberHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-产品明细-产品编码(历史)
*/
public class PdProductInfoNumberHistoryProviderImpl extends BaseProviderImpl<PdProductInfoNumberHistory> implements IPdProductInfoNumberHistoryProvider {
	@Autowired
	@Qualifier("pdProductInfoNumberHistoryMapper")
	private PdProductInfoNumberHistoryMapper pdProductInfoNumberHistoryMapper;

	@Override
	public PdProductInfoNumberHistoryMapper getBaseInterfaceMapper() {
		return pdProductInfoNumberHistoryMapper;
	}
}
