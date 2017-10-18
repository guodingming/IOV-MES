package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBomMaterialsReplaceProvider;
import com.mes.entity.control.PdBomMaterialsReplace;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-BOM替换料
*/
@Api(value = "产品管理-BOM替换料", description = "产品管理-BOM替换料")
@Path(RestConstants.RestPathPrefix.PDBOMMATERIALSREPLACE)
public class PdBomMaterialsReplaceRestServer extends BaseRestServerInterfaceImpl<PdBomMaterialsReplace> {
	@Override
	public IPdBomMaterialsReplaceProvider getDubboBaseInterface() {
		return ControlConsumer.getPdBomMaterialsReplaceProvider();
	}
}
