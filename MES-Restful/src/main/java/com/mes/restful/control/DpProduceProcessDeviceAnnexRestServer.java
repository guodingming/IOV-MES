package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceProcessDeviceAnnexProvider;
import com.mes.entity.control.DpProduceProcessDeviceAnnex;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-设备配置-工序-设备附件
*/
@Api(value = "开发平台-设备配置-工序-设备附件", description = "开发平台-设备配置-工序-设备附件")
@Path(RestConstants.RestPathPrefix.DPPRODUCEPROCESSDEVICEANNEX)
public class DpProduceProcessDeviceAnnexRestServer extends BaseRestServerInterfaceImpl<DpProduceProcessDeviceAnnex> {
	@Override
	public IDpProduceProcessDeviceAnnexProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProduceProcessDeviceAnnexProvider();
	}
}
