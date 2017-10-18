package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpSubassemblyMapper;
import com.mes.control.mapper.DpSubassemblyTypeMapper;
import com.mes.dubbo.interprovider.control.IDpSubassemblyTypeProvider;
import com.mes.entity.control.DpSubassemblyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-组件分类
*/
public class DpSubassemblyTypeProviderImpl extends BaseProviderImpl<DpSubassemblyType> implements IDpSubassemblyTypeProvider {
	@Autowired
	@Qualifier("dpSubassemblyTypeMapper")
	private DpSubassemblyTypeMapper dpSubassemblyTypeMapper;

	@Autowired
	@Qualifier("dpSubassemblyMapper")
	private DpSubassemblyMapper dpSubassemblyMapper;
	@Override
	public DpSubassemblyTypeMapper getBaseInterfaceMapper() {
		return dpSubassemblyTypeMapper;
	}


	/**
	 * 验证分类下是否有数据
	 * @param id
	 * @return
	 * ledengyun-2017/09/22
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{
		List list = null;
		boolean flag = true;
		Map map = new HashMap();
		map.put("subassemblyTypeId",id);
		list = dpSubassemblyMapper.findByMap(map);
		if (list.size()>0){
			flag = false;
		}
		return flag;
	}
}
