package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpMaterialsInfoHistoryProvider;
import com.mes.entity.control.DpMaterialsInfoHistory;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-上料管理-历史包
*/
@Api(value = "开发平台-上料管理-历史包", description = "开发平台-上料管理-历史包")
@Path(RestConstants.RestPathPrefix.DPMATERIALSINFOHISTORY)
public class DpMaterialsInfoHistoryRestServer extends BaseRestServerInterfaceImpl<DpMaterialsInfoHistory> {
	@Override
	public IDpMaterialsInfoHistoryProvider getDubboBaseInterface() {
		return ControlConsumer.getDpMaterialsInfoHistoryProvider();
	}
}
