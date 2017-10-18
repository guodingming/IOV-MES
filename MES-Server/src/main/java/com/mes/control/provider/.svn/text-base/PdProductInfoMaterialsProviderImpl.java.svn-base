package com.mes.control.provider;

import com.mes.control.mapper.PdProductInfoMaterialsMapper;
import com.mes.dubbo.interprovider.control.IPdProductInfoMaterialsProvider;
import com.mes.entity.control.PdProductInfoMaterials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-产品明细-物料
*/
public class PdProductInfoMaterialsProviderImpl extends BaseProviderImpl<PdProductInfoMaterials> implements IPdProductInfoMaterialsProvider {
	@Autowired
	@Qualifier("pdProductInfoMaterialsMapper")
	private PdProductInfoMaterialsMapper pdProductInfoMaterialsMapper;

	@Override
	public PdProductInfoMaterialsMapper getBaseInterfaceMapper() {
		return pdProductInfoMaterialsMapper;
	}
}
