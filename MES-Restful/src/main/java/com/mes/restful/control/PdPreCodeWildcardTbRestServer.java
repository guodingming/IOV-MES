package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdPreCodeWildcardTbProvider;
import com.mes.entity.control.PdPreCodeWildcardTb;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 产品管理-条码扩展通配符
 * Created by xiuyou.xu on 2017/10/11.
 */
@Api(value = "产品管理-条码扩展通配符", description = "产品管理-条码扩展通配符"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdprecodewildcardtb", description = "产品管理-条码扩展通配符")})}*/)
@Path(RestConstants.RestPathPrefix.PDPRECODEWILDCARDTB)
public class PdPreCodeWildcardTbRestServer extends BaseRestServerInterfaceImpl<PdPreCodeWildcardTb> {
    @Override
    public IPdPreCodeWildcardTbProvider getDubboBaseInterface() {
        return ControlConsumer.getPdPreCodeWildcardTbProvider();
    }
}
