package com.mes.control.provider;

import com.mes.control.mapper.FtyDeviceFaultMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceFaultProvider;
import com.mes.entity.control.FtyDeviceFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceFaultProviderImpl extends BaseProviderImpl<FtyDeviceFault> implements IFtyDeviceFaultProvider {
	@Autowired
	@Qualifier("ftyDeviceFaultMapper")
	private FtyDeviceFaultMapper ftyDeviceFaultMapper;

	@Override
	public FtyDeviceFaultMapper getBaseInterfaceMapper() {
		return ftyDeviceFaultMapper;
	}
}
