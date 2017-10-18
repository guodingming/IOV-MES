package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpBoxPalletProvider;
import com.mes.entity.control.DpBox;
import com.mes.entity.control.DpBoxPallet;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 开发平台-栈板管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "开发平台-栈板管理", description = "开发平台-栈板管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpboxpallet", description = "开发平台-栈板管理")})}*/)
@Path(RestConstants.RestPathPrefix.DPBOXPALLET)
public class DpBoxPalletRestServer extends BaseRestServerInterfaceImpl<DpBoxPallet> {
    @Override
    public IDpBoxPalletProvider getDubboBaseInterface() {
        return ControlConsumer.getDpBoxPalletProvider();
    }

    @GET
    @Path("/findByPdId")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据包装箱Id查询", notes = "根据包装箱Id查询", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByPdId(@ApiParam(value = "包装箱Id")@QueryParam("pdId")String pdId,@ApiParam(value = "栈板编码")@QueryParam("palletKey")String palletKey){
        DpBoxPallet boxPallets = null;
        try {
            boxPallets = this.getDubboBaseInterface().findByPdId(pdId,palletKey);
            this.addOperationLog("包装箱数据数据查询成功", "", true);
            jsonView.successPack(boxPallets);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("包装箱数据数据查询失败", "", false);
            log.error("DpBoxRestServer findByPdId is error", e);
        }
        return jsonView;


    }

}
