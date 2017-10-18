package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpBarcodeTypeProvider;
import com.mes.entity.control.DpBarcodeType;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-条码类别
*/
@Api(value = "开发平台-条码类别", description = "开发平台-条码类别")
@Path(RestConstants.RestPathPrefix.DPBARCODETYPE)
public class DpBarcodeTypeRestServer extends BaseRestServerInterfaceImpl<DpBarcodeType> {
	@Override
	public IDpBarcodeTypeProvider getDubboBaseInterface() {
		return ControlConsumer.getDpBarcodeTypeProvider();
	}
}
