package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductLabelProvider;
import com.mes.entity.control.PdProductLabel;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 产品管理-产品标签
 * Created by xiuyou.xu on 2017/09/28.
 */
@Api(value = "产品管理-产品标签", description = "产品管理-产品标签"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdproductlabel", description = "产品管理-产品标签")})}*/)
@Path(RestConstants.RestPathPrefix.PDPRODUCTLABEL)
public class PdProductLabelRestServer extends BaseRestServerInterfaceImpl<PdProductLabel> {
    @Override
    public IPdProductLabelProvider getDubboBaseInterface() {
        return ControlConsumer.getPdProductLabelProvider();
    }
}
