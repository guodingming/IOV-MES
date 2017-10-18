package com.mes.control.provider;

import com.mes.control.mapper.FtyDeviceToolingMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceToolingProvider;
import com.mes.entity.control.FtyDeviceTooling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceToolingProviderImpl extends BaseProviderImpl<FtyDeviceTooling> implements IFtyDeviceToolingProvider {
	@Autowired
	@Qualifier("ftyDeviceToolingMapper")
	private FtyDeviceToolingMapper ftyDeviceToolingMapper;

	@Override
	public FtyDeviceToolingMapper getBaseInterfaceMapper() {
		return ftyDeviceToolingMapper;
	}
}
