package com.mes.control.provider;

import com.mes.control.mapper.PdBarcodeRuleMapper;
import com.mes.dubbo.interprovider.control.IPdBarcodeRuleProvider;
import com.mes.entity.control.PdBarcodeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 产品管理-条码规则设置
*/
public class PdBarcodeRuleProviderImpl extends BaseProviderImpl<PdBarcodeRule> implements IPdBarcodeRuleProvider {
	@Autowired
	@Qualifier("pdBarcodeRuleMapper")
	private PdBarcodeRuleMapper pdBarcodeRuleMapper;

	@Override
	public PdBarcodeRuleMapper getBaseInterfaceMapper() {
		return pdBarcodeRuleMapper;
	}
}
