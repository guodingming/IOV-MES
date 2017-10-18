package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpFunctionMapper;
import com.mes.control.mapper.DpFunctionTypeMapper;
import com.mes.dubbo.interprovider.control.IDpFunctionTypeProvider;
import com.mes.entity.control.DpFunction;
import com.mes.entity.control.DpFunctionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * 开发平台-函数分类
*/
public class DpFunctionTypeProviderImpl extends BaseProviderImpl<DpFunctionType> implements IDpFunctionTypeProvider {
	@Autowired
	@Qualifier("dpFunctionTypeMapper")
	private DpFunctionTypeMapper dpFunctionTypeMapper;
	@Autowired
	@Qualifier("dpFunctionMapper")
	private DpFunctionMapper dpFunctionMapper;

	@Override
	public DpFunctionTypeMapper getBaseInterfaceMapper() {
		return dpFunctionTypeMapper;
	}

	public boolean deleteById(String id) throws DubboProviderException{
		boolean flag = false;
		List<DpFunction>  dpFunction = dpFunctionMapper.findByFuntionTypeId(id);
		if (dpFunction.size()>0){
			flag = false;
		}else {
			dpFunctionTypeMapper.deleteById(id);
			flag = true;
		}
	return flag;
	}
}
