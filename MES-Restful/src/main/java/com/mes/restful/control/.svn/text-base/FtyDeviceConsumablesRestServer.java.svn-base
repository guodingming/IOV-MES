package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceConsumablesProvider;
import com.mes.entity.control.FtyDeviceConsumables;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

@Api(value = "工厂管理-设备耗品", description = "工厂管理-设备耗品")
@Path(RestConstants.RestPathPrefix.FTYDEVICECONSUMABLES)
public class FtyDeviceConsumablesRestServer extends BaseRestServerInterfaceImpl<FtyDeviceConsumables> {
	@Override
	public IFtyDeviceConsumablesProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceConsumablesProvider();
	}
}
