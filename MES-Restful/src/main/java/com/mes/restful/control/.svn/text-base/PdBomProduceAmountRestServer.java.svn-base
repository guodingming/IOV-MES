package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBomProduceAmountProvider;
import com.mes.entity.control.PdBomProduceAmount;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-生产BOM管理用量
*/
@Api(value = "产品管理-生产BOM管理用量", description = "产品管理-生产BOM管理用量")
@Path(RestConstants.RestPathPrefix.PDBOMPRODUCEAMOUNT)
public class PdBomProduceAmountRestServer extends BaseRestServerInterfaceImpl<PdBomProduceAmount> {
	@Override
	public IPdBomProduceAmountProvider getDubboBaseInterface() {
		return ControlConsumer.getPdBomProduceAmountProvider();
	}
}
