package com.mes.control.provider;

import com.mes.control.mapper.DpLabelTypeMapper;
import com.mes.dubbo.interprovider.control.IDpLabelTypeProvider;
import com.mes.entity.control.DpLabelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-标签类别
*/
public class DpLabelTypeProviderImpl extends BaseProviderImpl<DpLabelType> implements IDpLabelTypeProvider {
	@Autowired
	@Qualifier("dpLabelTypeMapper")
	private DpLabelTypeMapper dpLabelTypeMapper;

	@Override
	public DpLabelTypeMapper getBaseInterfaceMapper() {
		return dpLabelTypeMapper;
	}
}
