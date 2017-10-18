package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdWorkTestDetailTbProvider;
import com.mes.entity.control.PdWorkTestDetailTb;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 终端测试项结果
 * Created by xiuyou.xu on 2017/09/01.
 */
@Api(value = "终端测试项结果", description = "终端测试项结果"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdworktestdetailtb", description = "终端测试项结果")})}*/)
@Path(RestConstants.RestPathPrefix.PDWORKTESTDETAILTB)
public class PdWorkTestDetailTbRestServer extends BaseRestServerInterfaceImpl<PdWorkTestDetailTb> {
    @Override
    public IPdWorkTestDetailTbProvider getDubboBaseInterface() {
        return ControlConsumer.getPdWorkTestDetailTbProvider();
    }
}
