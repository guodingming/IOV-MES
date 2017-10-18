package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceProcessDateProvider;
import com.mes.entity.control.DpProduceProcessDate;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 开发平台-生产工序配置-工序执行时间
 * Created by xiuyou.xu on 2017/08/30.
 */
@Api(value = "开发平台-生产工序配置-工序执行时间", description = "开发平台-生产工序配置-工序执行时间"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpproduceprocessdate", description = "开发平台-生产工序配置-工序执行时间")})}*/)
@Path(RestConstants.RestPathPrefix.DPPRODUCEPROCESSDATE)
public class DpProduceProcessDateRestServer extends BaseRestServerInterfaceImpl<DpProduceProcessDate> {
    @Override
    public IDpProduceProcessDateProvider getDubboBaseInterface() {
        return ControlConsumer.getDpProduceProcessDateProvider();
    }


    /**
     * 配置工序操作时间设置
     * @param produceProcessDate
     * @return
     */
    @POST
    @Path("configDateSet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "保存工序时间设置", notes = "保存工序时间设置", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject configDateSet(@ApiParam(value = "保存工序时间设置对象", required = true, defaultValue = "", example = "") DpProduceProcessDate produceProcessDate ) {
        try {
            boolean flag = this.getDubboBaseInterface().updateConfigDateSet(produceProcessDate);
            if (flag) {
                jsonView.successPack(flag, "保存工序时间设置成功");
                this.addOperationLog("保存工序时间设置",  "保存工序时间设置成功", true);
            } else {
                jsonView.failPack(flag, "保存工序时间设置失败");
                this.addOperationLog("保存工序时间设置",  "保存工序时间设置失败", false);
            }
        }catch (DubboProviderException e){
            jsonView.failPack("保存工序时间设置失败", "保存工序时间设置失败");
            this.addOperationLog("保存工序时间设置",  "保存工序时间设置失败", false);
            log.error("DpProduceProcessDateRestServer configDateSet is error,{:" + "" + "}", e);
        }
        return jsonView;
    }
}
