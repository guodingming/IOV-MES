package com.mes.control.provider;

import com.mes.control.mapper.DpMaterialsInfoHistoryMapper;
import com.mes.dubbo.interprovider.control.IDpMaterialsInfoHistoryProvider;
import com.mes.entity.control.DpMaterialsInfoHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-上料管理-历史包
*/
public class DpMaterialsInfoHistoryProviderImpl extends BaseProviderImpl<DpMaterialsInfoHistory> implements IDpMaterialsInfoHistoryProvider {
	@Autowired
	@Qualifier("dpMaterialsInfoHistoryMapper")
	private DpMaterialsInfoHistoryMapper dpMaterialsInfoHistoryMapper;

	@Override
	public DpMaterialsInfoHistoryMapper getBaseInterfaceMapper() {
		return dpMaterialsInfoHistoryMapper;
	}
}
