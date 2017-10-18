package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.ISerialRuleWorkOrderAssociationProvider;
import com.mes.entity.control.SerialRuleWorkOrderAssociation;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 开发平台-流水规则-规则工单关联
 * Created by xiuyou.xu on 2017/10/16.
 */
@Api(value = "开发平台-流水规则-规则工单关联", description = "开发平台-流水规则-规则工单关联"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "serialruleworkorderassociation", description = "开发平台-流水规则-规则工单关联")})}*/)
@Path(RestConstants.RestPathPrefix.SERIALRULEWORKORDERASSOCIATION)
public class SerialRuleWorkOrderAssociationRestServer extends BaseRestServerInterfaceImpl<SerialRuleWorkOrderAssociation> {
    @Override
    public ISerialRuleWorkOrderAssociationProvider getDubboBaseInterface() {
        return ControlConsumer.getSerialRuleWorkOrderAssociationProvider();
    }
}
