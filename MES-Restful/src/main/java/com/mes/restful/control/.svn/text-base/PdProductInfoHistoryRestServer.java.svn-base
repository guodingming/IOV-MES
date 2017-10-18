package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductInfoHistoryProvider;
import com.mes.entity.control.PdProductInfoHistory;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品明细（按工单移）历史表
*/
@Api(value = "开发平台-产品明细（按工单移）历史表", description = "开发平台-产品明细（按工单移）历史表")
@Path(RestConstants.RestPathPrefix.PDPRODUCTINFOHISTORY)
public class PdProductInfoHistoryRestServer extends BaseRestServerInterfaceImpl<PdProductInfoHistory> {
	@Override
	public IPdProductInfoHistoryProvider getDubboBaseInterface() {
		return ControlConsumer.getPdProductInfoHistoryProvider();
	}
}
