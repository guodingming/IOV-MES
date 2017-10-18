package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBomMaterialsProvider;
import com.mes.entity.control.PdBomMaterials;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-物料清单
*/
@Api(value = "产品管理-物料清单", description = "产品管理-物料清单")
@Path(RestConstants.RestPathPrefix.PDBOMMATERIALS)
public class PdBomMaterialsRestServer extends BaseRestServerInterfaceImpl<PdBomMaterials> {
	@Override
	public IPdBomMaterialsProvider getDubboBaseInterface() {
		return ControlConsumer.getPdBomMaterialsProvider();
	}
}
