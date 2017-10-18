package com.mes.control.provider;

import com.mes.control.mapper.DpProductTestLogMapper;
import com.mes.dubbo.interprovider.control.IDpProductTestLogProvider;
import com.mes.entity.control.DpProductTestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-产品测试项
*/
public class DpProductTestLogProviderImpl extends BaseProviderImpl<DpProductTestLog> implements IDpProductTestLogProvider {
	@Autowired
	@Qualifier("dpProductTestLogMapper")
	private DpProductTestLogMapper dpProductTestLogMapper;

	@Override
	public DpProductTestLogMapper getBaseInterfaceMapper() {
		return dpProductTestLogMapper;
	}
}
