package com.mes.control.provider;

import com.mes.control.mapper.FtyDeviceAnnexInfoMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceAnnexInfoProvider;
import com.mes.entity.control.FtyDeviceAnnexInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceAnnexInfoProviderImpl extends BaseProviderImpl<FtyDeviceAnnexInfo> implements IFtyDeviceAnnexInfoProvider {
	@Autowired
	@Qualifier("ftyDeviceAnnexInfoMapper")
	private FtyDeviceAnnexInfoMapper ftyDeviceAnnexInfoMapper;

	@Override
	public FtyDeviceAnnexInfoMapper getBaseInterfaceMapper() {
		return ftyDeviceAnnexInfoMapper;
	}
}
