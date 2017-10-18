package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IAgentProvider;
import com.mes.entity.control.Agent;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 平台管理-工作站Agent管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "平台管理-工作站Agent管理", description = "平台管理-工作站Agent管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "agent", description = "平台管理-工作站Agent管理")})}*/)
@Path(RestConstants.RestPathPrefix.AGENT)
public class AgentRestServer extends BaseRestServerInterfaceImpl<Agent> {
    @Override
    public IAgentProvider getDubboBaseInterface() {
        return ControlConsumer.getAgentProvider();
    }

    @GET
    @Path("printProductLabel")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "打印产品标签", notes = "打印产品标签", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject printProductLabel(@ApiParam(value = "Agent id", required = true) @QueryParam("agentId") String agentId,
                                            @ApiParam(value = "产品信息id", required = true) @QueryParam("pdProductInfoId") String pdProductInfoId) {
        try {
            boolean flag = getDubboBaseInterface().printProductLabel(agentId, pdProductInfoId);
            this.addOperationLog("打印产品标签成功!", "", true);
            jsonView.successPack(flag);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("打印产品标签失败!", "", false);
            log.error("AgentRestServer printProductLabel is error", e);
        }
        return jsonView;
    }
}
