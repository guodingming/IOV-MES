package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.ISerialRuleProvider;
import com.mes.entity.control.SerialRule;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * 开发平台-流水规则-规则
 * Created by xiuyou.xu on 2017/10/16.
 */
@Api(value = "开发平台-流水规则-规则", description = "开发平台-流水规则-规则"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "serialrule", description = "开发平台-流水规则-规则")})}*/)
@Path(RestConstants.RestPathPrefix.SERIALRULE)
public class SerialRuleRestServer extends BaseRestServerInterfaceImpl<SerialRule> {
    @Override
    public ISerialRuleProvider getDubboBaseInterface() {
        return ControlConsumer.getSerialRuleProvider();
    }

    @GET
    @Path("getByVin")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据VIN号获取流水规则", notes = "根据VIN号获取流水规则", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getByVin(@ApiParam(value = "VIN号", required = true) @QueryParam("vin") String vin) {
        try {
            SerialRule serialRule = this.getDubboBaseInterface().getByVin(vin);
            jsonView.successPack(serialRule);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("根据VIN号获取流水规则失败", "", false);
            log.error("SerialRuleRestServer getByVin is error", e);
        }
        return jsonView;
    }

    @GET
    @Path("getByPdId")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品id获取流水规则", notes = "根据产品id获取流水规则", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getByPdId(@ApiParam(value = "产品id", required = true) @QueryParam("pdId") String pdId) {
        try {
            SerialRule serialRule = this.getDubboBaseInterface().getByPdId(pdId);
            jsonView.successPack(serialRule);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("根据产品id获取流水规则失败", "", false);
            log.error("SerialRuleRestServer getByPdId is error", e);
        }
        return jsonView;
    }

    @GET
    @Path("getByDate")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据开单日期获取流水规则", notes = "根据开单日期获取流水规则", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getByDate(@ApiParam(value = "开单日期", required = true) @QueryParam("date") String date) {
        try {
            SerialRule serialRule = this.getDubboBaseInterface().getByDate(new Date());
            jsonView.successPack(serialRule);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("根据开单日期获取流水规则失败", "", false);
            log.error("SerialRuleRestServer getByDate is error", e);
        }
        return jsonView;
    }
}
