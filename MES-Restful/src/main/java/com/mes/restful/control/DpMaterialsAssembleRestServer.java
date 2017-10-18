package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpMaterialsAssembleProvider;
import com.mes.entity.control.DpMaterialsAssemble;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 开发平台-上料管理-组装
 * Created by xiuyou.xu on 2017/09/13.
 */
@Api(value = "开发平台-上料管理-组装", description = "开发平台-上料管理-组装"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpmaterialsassemble", description = "开发平台-上料管理-组装")})}*/)
@Path(RestConstants.RestPathPrefix.DPMATERIALSASSEMBLE)
public class DpMaterialsAssembleRestServer extends BaseRestServerInterfaceImpl<DpMaterialsAssemble> {
    @Override
    public IDpMaterialsAssembleProvider getDubboBaseInterface() {
        return ControlConsumer.getDpMaterialsAssembleProvider();
    }
}
