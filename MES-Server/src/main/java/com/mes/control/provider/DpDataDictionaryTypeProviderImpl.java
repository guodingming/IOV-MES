package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpDataDictionaryTypeMapper;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryTypeProvider;
import com.mes.entity.control.DpDataDictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-数据字典类型
*/
public class DpDataDictionaryTypeProviderImpl extends BaseProviderImpl<DpDataDictionaryType> implements IDpDataDictionaryTypeProvider {
	@Autowired
	@Qualifier("dpDataDictionaryTypeMapper")
	private DpDataDictionaryTypeMapper dpDataDictionaryTypeMapper;

	@Override
	public DpDataDictionaryTypeMapper getBaseInterfaceMapper() {
		return dpDataDictionaryTypeMapper;
	}

	/**
	 * 验证分类下是否有数据
	 * @param id
	 * @return
	 * ledengyun--2017/09/22
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{
		int usage;
		boolean flag = true;
		usage = dpDataDictionaryTypeMapper.countUsage(id);
		if(usage>0){
			flag = false;
		}
	return flag;
	}
}
