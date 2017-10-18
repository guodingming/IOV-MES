package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceProcessAnnexProvider;
import com.mes.entity.control.DpProduceProcessAnnex;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 开发平台-生产工序-工装配置信息
 * Created by xiuyou.xu on 2017/09/22.
 */
@Api(value = "开发平台-生产工序-工装配置信息", description = "开发平台-生产工序-工装配置信息"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpproduceprocesannex", description = "开发平台-生产工序-工装配置信息")})}*/)
@Path(RestConstants.RestPathPrefix.DPPRODUCEPROCESANNEX)
public class DpProduceProcessAnnexRestServer extends BaseRestServerInterfaceImpl<DpProduceProcessAnnex> {
    @Override
    public IDpProduceProcessAnnexProvider getDubboBaseInterface() {
        return ControlConsumer.getDpProduceProcesAnnexProvider();
    }

    /**
     * 获取设备工序附件级联信息
     *
     * @param produceProcessId
     * @return
     */
    @GET
    @Path("/processDeviceAnnexInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取设备工序附件级联信息", notes = "获取设备工序附件级联信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject processDeviceAnnexInfo(@ApiParam(value = "生产工序ID", required = true) @QueryParam("produceProcessId") String produceProcessId) {
        try {
            if (StringUtils.isNotBlank(produceProcessId)) {
                List<Node> nodeList = this.getDubboBaseInterface().processDeviceAnnexInfo(produceProcessId);
                jsonView.successPack(nodeList);
            }
        } catch (DubboProviderException e) {
            jsonView.failPack("获取设备工序附件级联信息失败");
            this.addOperationLog("获取设备工序附件级联信息！", "", false);
            log.error("DpProduceProcessAnnexRestServer processDeviceAnnexInfo is error", e);
        }
        return jsonView;
    }

    /**
     *配置工装
     *
     * @param dpProduceProcessAnnex
     * @return
     */
    @POST
    @Path("/saveAnnex")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "新建记录", notes = "新建记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject saveAnnex(@ApiParam(value = "记录的JSON格式字符串", required = true) DpProduceProcessAnnex dpProduceProcessAnnex){
        jsonView = super.save(dpProduceProcessAnnex);
        String result = (String) jsonView.getContent();
        if ("exist".equals(result)) {
            jsonView.setMessage("当前工序已配置该工装");
        }
        return jsonView;
    }
}
