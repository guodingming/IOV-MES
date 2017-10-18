package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigProvider;
import com.mes.entity.control.FtyDeviceConfig;
import com.mes.entity.control.FtyDeviceConfigTypes;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 工厂管理-设备配置设置
 */
@Api(value = "工厂管理-设备配置设置", description = "工厂管理-设备配置设置")
@Path(RestConstants.RestPathPrefix.FTYDEVICECONFIG)
public class FtyDeviceConfigRestServer extends BaseRestServerInterfaceImpl<FtyDeviceConfig> {
    @Override
    public IFtyDeviceConfigProvider getDubboBaseInterface() {
        return ControlConsumer.getFtyDeviceConfigProvider();
    }

    @POST
    @Path("saveDeviceConfigTypes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "关联设备到多个设备配置类型", notes = "关联设备到多个设备配置类型", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveDeviceConfigTypes(@ApiParam("设备及其多个配置类型关联关系") @NotNull(message = "设备及其多个配置类型关联关系不能为null") FtyDeviceConfigTypes ftyDeviceConfigTypes) {
        try {
            boolean ret = this.getDubboBaseInterface().saveDeviceConfigTypes(ftyDeviceConfigTypes);
            this.addOperationLog("关联设备到多个设备配置类型成功", "", true);
            jsonView.successPack(ret, "关联设备到多个设备配置类型成功");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("关联设备到多个设备配置类型失败", "", false);
            log.error("FtyDeviceConfigRestServer saveDeviceConfigTypes is error", e);
        }
        return jsonView;
    }
}
