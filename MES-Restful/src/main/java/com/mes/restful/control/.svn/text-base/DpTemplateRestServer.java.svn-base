package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpTemplateProvider;
import com.mes.entity.control.DpTemplate;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-模板管理
*/
@Api(value = "开发平台-模板管理", description = "开发平台-模板管理")
@Path(RestConstants.RestPathPrefix.DPTEMPLATE)
public class DpTemplateRestServer extends BaseRestServerInterfaceImpl<DpTemplate> {
	@Override
	public IDpTemplateProvider getDubboBaseInterface() {
		return ControlConsumer.getDpTemplateProvider();
	}
}
