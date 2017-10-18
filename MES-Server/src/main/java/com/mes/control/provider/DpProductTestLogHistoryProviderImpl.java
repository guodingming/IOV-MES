package com.mes.control.provider;

import com.mes.control.mapper.DpProductTestLogHistoryMapper;
import com.mes.dubbo.interprovider.control.IDpProductTestLogHistoryProvider;
import com.mes.entity.control.DpProductTestLogHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-产品测试项-历史表
*/
public class DpProductTestLogHistoryProviderImpl extends BaseProviderImpl<DpProductTestLogHistory> implements IDpProductTestLogHistoryProvider {
	@Autowired
	@Qualifier("dpProductTestLogHistoryMapper")
	private DpProductTestLogHistoryMapper dpProductTestLogHistoryMapper;

	@Override
	public DpProductTestLogHistoryMapper getBaseInterfaceMapper() {
		return dpProductTestLogHistoryMapper;
	}
}
