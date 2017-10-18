package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpTemplateMapper;
import com.mes.control.mapper.DpTemplateTypeMapper;
import com.mes.dubbo.interprovider.control.IDpTemplateTypeProvider;
import com.mes.entity.control.DpTemplateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-模板分类
*/
public class DpTemplateTypeProviderImpl extends BaseProviderImpl<DpTemplateType> implements IDpTemplateTypeProvider {
	@Autowired
	@Qualifier("dpTemplateTypeMapper")
	private DpTemplateTypeMapper dpTemplateTypeMapper;
	@Autowired
	@Qualifier("dpTemplateMapper")
	private DpTemplateMapper dpTemplateMapper;

	@Override
	public DpTemplateTypeMapper getBaseInterfaceMapper() {
		return dpTemplateTypeMapper;
	}

	/**
	 * 验证模板分类下是否有数据
	 * @param id
	 * @return
	 * ledengyun--2017/09/22
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{
		List list = null;
		boolean flag = true;
		Map map = new HashMap();
		map.put("templateTypeId",id);
		list = dpTemplateMapper.findByMap(map);
		if (list.size()>0){
			flag = false;
		}
		return flag;
	}
}
