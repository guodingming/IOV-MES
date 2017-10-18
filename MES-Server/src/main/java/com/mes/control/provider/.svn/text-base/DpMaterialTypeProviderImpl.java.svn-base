package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpMaterialMapper;
import com.mes.control.mapper.DpMaterialTypeMapper;
import com.mes.dubbo.interprovider.control.IDpMaterialTypeProvider;
import com.mes.entity.control.DpMaterialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-素材分类
*/
public class DpMaterialTypeProviderImpl extends BaseProviderImpl<DpMaterialType> implements IDpMaterialTypeProvider {
	@Autowired
	@Qualifier("dpMaterialTypeMapper")
	private DpMaterialTypeMapper dpMaterialTypeMapper;

	@Autowired
	@Qualifier("dpMaterialMapper")
	private DpMaterialMapper dpMaterialMapper;
	@Override
	public DpMaterialTypeMapper getBaseInterfaceMapper() {
		return dpMaterialTypeMapper;
	}

	/**
	 * 验证分类下是否有数据
	 * @param id
	 * @return
	 * ledengyun--2017/09/22
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{
		List list = null;
		boolean flag = true;
		Map map = new HashMap();
		map.put("materialTypeId",id);
		list = dpMaterialMapper.findByMap(map);
		if (list.size()>0){
			flag = false;
		}
		return flag;
	}
}
