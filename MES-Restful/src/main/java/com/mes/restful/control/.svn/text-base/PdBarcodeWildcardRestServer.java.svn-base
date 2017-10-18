package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBarcodeWildcardProvider;
import com.mes.entity.control.PdBarcodeWildcard;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 产品管理-条码通配符列表
 * Created by xiuyou.xu on 2017/10/11.
 */
@Api(value = "产品管理-条码通配符列表", description = "产品管理-条码通配符列表"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdbarcodewildcard", description = "产品管理-条码通配符列表")})}*/)
@Path(RestConstants.RestPathPrefix.PDBARCODEWILDCARD)
public class PdBarcodeWildcardRestServer extends BaseRestServerInterfaceImpl<PdBarcodeWildcard> {
    @Override
    public IPdBarcodeWildcardProvider getDubboBaseInterface() {
        return ControlConsumer.getPdBarcodeWildcardProvider();
    }

}
