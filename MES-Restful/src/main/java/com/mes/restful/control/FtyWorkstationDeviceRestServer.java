package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyWorkstationDeviceProvider;
import com.mes.entity.control.FtyWorkstationDevice;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import javax.ws.rs.Path;

@Api(value = "工厂管理-设备-工作站", description = "工厂管理-设备-工作站")
@Path(RestConstants.RestPathPrefix.FTYWORKSTATIONDEVICE)
public class FtyWorkstationDeviceRestServer extends BaseRestServerInterfaceImpl<FtyWorkstationDevice> {
	@Override
	public IFtyWorkstationDeviceProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyWorkstationDeviceProvider();
	}


}
