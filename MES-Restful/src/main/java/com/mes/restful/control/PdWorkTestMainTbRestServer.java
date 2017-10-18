package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdWorkTestMainTbProvider;
import com.mes.entity.control.PdWorkTestMainTb;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 终端测试结果
 * Created by xiuyou.xu on 2017/09/01.
 */
@Api(value = "终端测试结果", description = "终端测试结果"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdworktestmaintb", description = "终端测试结果")})}*/)
@Path(RestConstants.RestPathPrefix.PDWORKTESTMAINTB)
public class PdWorkTestMainTbRestServer extends BaseRestServerInterfaceImpl<PdWorkTestMainTb> {
    @Override
    public IPdWorkTestMainTbProvider getDubboBaseInterface() {
        return ControlConsumer.getPdWorkTestMainTbProvider();
    }
}
