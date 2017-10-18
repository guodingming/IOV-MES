package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.FtyDeviceFaultProcessMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceFaultProcessProvider;
import com.mes.entity.control.FtyDeviceFaultProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class FtyDeviceFaultProcessProviderImpl extends BaseProviderImpl<FtyDeviceFaultProcess> implements IFtyDeviceFaultProcessProvider {
	@Autowired
	@Qualifier("ftyDeviceFaultProcessMapper")
	private FtyDeviceFaultProcessMapper ftyDeviceFaultProcessMapper;

	@Override
	public FtyDeviceFaultProcessMapper getBaseInterfaceMapper() {
		return ftyDeviceFaultProcessMapper;
	}

	public List<FtyDeviceFaultProcess> findByDeviceFaultInfoId(String deviceFaultInfoId)throws DubboProviderException{
		List<FtyDeviceFaultProcess> list = ftyDeviceFaultProcessMapper.findByDeviceFaultInfoId(deviceFaultInfoId);
		return list;
	}
}
