package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdExecSystemModuleCopyProvider;
import com.mes.entity.control.PdExecSystemModuleCopy;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * $table.description
 * Created by xiuyou.xu on 2017/09/01.
 */
@Api(value = "$table.description", description = "$table.description"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdexecsystemmodulecopy", description = "$table.description")})}*/)
@Path(RestConstants.RestPathPrefix.PDEXECSYSTEMMODULECOPY)
public class PdExecSystemModuleCopyRestServer extends BaseRestServerInterfaceImpl<PdExecSystemModuleCopy> {
    @Override
    public IPdExecSystemModuleCopyProvider getDubboBaseInterface() {
        return ControlConsumer.getPdExecSystemModuleCopyProvider();
    }
}
