package com.mes.control.provider;

import com.mes.control.mapper.DpProduceProcessDeviceAnnexMapper;
import com.mes.dubbo.interprovider.control.IDpProduceProcessDeviceAnnexProvider;
import com.mes.entity.control.DpProduceProcessDeviceAnnex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-设备配置-工序-设备附件
*/
public class DpProduceProcessDeviceAnnexProviderImpl extends BaseProviderImpl<DpProduceProcessDeviceAnnex> implements IDpProduceProcessDeviceAnnexProvider {
	@Autowired
	@Qualifier("dpProduceProcessDeviceAnnexMapper")
	private DpProduceProcessDeviceAnnexMapper dpProduceProcessDeviceAnnexMapper;

	@Override
	public DpProduceProcessDeviceAnnexMapper getBaseInterfaceMapper() {
		return dpProduceProcessDeviceAnnexMapper;
	}
}
