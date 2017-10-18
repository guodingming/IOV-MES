package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdExecSoftinjectTbProvider;
import com.mes.entity.control.PdExecSoftinjectTb;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 软件注入结果记录
 * Created by xiuyou.xu on 2017/09/01.
 */
@Api(value = "软件注入结果记录", description = "软件注入结果记录"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdexecsoftinjecttb", description = "软件注入结果记录")})}*/)
@Path(RestConstants.RestPathPrefix.PDEXECSOFTINJECTTB)
public class PdExecSoftinjectTbRestServer extends BaseRestServerInterfaceImpl<PdExecSoftinjectTb> {
    @Override
    public IPdExecSoftinjectTbProvider getDubboBaseInterface() {
        return ControlConsumer.getPdExecSoftinjectTbProvider();
    }
}
