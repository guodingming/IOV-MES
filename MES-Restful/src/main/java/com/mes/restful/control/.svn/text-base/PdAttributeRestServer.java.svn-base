package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdAttributeProvider;
import com.mes.entity.control.PdAttribute;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-产品属性管理
*/
@Api(value = "产品管理-产品属性管理", description = "产品管理-产品属性管理")
@Path(RestConstants.RestPathPrefix.PDATTRIBUTE)
public class PdAttributeRestServer extends BaseRestServerInterfaceImpl<PdAttribute> {
	@Override
	public IPdAttributeProvider getDubboBaseInterface() {
		return ControlConsumer.getPdAttributeProvider();
	}
}
