package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceProcessConfigWorkorderProvider;
import com.mes.entity.control.DpProduceProcessConfigWorkorder;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-设备配置信息-工单
*/
@Api(value = "开发平台-设备配置信息-工单", description = "开发平台-设备配置信息-工单")
@Path(RestConstants.RestPathPrefix.DPPRODUCEPROCESSCONFIGWORKORDER)
public class DpProduceProcessConfigWorkorderRestServer extends BaseRestServerInterfaceImpl<DpProduceProcessConfigWorkorder> {
	@Override
	public IDpProduceProcessConfigWorkorderProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProduceProcessConfigWorkorderProvider();
	}
}
