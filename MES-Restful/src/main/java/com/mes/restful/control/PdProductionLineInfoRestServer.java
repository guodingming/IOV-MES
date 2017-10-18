package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductionLineInfoProvider;
import com.mes.entity.control.PdProductionLineInfo;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import javax.ws.rs.Path;


@Api(value = "产品线管理-产品与生产线关联", description = "产品线管理-产品与生产线关联")
@Path(RestConstants.RestPathPrefix.PDPRODUCTIONLINEINFO)
public class PdProductionLineInfoRestServer extends BaseRestServerInterfaceImpl<PdProductionLineInfo> {
	@Override
	public IPdProductionLineInfoProvider getDubboBaseInterface() {
		return ControlConsumer.getPdProductionLineInfoProvider();
	}

}
