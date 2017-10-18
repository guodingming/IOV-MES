package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBarcodeRuleTypeProvider;
import com.mes.entity.control.PdBarcodeRuleType;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-条码规则分类
*/
@Api(value = "开发平台-条码规则分类", description = "开发平台-条码规则分类")
@Path(RestConstants.RestPathPrefix.PDBARCODERULETYPE)
public class PdBarcodeRuleTypeRestServer extends BaseRestServerInterfaceImpl<PdBarcodeRuleType> {
	@Override
	public IPdBarcodeRuleTypeProvider getDubboBaseInterface() {
		return ControlConsumer.getPdBarcodeRuleTypeProvider();
	}
}
