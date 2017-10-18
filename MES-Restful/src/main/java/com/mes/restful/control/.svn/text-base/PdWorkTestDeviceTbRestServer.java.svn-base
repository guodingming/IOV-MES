package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdWorkTestDeviceTbProvider;
import com.mes.entity.control.PdWorkTestDeviceTb;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 终端测试项设备状态
 * Created by xiuyou.xu on 2017/09/01.
 */
@Api(value = "终端测试项设备状态", description = "终端测试项设备状态"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdworktestdevicetb", description = "终端测试项设备状态")})}*/)
@Path(RestConstants.RestPathPrefix.PDWORKTESTDEVICETB)
public class PdWorkTestDeviceTbRestServer extends BaseRestServerInterfaceImpl<PdWorkTestDeviceTb> {
    @Override
    public IPdWorkTestDeviceTbProvider getDubboBaseInterface() {
        return ControlConsumer.getPdWorkTestDeviceTbProvider();
    }
}
