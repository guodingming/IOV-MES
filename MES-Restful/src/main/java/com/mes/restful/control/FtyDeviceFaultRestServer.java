package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceFaultProvider;
import com.mes.entity.control.FtyDeviceFault;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

@Api(value = "工厂管理-设备异常管理", description = "工厂管理-设备异常管理")
@Path(RestConstants.RestPathPrefix.FTYDEVICEFAULT)
public class FtyDeviceFaultRestServer extends BaseRestServerInterfaceImpl<FtyDeviceFault> {
	@Override
	public IFtyDeviceFaultProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceFaultProvider();
	}
}
