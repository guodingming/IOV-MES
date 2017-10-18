package com.mes.control.provider;

import com.mes.control.mapper.DpProduceProcessConfigWorkorderMapper;
import com.mes.dubbo.interprovider.control.IDpProduceProcessConfigWorkorderProvider;
import com.mes.entity.control.DpProduceProcessConfigWorkorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-设备配置信息-工单
*/
public class DpProduceProcessConfigWorkorderProviderImpl extends BaseProviderImpl<DpProduceProcessConfigWorkorder> implements IDpProduceProcessConfigWorkorderProvider {
	@Autowired
	@Qualifier("dpProduceProcessConfigWorkorderMapper")
	private DpProduceProcessConfigWorkorderMapper dpProduceProcessConfigWorkorderMapper;

	@Override
	public DpProduceProcessConfigWorkorderMapper getBaseInterfaceMapper() {
		return dpProduceProcessConfigWorkorderMapper;
	}
}
