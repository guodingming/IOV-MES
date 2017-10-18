package com.mes.control.provider;

import com.mes.control.mapper.DpProductInfoLogHistoryMapper;
import com.mes.dubbo.interprovider.control.IDpProductInfoLogHistoryProvider;
import com.mes.entity.control.DpProductInfoLogHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-产品生产工序记录--历史表
*/
public class DpProductInfoLogHistoryProviderImpl extends BaseProviderImpl<DpProductInfoLogHistory> implements IDpProductInfoLogHistoryProvider {
	@Autowired
	@Qualifier("dpProductInfoLogHistoryMapper")
	private DpProductInfoLogHistoryMapper dpProductInfoLogHistoryMapper;

	@Override
	public DpProductInfoLogHistoryMapper getBaseInterfaceMapper() {
		return dpProductInfoLogHistoryMapper;
	}
}
