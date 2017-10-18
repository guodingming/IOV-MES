package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.FtyDeviceFaultInfoMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceFaultInfoProvider;
import com.mes.entity.control.FtyDeviceFaultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceFaultInfoProviderImpl extends BaseProviderImpl<FtyDeviceFaultInfo> implements IFtyDeviceFaultInfoProvider {
	@Autowired
	@Qualifier("ftyDeviceFaultInfoMapper")
	private FtyDeviceFaultInfoMapper ftyDeviceFaultInfoMapper;

	@Override
	public FtyDeviceFaultInfoMapper getBaseInterfaceMapper() {
		return ftyDeviceFaultInfoMapper;
	}

	/**
	 * 验证分类下是否有数据
	 * @param id
	 * @return
	 * ledengyun--2017/10/13
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{

		int usage;
		boolean flag = true;
		usage = ftyDeviceFaultInfoMapper.countUsage(id);
		if(usage>0){
			flag = false;
		}
		return flag;
	}
}
