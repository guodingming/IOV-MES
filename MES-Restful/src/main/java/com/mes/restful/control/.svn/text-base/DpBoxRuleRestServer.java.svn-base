package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpBoxProvider;
import com.mes.dubbo.interprovider.control.IDpBoxRuleProvider;
import com.mes.entity.control.DpBox;
import com.mes.entity.control.DpBoxRule;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-包装箱管理--包装箱生成规则配置
 * Created by dengyun.le on 2017/09/28.
 */
@Api(value = "开发平台-包装箱管理--包装箱生成规则配置", description = "开发平台-包装箱管理--包装箱生成规则配置"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpbox", description = "开发平台-包装箱管理")})}*/)
@Path(RestConstants.RestPathPrefix.DPBOXRULE)
public class DpBoxRuleRestServer extends BaseRestServerInterfaceImpl<DpBoxRule> {
    @Override
    public IDpBoxRuleProvider getDubboBaseInterface() {
        return ControlConsumer.getDpBoxRuleProvider();
    }

    @GET
    @Path("/saveBox")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "生成包装箱", notes = "生成包装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveBox(@ApiParam(value = "生成规则Id")@QueryParam("id")String id,@ApiParam(value = "包装箱个数")@QueryParam("number")String number){

        List Ids = null;
        try {
            Ids = this.getDubboBaseInterface().saveBox(id,number);
            this.addOperationLog("生成包装箱成功", "", true);
            jsonView.successPack(Ids);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("生成包装箱失败", "", false);
            log.error("DpBoxRuleRestServer saveBox is error", e);
        }

        return jsonView;
    }

    @POST
    @Path("/queryData")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据条件分页查询记录", notes = "根据条件分页查询记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject getPage(@ApiParam(value = "查询条件和分页参数", required = true, defaultValue = "", example = "{\"pageSize\": 10, \"pageNum\": 1}") Page page){
        JSON result;
        String jsonStr = JSON.toJSONString(page);
        try {
            Map<String, Object> mapBean = Maps.newHashMap();
            if (page != null) {
                if (page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
                    mapBean = (Map) page.getCondition();
                }
            }
            page = this.getDubboBaseInterface().findByPage(page, mapBean);
            result = (JSON) JSON.toJSON(page);
            jsonView.successPack(result);
            this.addOperationLog("分页查询", jsonStr, true);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("分页查询", jsonStr, false);
            log.error("BaseRestServerInterfaceImpl getPage is error,{jsonStr:" + jsonStr + "}", e);
        }
        return jsonView;


    }
}
