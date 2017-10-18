package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpBoxProductInfoProvider;
import com.mes.entity.control.DpBoxProductInfo;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * 开发平台-包装箱-产品
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "开发平台-包装箱-产品", description = "开发平台-包装箱-产品"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpboxproductinfo", description = "开发平台-包装箱-产品")})}*/)
@Path(RestConstants.RestPathPrefix.DPBOXPRODUCTINFO)
public class DpBoxProductInfoRestServer extends BaseRestServerInterfaceImpl<DpBoxProductInfo> {
    @Override
    public IDpBoxProductInfoProvider getDubboBaseInterface() {
        return ControlConsumer.getDpBoxProductInfoProvider();
    }

    /**
     * 产品和包装箱绑定
     * @param number
     * @param boxKey
     * @return
     */
    @GET
    @Path("saveProductToBox")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "包装产品到包装箱", notes = "包装产品到包装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveProductToBox(@ApiParam(value = "条码")@QueryParam("number") String number,@ApiParam(value = "包装箱码")@QueryParam("boxKey")String boxKey){
        boolean flag = false;
        try {
            flag = this.getDubboBaseInterface().saveProductToBox(number, boxKey);
            this.addOperationLog("产品添加到包装箱成功","",true);
            jsonView.successPack(flag);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("产品添加到包装箱失败", "", false);
            log.error("DpBoxProductInfoRestServer saveProductToBox is error", e);
        }
        return jsonView ;
    }


    /**
     * 验证产品是否已经和包装箱绑定
     * @param number
     * @param boxKey
     * @return
     * ledengyun--2017/09/08
     */
    @GET
    @Path("/checkCode")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "验证产品是否已经绑定", notes = "验证产品是否已经绑定", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject checkCode(@ApiParam(value = "条码")@QueryParam("number") String number,@ApiParam(value = "包装箱码")@QueryParam("boxKey")String boxKey){
        try {
            jsonView = this.getDubboBaseInterface().checkCode(number,boxKey);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("验证失败","",false);
            log.error("DpBoxProductInfoRestServer checkCode is error",e);
        }
        return jsonView;
    }

    /**
     * 解除产品与包装箱的绑定
     *ledengyun--2017/09/08
     * @param number
     * @param boxKey
     * @return
     */
    @GET
    @Path("/deleteByNum")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "解除绑定", notes = "解除绑定", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject deleteByNum(@ApiParam(value = "条码")@QueryParam("number") String number,@ApiParam(value = "包装箱码")@QueryParam("boxKey")String boxKey){
        boolean flag;
        try {
            flag = this.getDubboBaseInterface().deleteByNum(number,boxKey);
            if(flag){
                jsonView.successPack(flag);
                this.addOperationLog("该产品与该包装箱绑定已解除","",true);
            }else{
                jsonView.failPack(flag,"该产品与包装箱绑定关系无法解除");
                this.addOperationLog("该产品与包装箱绑定关系无法解除","",false);
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("该产品与该包装箱绑定解除失败","",false);
            log.error("DpBoxProductInfoRestServer deleteByNum is error",e);
        }

        return jsonView;
    }

    /**
     * 以包装信息分页查询
     * @param page 分页对象
     * @return
     */
    @POST
    @Path("/productBoxByPage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据条件分页查询包装记录", notes = "根据条件分页查询包装记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject productBoxByPage(@ApiParam(value = "查询条件和分页参数", required = true, defaultValue = "", example = "{\"pageSize\": 10, \"pageNum\": 1}") Page page){
        JSON result;
        String jsonStr = JSON.toJSONString(page);
        try {
            Map<String, Object> mapBean = Maps.newHashMap();
            if (page != null) {
                if (page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
                    mapBean = (Map) page.getCondition();
                }
            }
            page = this.getDubboBaseInterface().productBoxByPage(page,mapBean);
            result = (JSON) JSON.toJSON(page);
            jsonView.successPack(result);
            this.addOperationLog("分页查询包装记录", jsonStr, true);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("分页查询包装记录", jsonStr, false);
            log.error("DpBoxProductInfoRestServer productBoxByPage is error,{jsonStr:" + jsonStr + "}", e);
        }
        return jsonView;
    }

    /**
     * 装箱
     * @param boxKey    箱号
     * @return
     */
    @GET
    @Path("/boxUp")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "装箱", notes = "装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject boxUp(@ApiParam(value = "箱号")@QueryParam("boxKey") String boxKey){
        //TODO 后续添加实际装箱操作 （箱标签打印）
        jsonView.successPack("装箱成功!");
        return jsonView;
    }

    /**
     * 将原包装箱产品移至目标包装箱
     *
     * @param sourceBoxKey 原箱号
     * @param targetBoxKey 目标箱号
     * @param boxProductInfoId 待移动箱产品
     * @return
     */
    @GET
    @Path("/unionBox")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "将原包装箱产品移至目标包装箱", notes = "将原包装箱产品移至目标包装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject unionBox(
            @ApiParam(value = "原箱号") @QueryParam("sourceBoxKey") String sourceBoxKey,
            @ApiParam(value = "目标箱号") @QueryParam("targetBoxKey") String targetBoxKey,
            @ApiParam(value = "包装产品ID") @QueryParam("boxProductInfoId") String boxProductInfoId){
        try {
            jsonView = this.getDubboBaseInterface().updateProductUnionBox(sourceBoxKey, targetBoxKey, boxProductInfoId);
        }catch (Exception e){
            jsonView.failPack(e);
            this.addOperationLog("将原包装箱产品移至目标包装箱","将原包装箱产品移至目标包装箱失败",false);
            log.error("DpBoxProductInfoRestServer unionBox is error", e);
        }
        return jsonView;
    }

    /**
     * 拆箱
     *
     * @param boxKey
     * @param boxProductInfoIds
     * @return
     */
    @GET
    @Path("/unBox")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "拆箱", notes = "拆箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject unBox(
            @ApiParam(value = "箱号") @QueryParam("boxKey") String boxKey,
            @ApiParam(value = "包装产品ID") @QueryParam("boxProductInfoIds") String boxProductInfoIds){
        try {
            jsonView = this.getDubboBaseInterface().updateUnBox(boxKey, boxProductInfoIds);
        }catch (Exception e){
            jsonView.failPack(e);
            this.addOperationLog("将原包装箱产品移至目标包装箱","将原包装箱产品移至目标包装箱失败",false);
            log.error("DpBoxProductInfoRestServer unBox is error", e);
        }
        return jsonView;
    }

    /**
     * 获取指定箱中的所有产品
     * @param boxKey
     * @return
     */
    @GET
    @Path("/getBoxProduct")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取指定箱中的所有产品", notes = "获取指定箱中的所有产品", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getBoxProduct(@ApiParam(value = "箱号") @QueryParam("boxKey") String boxKey){
        try {
            jsonView = this.getDubboBaseInterface().getBoxProduct(boxKey);
        }catch (Exception e){
            jsonView.failPack(e);
            this.addOperationLog("获取指定箱中的所有产品","获取指定箱中的所有产品失败",false);
            log.error("DpBoxProductInfoRestServer getBoxProduct is error", e);
        }
        return jsonView;
    }


}
