package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProductTestLogProvider;
import com.mes.entity.control.DpProductTestLog;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品测试项
*/
@Api(value = "开发平台-产品测试项", description = "开发平台-产品测试项")
@Path(RestConstants.RestPathPrefix.DPPRODUCTTESTLOG)
public class DpProductTestLogRestServer extends BaseRestServerInterfaceImpl<DpProductTestLog> {
	@Override
	public IDpProductTestLogProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProductTestLogProvider();
	}
}
