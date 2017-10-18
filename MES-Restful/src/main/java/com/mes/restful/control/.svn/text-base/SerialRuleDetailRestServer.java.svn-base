package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.ISerialRuleDetailProvider;
import com.mes.entity.control.SerialRuleDetail;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
/**
 * 开发平台-流水规则-明细
 * Created by xiuyou.xu on 2017/10/16.
 */
@Api(value = "开发平台-流水规则-明细", description = "开发平台-流水规则-明细"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "serialruledetail", description = "开发平台-流水规则-明细")})}*/)
@Path(RestConstants.RestPathPrefix.SERIALRULEDETAIL)
public class SerialRuleDetailRestServer extends BaseRestServerInterfaceImpl<SerialRuleDetail> {
    @Override
    public ISerialRuleDetailProvider getDubboBaseInterface() {
        return ControlConsumer.getSerialRuleDetailProvider();
    }
}
