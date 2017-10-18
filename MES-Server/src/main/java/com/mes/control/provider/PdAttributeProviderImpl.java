package com.mes.control.provider;

import com.mes.control.mapper.PdAttributeMapper;
import com.mes.dubbo.interprovider.control.IPdAttributeProvider;
import com.mes.entity.control.PdAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 产品管理-产品属性管理
*/
public class PdAttributeProviderImpl extends BaseProviderImpl<PdAttribute> implements IPdAttributeProvider {
	@Autowired
	@Qualifier("pdAttributeMapper")
	private PdAttributeMapper pdAttributeMapper;

	@Override
	public PdAttributeMapper getBaseInterfaceMapper() {
		return pdAttributeMapper;
	}
}
