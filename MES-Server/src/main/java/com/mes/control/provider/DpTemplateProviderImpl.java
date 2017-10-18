package com.mes.control.provider;

import com.mes.control.mapper.DpTemplateMapper;
import com.mes.dubbo.interprovider.control.IDpTemplateProvider;
import com.mes.entity.control.DpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-模板管理
*/
public class DpTemplateProviderImpl extends BaseProviderImpl<DpTemplate> implements IDpTemplateProvider {
	@Autowired
	@Qualifier("dpTemplateMapper")
	private DpTemplateMapper dpTemplateMapper;

	@Override
	public DpTemplateMapper getBaseInterfaceMapper() {
		return dpTemplateMapper;
	}
}
