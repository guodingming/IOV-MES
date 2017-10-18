package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpLabelTypeProvider;
import com.mes.entity.control.DpLabelType;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-标签类别
*/
@Api(value = "开发平台-标签类别", description = "开发平台-标签类别")
@Path(RestConstants.RestPathPrefix.DPLABELTYPE)
public class DpLabelTypeRestServer extends BaseRestServerInterfaceImpl<DpLabelType> {
	@Override
	public IDpLabelTypeProvider getDubboBaseInterface() {
		return ControlConsumer.getDpLabelTypeProvider();
	}
}
