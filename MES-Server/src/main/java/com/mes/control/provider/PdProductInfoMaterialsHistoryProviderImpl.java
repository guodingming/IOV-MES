package com.mes.control.provider;

import com.mes.control.mapper.PdProductInfoMaterialsHistoryMapper;
import com.mes.dubbo.interprovider.control.IPdProductInfoMaterialsHistoryProvider;
import com.mes.entity.control.PdProductInfoMaterialsHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-产品明细-物料-历史
*/
public class PdProductInfoMaterialsHistoryProviderImpl extends BaseProviderImpl<PdProductInfoMaterialsHistory> implements IPdProductInfoMaterialsHistoryProvider {
	@Autowired
	@Qualifier("pdProductInfoMaterialsHistoryMapper")
	private PdProductInfoMaterialsHistoryMapper pdProductInfoMaterialsHistoryMapper;

	@Override
	public PdProductInfoMaterialsHistoryMapper getBaseInterfaceMapper() {
		return pdProductInfoMaterialsHistoryMapper;
	}
}
