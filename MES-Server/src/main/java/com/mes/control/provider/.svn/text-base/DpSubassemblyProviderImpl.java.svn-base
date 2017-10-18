package com.mes.control.provider;

import com.mes.control.mapper.DpSubassemblyMapper;
import com.mes.dubbo.interprovider.control.IDpSubassemblyProvider;
import com.mes.entity.control.DpSubassembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-组件管理
*/
public class DpSubassemblyProviderImpl extends BaseProviderImpl<DpSubassembly> implements IDpSubassemblyProvider {
	@Autowired
	@Qualifier("dpSubassemblyMapper")
	private DpSubassemblyMapper dpSubassemblyMapper;

	@Override
	public DpSubassemblyMapper getBaseInterfaceMapper() {
		return dpSubassemblyMapper;
	}
}
