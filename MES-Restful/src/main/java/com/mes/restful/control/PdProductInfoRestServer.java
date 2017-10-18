package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductInfoProvider;
import com.mes.entity.control.PdProductInfo;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品明细（按工单移）
 */
@Api(value = "开发平台-产品明细（按工单移）", description = "开发平台-产品明细（按工单移）")
@Path(RestConstants.RestPathPrefix.PDPRODUCTINFO)
public class PdProductInfoRestServer extends BaseRestServerInterfaceImpl<PdProductInfo> {
    @Override
    public IPdProductInfoProvider getDubboBaseInterface() {
        return ControlConsumer.getPdProductInfoProvider();
    }

}
