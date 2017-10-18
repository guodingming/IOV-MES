package com.mes.control.provider;

import com.mes.control.mapper.FtyDeviceConsumablesMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceConsumablesProvider;
import com.mes.entity.control.FtyDeviceConsumables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceConsumablesProviderImpl extends BaseProviderImpl<FtyDeviceConsumables> implements IFtyDeviceConsumablesProvider {
	@Autowired
	@Qualifier("ftyDeviceConsumablesMapper")
	private FtyDeviceConsumablesMapper ftyDeviceConsumablesMapper;

	@Override
	public FtyDeviceConsumablesMapper getBaseInterfaceMapper() {
		return ftyDeviceConsumablesMapper;
	}
}
