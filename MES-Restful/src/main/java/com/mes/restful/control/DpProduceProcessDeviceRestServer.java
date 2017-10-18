package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceProcessDeviceProvider;
import com.mes.entity.control.DpProduceProcessDevice;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 生产工序-设备
*/
@Api(value = "生产工序-设备", description = "生产工序-设备")
@Path(RestConstants.RestPathPrefix.DPPRODUCEPROCESSDEVICE)
public class DpProduceProcessDeviceRestServer extends BaseRestServerInterfaceImpl<DpProduceProcessDevice> {
	@Override
	public IDpProduceProcessDeviceProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProduceProcessDeviceProvider();
	}
}
