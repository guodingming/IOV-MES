package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpDataDictionaryMapper;
import com.mes.control.mapper.DpDataDictionaryTypeMapper;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.DpDataDictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * 开发平台-数据字典表
*/
public class DpDataDictionaryProviderImpl extends BaseProviderImpl<DpDataDictionary> implements IDpDataDictionaryProvider {
	@Autowired
	@Qualifier("dpDataDictionaryMapper")
	private DpDataDictionaryMapper dpDataDictionaryMapper;

	@Autowired
	@Qualifier("dpDataDictionaryTypeMapper")
	private DpDataDictionaryTypeMapper dpDataDictionaryTypeMapper;

	@Override
	public DpDataDictionaryMapper getBaseInterfaceMapper() {
		return dpDataDictionaryMapper;
	}

	@Override
	public List<DpDataDictionary> findDictionaryByTypeKey(String typeKey) throws DubboProviderException {
		List<DpDataDictionary> dpDataDictionaryList = Lists.newArrayList();
		try {
			if (StringUtils.isNotBlank(typeKey)) {
				DpDataDictionaryType dpDataDictionaryType = this.dpDataDictionaryTypeMapper.findBykey(typeKey);
				if (null != dpDataDictionaryType) {
					dpDataDictionaryList = this.dpDataDictionaryMapper.findByTypeId(dpDataDictionaryType.getId());
				}
			}
		} catch (Exception e) {
			throw new DubboProviderException(e.getMessage(), e);
		}
		return dpDataDictionaryList;
	}
}
