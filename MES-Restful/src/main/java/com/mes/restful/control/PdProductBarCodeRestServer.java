package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductBarCodeProvider;
import com.mes.entity.control.PdProductBarCode;
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
 * 产品管理-产品条码
 * Created by xiuyou.xu on 2017/09/28.
 */
@Api(value = "产品管理-产品条码", description = "产品管理-产品条码"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "pdproductbarcode", description = "产品管理-产品条码")})}*/)
@Path(RestConstants.RestPathPrefix.PDPRODUCTBARCODE)
public class PdProductBarCodeRestServer extends BaseRestServerInterfaceImpl<PdProductBarCode> {
    @Override
    public IPdProductBarCodeProvider getDubboBaseInterface() {
        return ControlConsumer.getPdProductBarCodeProvider();
    }

    /**
     * 配置条码
     *
     * @param pdProductBarCode
     * @return
     */
    @POST
    @Path("configBarCode")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "配置条码", notes = "配置条码", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject configBarCode(@ApiParam(value = "配置条码对象", required = true, defaultValue = "", example = "") PdProductBarCode pdProductBarCode) {
        String jsonStr = JSON.toJSONString(pdProductBarCode);
        try {
            if (pdProductBarCode != null) {
                boolean flag = this.getDubboBaseInterface().updateConfigBarCode(pdProductBarCode);
                if (flag) {
                    jsonView.successPack(true, "配置条码成功");
                } else {
                    jsonView.failPack(false, "配置条码失败");
                }
            }
        } catch (Exception e) {
            jsonView.failPack(false, "配置条码失败");
            this.addOperationLog("保存数据", "jsonStr=" + jsonStr, false);
            log.error("PdProductBarCodeRestServer config is error,{jsonStr:" + jsonStr + "}," + e.getMessage(), e);
        }
        return jsonView;
    }
}
