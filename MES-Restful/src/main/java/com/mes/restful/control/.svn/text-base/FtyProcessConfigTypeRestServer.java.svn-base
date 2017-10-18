package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyProcessConfigTypeProvider;
import com.mes.entity.control.FtyProcessConfigType;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 工厂管理-工序配置类型
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "工厂管理-工序配置类型", description = "工厂管理-工序配置类型"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "ftyprocessconfigtype", description = "工厂管理-工序配置类型")})}*/)
@Path(RestConstants.RestPathPrefix.FTYPROCESSCONFIGTYPE)
public class FtyProcessConfigTypeRestServer extends BaseRestServerInterfaceImpl<FtyProcessConfigType> {
    @Override
    public IFtyProcessConfigTypeProvider getDubboBaseInterface() {
        return ControlConsumer.getFtyProcessConfigTypeProvider();
    }
}
