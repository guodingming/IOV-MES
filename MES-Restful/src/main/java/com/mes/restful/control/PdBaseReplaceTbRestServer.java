package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBaseReplaceTbProvider;
import com.mes.entity.control.PdBaseReplaceTb;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 产品管理-条码通配符日期替换
 * Created by xiuyou.xu on 2017/10/11.
 */
@Api(value = "产品管理-条码通配符日期替换", description = "产品管理-条码通配符日期替换"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdbasereplacetb", description = "产品管理-条码通配符日期替换")})}*/)
@Path(RestConstants.RestPathPrefix.PDBASEREPLACETB)
public class PdBaseReplaceTbRestServer extends BaseRestServerInterfaceImpl<PdBaseReplaceTb> {
    @Override
    public IPdBaseReplaceTbProvider getDubboBaseInterface() {
        return ControlConsumer.getPdBaseReplaceTbProvider();
    }
}
