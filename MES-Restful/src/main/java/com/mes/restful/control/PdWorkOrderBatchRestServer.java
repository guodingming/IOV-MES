package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdWorkOrderBatchProvider;
import com.mes.entity.control.PdWorkOrderBatch;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-工单批次
*/
@Api(value = "产品管理-工单批次", description = "产品管理-工单批次")
@Path(RestConstants.RestPathPrefix.PDWORKORDERBATCH)
public class PdWorkOrderBatchRestServer extends BaseRestServerInterfaceImpl<PdWorkOrderBatch> {
	@Override
	public IPdWorkOrderBatchProvider getDubboBaseInterface() {
		return ControlConsumer.getPdWorkOrderBatchProvider();
	}
}
