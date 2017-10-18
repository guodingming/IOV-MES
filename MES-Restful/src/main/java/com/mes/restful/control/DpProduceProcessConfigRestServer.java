package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceProcessConfigProvider;
import com.mes.entity.control.DpProduceProcessConfig;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-生产工序配置属性
*/
@Api(value = "开发平台-生产工序配置属性", description = "开发平台-生产工序配置属性")
@Path(RestConstants.RestPathPrefix.DPPRODUCEPROCESSCONFIG)
public class DpProduceProcessConfigRestServer extends BaseRestServerInterfaceImpl<DpProduceProcessConfig> {
	@Override
	public IDpProduceProcessConfigProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProduceProcessConfigProvider();
	}
}
