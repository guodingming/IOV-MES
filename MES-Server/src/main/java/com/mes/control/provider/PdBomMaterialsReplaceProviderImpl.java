package com.mes.control.provider;

import com.mes.control.mapper.PdBomMaterialsReplaceMapper;
import com.mes.dubbo.interprovider.control.IPdBomMaterialsReplaceProvider;
import com.mes.entity.control.PdBomMaterialsReplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 产品管理-BOM替换料
*/
public class PdBomMaterialsReplaceProviderImpl extends BaseProviderImpl<PdBomMaterialsReplace> implements IPdBomMaterialsReplaceProvider {
	@Autowired
	@Qualifier("pdBomMaterialsReplaceMapper")
	private PdBomMaterialsReplaceMapper pdBomMaterialsReplaceMapper;

	@Override
	public PdBomMaterialsReplaceMapper getBaseInterfaceMapper() {
		return pdBomMaterialsReplaceMapper;
	}
}
