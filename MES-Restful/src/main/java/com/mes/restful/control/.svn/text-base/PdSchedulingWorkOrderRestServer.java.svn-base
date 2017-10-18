package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdSchedulingWorkOrderProvider;
import com.mes.entity.control.PdSchedulingWorkOrder;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-工单班次
*/
@Api(value = "产品管理-工单班次", description = "产品管理-工单班次")
@Path(RestConstants.RestPathPrefix.PDSCHEDULINGWORKORDER)
public class PdSchedulingWorkOrderRestServer extends BaseRestServerInterfaceImpl<PdSchedulingWorkOrder> {
	@Override
	public IPdSchedulingWorkOrderProvider getDubboBaseInterface() {
		return ControlConsumer.getPdSchedulingWorkOrderProvider();
	}
}
