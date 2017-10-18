package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.control.mapper.FtyProductionLineMapper;
import com.mes.dubbo.interprovider.control.IFtyProductionLineProvider;
import com.mes.entity.control.FtyProductionLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

public class FtyProductionLineProviderImpl extends BaseProviderImpl<FtyProductionLine> implements IFtyProductionLineProvider {
	@Autowired
	@Qualifier("ftyProductionLineMapper")
	private FtyProductionLineMapper ftyProductionLineMapper;

	@Override
	public FtyProductionLineMapper getBaseInterfaceMapper() {
		return ftyProductionLineMapper;
	}

	@Override
	public Page getPageByAreaId(Page page) throws DubboProviderException {
		Map<String ,Object> params = Maps.newHashMap();
		if(page != null && page.getCondition() != null && Map.class.isInstance(page.getCondition())){
			params = (Map)page.getCondition();
		}
		return findByPage(page,params);
	}

	/**
	 * 验证生产线下是否有工作中心
	 * @param id
	 * @return
	 * ledengyun--2017/10/13
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{

		int usage;
		boolean flag = true;
		usage = ftyProductionLineMapper.countUsage(id);
		if(usage>0){
			flag = false;
		}
		return flag;
	}


}
