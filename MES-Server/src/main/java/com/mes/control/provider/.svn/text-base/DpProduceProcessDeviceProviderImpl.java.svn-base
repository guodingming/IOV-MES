package com.mes.control.provider;

import com.mes.control.mapper.DpProduceProcessDeviceMapper;
import com.mes.dubbo.interprovider.control.IDpProduceProcessDeviceProvider;
import com.mes.entity.control.DpProduceProcessDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 生产工序-设备
*/
public class DpProduceProcessDeviceProviderImpl extends BaseProviderImpl<DpProduceProcessDevice> implements IDpProduceProcessDeviceProvider {
	@Autowired
	@Qualifier("dpProduceProcessDeviceMapper")
	private DpProduceProcessDeviceMapper dpProduceProcessDeviceMapper;

	@Override
	public DpProduceProcessDeviceMapper getBaseInterfaceMapper() {
		return dpProduceProcessDeviceMapper;
	}
}
