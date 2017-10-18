package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpBoxProvider;
import com.mes.entity.control.DpBarcode;
import com.mes.entity.control.DpBox;
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
 * 开发平台-包装箱管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "开发平台-包装箱管理", description = "开发平台-包装箱管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpbox", description = "开发平台-包装箱管理")})}*/)
@Path(RestConstants.RestPathPrefix.DPBOX)
public class DpBoxRestServer extends BaseRestServerInterfaceImpl<DpBox> {
    @Override
    public IDpBoxProvider getDubboBaseInterface() {
        return ControlConsumer.getDpBoxProvider();
    }

    @GET
    @Path("/findByPdId")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品Id查询包装箱", notes = "根据产品Id查询包装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByPdId(@ApiParam(value = "产品Id")@QueryParam("pdId")String pdId,@ApiParam(value = "包装箱嘛")@QueryParam("boxKey")String boxKey){
        DpBox box = null;
        try {
            box = this.getDubboBaseInterface().findByPdId(pdId,boxKey);
            this.addOperationLog("包装箱数据数据查询成功", "", true);
            jsonView.successPack(box);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("包装箱数据数据查询失败", "", false);
            log.error("DpBoxRestServer findByPdId is error", e);
        }
        return jsonView;
    }

    /**
     * 根据箱码获取包装箱信息
     * @param boxKey
     * @return
     */

    @GET
    @Path("/findByBoxKey")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据箱码查询包装箱信息", notes = "根据箱码查询包装箱信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByBoxKey(@ApiParam(value = "包装箱嘛")@QueryParam("boxKey")String boxKey){
        DpBox box = null;
        try {
            box = this.getDubboBaseInterface().findByBoxKey(boxKey);
            this.addOperationLog("包装箱数据数据查询成功", "", true);
            jsonView.successPack(box);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("包装箱数据数据查询失败", "", false);
            log.error("DpBoxRestServer findByPdId is error", e);
        }
        return jsonView;
    }

}
