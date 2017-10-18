package com.mes.control.provider;

import com.mes.control.mapper.MenuRestApiMapper;
import com.mes.dubbo.interprovider.control.IMenuRestApiProvider;
import com.mes.entity.control.MenuRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 菜单rest接口
*/
public class MenuRestApiProviderImpl extends BaseProviderImpl<MenuRestApi> implements IMenuRestApiProvider {
	@Autowired
	@Qualifier("menuRestApiMapper")
	private MenuRestApiMapper menuRestApiMapper;

	@Override
	public MenuRestApiMapper getBaseInterfaceMapper() {
		return menuRestApiMapper;
	}
}
