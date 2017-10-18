package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpBoxPalletInfoProvider;
import com.mes.entity.control.DpBoxPalletInfo;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 开发平台-栈板管理-包装箱
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "开发平台-栈板管理-包装箱", description = "开发平台-栈板管理-包装箱"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpboxpalletinfo", description = "开发平台-栈板管理-包装箱")})}*/)
@Path(RestConstants.RestPathPrefix.DPBOXPALLETINFO)
public class DpBoxPalletInfoRestServer extends BaseRestServerInterfaceImpl<DpBoxPalletInfo> {
    @Override
    public IDpBoxPalletInfoProvider getDubboBaseInterface() {
        return ControlConsumer.getDpBoxPalletInfoProvider();
    }

    @GET
    @Path("saveBoxToPallet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "包装产品到包装箱", notes = "包装产品到包装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)

    public JsonViewObject saveBoxToPallet(@ApiParam(value = "栈板编码")@QueryParam("palletKey")String palletKey,@ApiParam(value = "箱码")@QueryParam("boxKey") String boxKey){
        String id =null;
        try {
            id = this.getDubboBaseInterface().saveBoxToPallet(palletKey,boxKey);
            this.addOperationLog("产品添加到包装箱成功","",true);
            jsonView.successPack(id);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("产品添加到包装箱失败", "", false);
            log.error("DpBoxProductInfoRestServer saveProductToBox is error", e);
        }
        return jsonView ;
    }
}
