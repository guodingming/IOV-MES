package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceAnnexProvider;
import com.mes.entity.control.FtyDeviceAnnex;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

@Api(value = "工厂管理-设备附件", description = "工厂管理-设备附件")
@Path(RestConstants.RestPathPrefix.FTYDEVICEANNEX)
public class FtyDeviceAnnexRestServer extends BaseRestServerInterfaceImpl<FtyDeviceAnnex> {
	@Override
	public IFtyDeviceAnnexProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceAnnexProvider();
	}
}
