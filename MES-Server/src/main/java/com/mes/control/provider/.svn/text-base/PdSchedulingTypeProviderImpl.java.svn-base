package com.mes.control.provider;

import com.mes.control.mapper.PdSchedulingTypeMapper;
import com.mes.dubbo.interprovider.control.IPdSchedulingTypeProvider;
import com.mes.entity.control.PdSchedulingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 产品管理-班次类型
*/
public class PdSchedulingTypeProviderImpl extends BaseProviderImpl<PdSchedulingType> implements IPdSchedulingTypeProvider {
	@Autowired
	@Qualifier("pdSchedulingTypeMapper")
	private PdSchedulingTypeMapper pdSchedulingTypeMapper;

	@Override
	public PdSchedulingTypeMapper getBaseInterfaceMapper() {
		return pdSchedulingTypeMapper;
	}
}
