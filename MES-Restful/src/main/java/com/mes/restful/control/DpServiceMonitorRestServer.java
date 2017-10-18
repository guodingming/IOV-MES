package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpServiceMonitorProvider;
import com.mes.entity.control.DpServiceMonitor;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 服务调用监控
 *
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "$table.description", description = "$table.description"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpservicemonitor", description = "$table.description")})}*/)
@Path(RestConstants.RestPathPrefix.DPSERVICEMONITOR)
public class DpServiceMonitorRestServer extends BaseRestServerInterfaceImpl<DpServiceMonitor> {
    @Override
    public IDpServiceMonitorProvider getDubboBaseInterface() {
        return ControlConsumer.getDpServiceMonitorProvider();
    }
}
