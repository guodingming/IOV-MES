package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBarcodeRuleProvider;
import com.mes.entity.control.PdBarcodeRule;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-条码规则设置
*/
@Api(value = "产品管理-条码规则设置", description = "产品管理-条码规则设置")
@Path(RestConstants.RestPathPrefix.PDBARCODERULE)
public class PdBarcodeRuleRestServer extends BaseRestServerInterfaceImpl<PdBarcodeRule> {
	@Override
	public IPdBarcodeRuleProvider getDubboBaseInterface() {
		return ControlConsumer.getPdBarcodeRuleProvider();
	}
}
