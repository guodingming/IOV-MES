package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigTypeProvider;
import com.mes.entity.control.FtyDeviceConfigType;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 工厂管理-设备配置-字典分类
*/
@Api(value = "工厂管理-设备配置-字典分类", description = "工厂管理-设备配置-字典分类")
@Path(RestConstants.RestPathPrefix.FTYDEVICECONFIGTYPE)
public class FtyDeviceConfigTypeRestServer extends BaseRestServerInterfaceImpl<FtyDeviceConfigType> {
	@Override
	public IFtyDeviceConfigTypeProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceConfigTypeProvider();
	}
}
