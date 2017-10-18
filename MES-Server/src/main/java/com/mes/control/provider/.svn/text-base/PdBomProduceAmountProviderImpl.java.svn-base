package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdBomProduceAmountMapper;
import com.mes.dubbo.interprovider.control.IPdBomProduceAmountProvider;
import com.mes.entity.control.PdBomProduceAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-生产BOM管理用量
*/
public class PdBomProduceAmountProviderImpl extends BaseProviderImpl<PdBomProduceAmount> implements IPdBomProduceAmountProvider {
	@Autowired
	@Qualifier("pdBomProduceAmountMapper")
	private PdBomProduceAmountMapper pdBomProduceAmountMapper;

	@Override
	public PdBomProduceAmountMapper getBaseInterfaceMapper() {
		return pdBomProduceAmountMapper;
	}

	@Override
	public List<Map<String, Object>> getMaterialVersions(String bomProduceId) throws DubboProviderException {
		return pdBomProduceAmountMapper.getMaterialVersions(bomProduceId);
	}
}
