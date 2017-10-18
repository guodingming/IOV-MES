package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceAnnexInfoProvider;
import com.mes.entity.control.FtyDeviceAnnexInfo;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

@Api(value = "工厂管理-（治具/工装/其他）", description = "工厂管理-（治具/工装/其他）")
@Path(RestConstants.RestPathPrefix.FTYDEVICEANNEXINFO)
public class FtyDeviceAnnexInfoRestServer extends BaseRestServerInterfaceImpl<FtyDeviceAnnexInfo> {
	@Override
	public IFtyDeviceAnnexInfoProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceAnnexInfoProvider();
	}
}
