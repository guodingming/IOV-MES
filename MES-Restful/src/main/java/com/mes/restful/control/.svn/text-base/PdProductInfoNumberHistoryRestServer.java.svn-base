package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberHistoryProvider;
import com.mes.entity.control.PdProductInfoNumberHistory;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品明细-产品编码(历史)
*/
@Api(value = "开发平台-产品明细-产品编码(历史)", description = "开发平台-产品明细-产品编码(历史)")
@Path(RestConstants.RestPathPrefix.PDPRODUCTINFONUMBERHISTORY)
public class PdProductInfoNumberHistoryRestServer extends BaseRestServerInterfaceImpl<PdProductInfoNumberHistory> {
	@Override
	public IPdProductInfoNumberHistoryProvider getDubboBaseInterface() {
		return ControlConsumer.getPdProductInfoNumberHistoryProvider();
	}
}
