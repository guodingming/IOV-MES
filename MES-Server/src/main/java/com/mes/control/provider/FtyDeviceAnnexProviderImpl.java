package com.mes.control.provider;

import com.mes.control.mapper.FtyDeviceAnnexMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceAnnexProvider;
import com.mes.entity.control.FtyDeviceAnnex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceAnnexProviderImpl extends BaseProviderImpl<FtyDeviceAnnex> implements IFtyDeviceAnnexProvider {
	@Autowired
	@Qualifier("ftyDeviceAnnexMapper")
	private FtyDeviceAnnexMapper ftyDeviceAnnexMapper;

	@Override
	public FtyDeviceAnnexMapper getBaseInterfaceMapper() {
		return ftyDeviceAnnexMapper;
	}
}
