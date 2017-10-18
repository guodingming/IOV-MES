package com.mes.control.provider;

import com.mes.control.mapper.FtyDeviceProcessAnnexAssociationMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceProcessAnnexAssociationProvider;
import com.mes.entity.control.FtyDeviceProcessAnnexAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 设备管理-设备-工序-附件
*/
public class FtyDeviceProcessAnnexAssociationProviderImpl extends BaseProviderImpl<FtyDeviceProcessAnnexAssociation> implements IFtyDeviceProcessAnnexAssociationProvider {
	@Autowired
	@Qualifier("ftyDeviceProcessAnnexAssociationMapper")
	private FtyDeviceProcessAnnexAssociationMapper ftyDeviceProcessAnnexAssociationMapper;

	@Override
	public FtyDeviceProcessAnnexAssociationMapper getBaseInterfaceMapper() {
		return ftyDeviceProcessAnnexAssociationMapper;
	}
}
