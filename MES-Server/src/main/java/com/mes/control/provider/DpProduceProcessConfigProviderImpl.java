package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpProduceProcessConfigMapper;
import com.mes.dubbo.interprovider.control.IDpProduceProcessConfigProvider;
import com.mes.entity.control.DpProduceProcessConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-生产工序配置属性
*/
public class DpProduceProcessConfigProviderImpl extends BaseProviderImpl<DpProduceProcessConfig> implements IDpProduceProcessConfigProvider {
	@Autowired
	@Qualifier("dpProduceProcessConfigMapper")
	private DpProduceProcessConfigMapper dpProduceProcessConfigMapper;

	@Override
	public DpProduceProcessConfigMapper getBaseInterfaceMapper() {
		return dpProduceProcessConfigMapper;
	}

	@Override
	public DpProduceProcessConfig getConfig(String dicKey, String produceProcessId) throws DubboProviderException {
		return dpProduceProcessConfigMapper.getConfig(dicKey, produceProcessId);
	}
}
