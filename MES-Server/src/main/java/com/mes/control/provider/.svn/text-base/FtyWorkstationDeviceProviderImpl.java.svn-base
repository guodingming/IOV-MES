package com.mes.control.provider;

import com.mes.control.mapper.FtyWorkstationDeviceMapper;
import com.mes.dubbo.interprovider.control.IFtyWorkstationDeviceProvider;
import com.mes.entity.control.FtyWorkstationDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyWorkstationDeviceProviderImpl extends BaseProviderImpl<FtyWorkstationDevice> implements IFtyWorkstationDeviceProvider {
	@Autowired
	@Qualifier("ftyWorkstationDeviceMapper")
	private FtyWorkstationDeviceMapper ftyWorkstationDeviceMapper;

	@Override
	public FtyWorkstationDeviceMapper getBaseInterfaceMapper() {
		return ftyWorkstationDeviceMapper;
	}
}
