package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProductTestLogHistoryProvider;
import com.mes.entity.control.DpProductTestLogHistory;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品测试项-历史表
*/
@Api(value = "开发平台-产品测试项-历史表", description = "开发平台-产品测试项-历史表")
@Path(RestConstants.RestPathPrefix.DPPRODUCTTESTLOGHISTORY)
public class DpProductTestLogHistoryRestServer extends BaseRestServerInterfaceImpl<DpProductTestLogHistory> {
	@Override
	public IDpProductTestLogHistoryProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProductTestLogHistoryProvider();
	}
}
