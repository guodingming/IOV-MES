package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpFormMapper;
import com.mes.control.mapper.DpFormTypeMapper;
import com.mes.dubbo.interprovider.control.IDpFormTypeProvider;
import com.mes.entity.control.DpFormType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-表单类型管理
*/
public class DpFormTypeProviderImpl extends BaseProviderImpl<DpFormType> implements IDpFormTypeProvider {
	@Autowired
	@Qualifier("dpFormTypeMapper")
	private DpFormTypeMapper dpFormTypeMapper;

	@Autowired
	@Qualifier("dpFormMapper")
	private DpFormMapper dpFormMapper;

	@Override
	public DpFormTypeMapper getBaseInterfaceMapper() {
		return dpFormTypeMapper;
	}

	/**
	 * 验证分类下是否有数据
	 * @param id
	 * @return
	 * ledengyun-2017/09/22
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{
		boolean flag = true;
		Map map = new HashMap();
		map.put("formTypeId",id);
		List list = dpFormMapper.findByMap(map);
		if (list.size()>0){
			flag = false;
		}
		return flag;
	}
}
