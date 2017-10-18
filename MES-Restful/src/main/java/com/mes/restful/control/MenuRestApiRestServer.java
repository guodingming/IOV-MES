package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IMenuRestApiProvider;
import com.mes.entity.control.MenuRestApi;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 菜单rest接口
*/
@Api(value = "菜单rest接口", description = "菜单rest接口")
@Path(RestConstants.RestPathPrefix.MENURESTAPI)
public class MenuRestApiRestServer extends BaseRestServerInterfaceImpl<MenuRestApi> {
	@Override
	public IMenuRestApiProvider getDubboBaseInterface() {
		return ControlConsumer.getMenuRestApiProvider();
	}
}
