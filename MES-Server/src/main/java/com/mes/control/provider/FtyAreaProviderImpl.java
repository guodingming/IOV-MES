package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.FtyAreaMapper;
import com.mes.dubbo.interprovider.control.IFtyAreaProvider;
import com.mes.entity.control.FtyArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyAreaProviderImpl extends BaseProviderImpl<FtyArea> implements IFtyAreaProvider {
	@Autowired
	@Qualifier("ftyAreaMapper")
	private FtyAreaMapper ftyAreaMapper;

	@Override
	public FtyAreaMapper getBaseInterfaceMapper() {
		return ftyAreaMapper;
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
		usage = ftyAreaMapper.countUsage(id);
		if(usage>0){
			flag = false;
		}
		return flag;
	}
}
