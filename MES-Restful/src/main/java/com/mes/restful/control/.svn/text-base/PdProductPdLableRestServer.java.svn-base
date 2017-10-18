package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductPdLableProvider;
import com.mes.entity.control.PdProductPdLable;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-产品明细-产品标签
 * Created by xiuyou.xu on 2017/09/27.
 */
@Api(value = "开发平台-产品明细-产品标签", description = "开发平台-产品明细-产品标签"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdproductpdlable", description = "开发平台-产品明细-产品标签")})}*/)
@Path(RestConstants.RestPathPrefix.PDPRODUCTPDLABLE)
public class PdProductPdLableRestServer extends BaseRestServerInterfaceImpl<PdProductPdLable> {
    @Override
    public IPdProductPdLableProvider getDubboBaseInterface() {
        return ControlConsumer.getPdProductPdLableProvider();
    }
}
