package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IUserGroupProvider;
import com.mes.entity.control.UserGroup;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 用户组管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "系统管理-用户组管理", description = "系统管理-用户组管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "user", description = "用户组管理")})}*/)
@Path(RestConstants.RestPathPrefix.USER_GROUP)
public class UserGroupRestServer extends BaseRestServerInterfaceImpl<UserGroup> {
    @Override
    public IUserGroupProvider getDubboBaseInterface() {
        return ControlConsumer.getUserGroupProvider();
    }
}
