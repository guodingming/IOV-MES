package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.FtyDeviceTypeMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceTypeProvider;
import com.mes.entity.control.FtyDeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceTypeProviderImpl extends BaseProviderImpl<FtyDeviceType> implements IFtyDeviceTypeProvider {
	@Autowired
	@Qualifier("ftyDeviceTypeMapper")
	private FtyDeviceTypeMapper ftyDeviceTypeMapper;

	@Override
	public FtyDeviceTypeMapper getBaseInterfaceMapper() {
		return ftyDeviceTypeMapper;
	}

	/**
	 * 分类删除验证
	 * @param id
	 * @return
	 * lednegyun--2017/10/10
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{

		int usage;
		boolean flag = true;
		usage = ftyDeviceTypeMapper.countUsage(id);
		if(usage>0){
			flag = false;
		}
		return flag;
	}

}
