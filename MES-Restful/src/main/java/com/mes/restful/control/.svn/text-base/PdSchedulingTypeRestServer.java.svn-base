package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdSchedulingTypeProvider;
import com.mes.entity.control.PdSchedulingType;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-班次类型
*/
@Api(value = "产品管理-班次类型", description = "产品管理-班次类型")
@Path(RestConstants.RestPathPrefix.PDSCHEDULINGTYPE)
public class PdSchedulingTypeRestServer extends BaseRestServerInterfaceImpl<PdSchedulingType> {
	@Override
	public IPdSchedulingTypeProvider getDubboBaseInterface() {
		return ControlConsumer.getPdSchedulingTypeProvider();
	}
}
