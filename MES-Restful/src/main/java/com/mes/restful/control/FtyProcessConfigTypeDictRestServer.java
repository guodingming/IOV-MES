package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyProcessConfigTypeDictProvider;
import com.mes.entity.control.FtyProcessConfigTypeDict;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 工厂管理-工序配置类型字典
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "工厂管理-工序配置类型字典", description = "工厂管理-工序配置类型字典"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "ftyprocessconfigtypedict", description = "工厂管理-工序配置类型字典")})}*/)
@Path(RestConstants.RestPathPrefix.FTYPROCESSCONFIGTYPEDICT)
public class FtyProcessConfigTypeDictRestServer extends BaseRestServerInterfaceImpl<FtyProcessConfigTypeDict> {
    @Override
    public IFtyProcessConfigTypeDictProvider getDubboBaseInterface() {
        return ControlConsumer.getFtyProcessConfigTypeDictProvider();
    }
}
