package com.mes.control.provider;

import com.mes.control.mapper.DpBarcodeTypeMapper;
import com.mes.dubbo.interprovider.control.IDpBarcodeTypeProvider;
import com.mes.entity.control.DpBarcodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-条码类别
*/
public class DpBarcodeTypeProviderImpl extends BaseProviderImpl<DpBarcodeType> implements IDpBarcodeTypeProvider {
	@Autowired
	@Qualifier("dpBarcodeTypeMapper")
	private DpBarcodeTypeMapper dpBarcodeTypeMapper;

	@Override
	public DpBarcodeTypeMapper getBaseInterfaceMapper() {
		return dpBarcodeTypeMapper;
	}
}
