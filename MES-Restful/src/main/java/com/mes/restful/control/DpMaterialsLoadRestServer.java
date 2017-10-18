package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpMaterialsLoadProvider;
import com.mes.entity.control.DpMaterialsLoad;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 开发平台-上料管理-上料
 * Created by xiuyou.xu on 2017/09/21.
 */
@Api(value = "开发平台-上料管理-上料", description = "开发平台-上料管理-上料"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpmaterialsload", description = "开发平台-上料管理-上料")})}*/)
@Path(RestConstants.RestPathPrefix.DPMATERIALSLOAD)
public class DpMaterialsLoadRestServer extends BaseRestServerInterfaceImpl<DpMaterialsLoad> {
    @Override
    public IDpMaterialsLoadProvider getDubboBaseInterface() {
        return ControlConsumer.getDpMaterialsLoadProvider();
    }
}
