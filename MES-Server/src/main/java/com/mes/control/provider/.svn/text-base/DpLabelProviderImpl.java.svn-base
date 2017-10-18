package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpLabelMapper;
import com.mes.dubbo.interprovider.control.IDpLabelProvider;
import com.mes.entity.control.DpLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * 开发平台-标签管理
*/
public class DpLabelProviderImpl extends BaseProviderImpl<DpLabel> implements IDpLabelProvider {
	@Autowired
	@Qualifier("dpLabelMapper")
	private DpLabelMapper dpLabelMapper;

	@Override
	public DpLabelMapper getBaseInterfaceMapper() {
		return dpLabelMapper;
	}

	public List<DpLabel> findByTypeId(String typeId) throws DubboProviderException {
		List<DpLabel> list = null;
		list = dpLabelMapper.findByTypeId(typeId);
		return list;
	}
}
