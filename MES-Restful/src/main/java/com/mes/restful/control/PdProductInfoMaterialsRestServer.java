package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductInfoMaterialsProvider;
import com.mes.entity.control.PdProductInfoMaterials;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品明细-物料
*/
@Api(value = "开发平台-产品明细-物料", description = "开发平台-产品明细-物料")
@Path(RestConstants.RestPathPrefix.PDPRODUCTINFOMATERIALS)
public class PdProductInfoMaterialsRestServer extends BaseRestServerInterfaceImpl<PdProductInfoMaterials> {
	@Override
	public IPdProductInfoMaterialsProvider getDubboBaseInterface() {
		return ControlConsumer.getPdProductInfoMaterialsProvider();
	}
}
