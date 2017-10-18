package com.mes.control.provider;

import com.mes.control.mapper.DpMaterialMapper;
import com.mes.dubbo.interprovider.control.IDpMaterialProvider;
import com.mes.entity.control.DpMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-素材管理
*/
public class DpMaterialProviderImpl extends BaseProviderImpl<DpMaterial> implements IDpMaterialProvider {
	@Autowired
	@Qualifier("dpMaterialMapper")
	private DpMaterialMapper dpMaterialMapper;

	@Override
	public DpMaterialMapper getBaseInterfaceMapper() {
		return dpMaterialMapper;
	}
}
