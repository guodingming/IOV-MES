package com.mes.control.provider;

import com.mes.control.mapper.PdBarcodeRuleTypeMapper;
import com.mes.dubbo.interprovider.control.IPdBarcodeRuleTypeProvider;
import com.mes.entity.control.PdBarcodeRuleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-条码规则分类
*/
public class PdBarcodeRuleTypeProviderImpl extends BaseProviderImpl<PdBarcodeRuleType> implements IPdBarcodeRuleTypeProvider {
	@Autowired
	@Qualifier("pdBarcodeRuleTypeMapper")
	private PdBarcodeRuleTypeMapper pdBarcodeRuleTypeMapper;

	@Override
	public PdBarcodeRuleTypeMapper getBaseInterfaceMapper() {
		return pdBarcodeRuleTypeMapper;
	}
}
