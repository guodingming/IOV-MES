package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdExecTransmitSetTbProvider;
import com.mes.entity.control.PdExecTransmitSetTb;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * $table.description
 * Created by xiuyou.xu on 2017/09/01.
 */
@Api(value = "$table.description", description = "$table.description"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdexectransmitsettb", description = "$table.description")})}*/)
@Path(RestConstants.RestPathPrefix.PDEXECTRANSMITSETTB)
public class PdExecTransmitSetTbRestServer extends BaseRestServerInterfaceImpl<PdExecTransmitSetTb> {
    @Override
    public IPdExecTransmitSetTbProvider getDubboBaseInterface() {
        return ControlConsumer.getPdExecTransmitSetTbProvider();
    }
}
