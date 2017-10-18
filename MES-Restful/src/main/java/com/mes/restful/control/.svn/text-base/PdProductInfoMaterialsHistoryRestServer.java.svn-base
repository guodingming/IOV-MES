package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductInfoMaterialsHistoryProvider;
import com.mes.entity.control.PdProductInfoMaterialsHistory;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品明细-物料-历史
*/
@Api(value = "开发平台-产品明细-物料-历史", description = "开发平台-产品明细-物料-历史")
@Path(RestConstants.RestPathPrefix.PDPRODUCTINFOMATERIALSHISTORY)
public class PdProductInfoMaterialsHistoryRestServer extends BaseRestServerInterfaceImpl<PdProductInfoMaterialsHistory> {
	@Override
	public IPdProductInfoMaterialsHistoryProvider getDubboBaseInterface() {
		return ControlConsumer.getPdProductInfoMaterialsHistoryProvider();
	}
}
