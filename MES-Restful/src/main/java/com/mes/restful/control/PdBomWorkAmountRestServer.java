package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBomWorkAmountProvider;
import com.mes.entity.control.PdBomWorkAmount;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-工单BOM管理用量
*/
@Api(value = "产品管理-工单BOM管理用量", description = "产品管理-工单BOM管理用量")
@Path(RestConstants.RestPathPrefix.PDBOMWORKAMOUNT)
public class PdBomWorkAmountRestServer extends BaseRestServerInterfaceImpl<PdBomWorkAmount> {
	@Override
	public IPdBomWorkAmountProvider getDubboBaseInterface() {
		return ControlConsumer.getPdBomWorkAmountProvider();
	}
}
