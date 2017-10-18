package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProductInfoLogHistoryProvider;
import com.mes.entity.control.DpProductInfoLogHistory;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品生产工序记录--历史表
*/
@Api(value = "开发平台-产品生产工序记录--历史表", description = "开发平台-产品生产工序记录--历史表")
@Path(RestConstants.RestPathPrefix.DPPRODUCTINFOLOGHISTORY)
public class DpProductInfoLogHistoryRestServer extends BaseRestServerInterfaceImpl<DpProductInfoLogHistory> {
	@Override
	public IDpProductInfoLogHistoryProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProductInfoLogHistoryProvider();
	}
}
