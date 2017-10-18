package com.mes.control.provider;

import com.mes.control.mapper.FtyDeviceFixtureMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceFixtureProvider;
import com.mes.entity.control.FtyDeviceFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceFixtureProviderImpl extends BaseProviderImpl<FtyDeviceFixture> implements IFtyDeviceFixtureProvider {
	@Autowired
	@Qualifier("ftyDeviceFixtureMapper")
	private FtyDeviceFixtureMapper ftyDeviceFixtureMapper;

	@Override
	public FtyDeviceFixtureMapper getBaseInterfaceMapper() {
		return ftyDeviceFixtureMapper;
	}
}
