package com.mes.control.provider;

import com.mes.control.mapper.DpProcessConfigMapper;
import com.mes.dubbo.interprovider.control.IDpProcessConfigProvider;
import com.mes.entity.control.DpProcessConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台--生产工序配置属性
*/
public class DpProcessConfigProviderImpl extends BaseProviderImpl<DpProcessConfig> implements IDpProcessConfigProvider {
	@Autowired
	@Qualifier("dpProcessConfigMapper")
	private DpProcessConfigMapper dpProcessConfigMapper;

	@Override
	public DpProcessConfigMapper getBaseInterfaceMapper() {
		return dpProcessConfigMapper;
	}
}
