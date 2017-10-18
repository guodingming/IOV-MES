package com.mes.restful.control.station.Impl;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.*;
import com.mes.entity.control.*;
import com.mes.restful.control.station.StationBaseRestServer;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by bo.zhou1 on 2017/9/13.
 */
@Api(value = "工作站-包装", description = "工作站-包装")
@Path(RestConstants.RestPathPrefix.STATION + "/package")
public class PackageBaseRestServer extends StationBaseRestServer {

    private IDpBoxProductInfoProvider dpBoxProductInfoProvider = ControlConsumer.getDpBoxProductInfoProvider();

    private IDpBoxProvider dpBoxProvider = ControlConsumer.getDpBoxProvider();

    private IPdProductInfoNumberProvider pdProductInfoNumberProvider = ControlConsumer.getPdProductInfoNumberProvider();

    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    private IAgentProvider agentProvider = ControlConsumer.getAgentProvider();

    /**
     * 产品和包装箱绑定
     *
     * @param number
     * @param boxKey
     * @return
     */
    @GET
    @Path("saveProductToBox")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "包装产品到包装箱", notes = "包装产品到包装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveProductToBox(@ApiParam(value = "条码") @QueryParam("number") String number, @ApiParam(value = "包装箱码") @QueryParam("boxKey") String boxKey) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                if (StringUtils.isNotBlank(number)) {
                    if (StringUtils.isNotBlank(boxKey)) {
                        DpProduceProcess produceProcess = super.getSessionProduceProcess();
                        User user = super.getSessionUser();
                        PdWorkOrder workOrder = super.getSessionWorkOrder();
                        PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberProvider.findByNumber(number);
                        DpBox box = this.dpBoxProvider.findByBoxKey(boxKey);
                        boolean processValidate = this.dpRoutesProvider.checkProductProcess(productInfoNumber.getPdProductInfoId(), produceProcess.getId());
                        if (processValidate) {
                            if (null != productInfoNumber && null != box) {
                                boolean isFull = this.dpBoxProductInfoProvider.saveProductToBox(number, boxKey);
                                if (isFull) {
                                    boolean flag = this.dpBoxProductInfoProvider.passStation(boxKey, user.getId(), produceProcess.getId());
                                    if (flag) {
                                        String agentId = ConfigHelper.getValue("box.print.agent.id");
                                        //调用agent打印箱标签
                                        boolean printFlag = agentProvider.printBoxLabel(agentId, workOrder, boxKey);
                                        if (printFlag) {
                                            return jsonView.successPack(true, "强制装箱成功");
                                        }
                                        return jsonView.failPack(false, "强制装箱失败,箱标签打印失败");
                                    }
                                }
                                jsonView.successPack(true, "包装成功");
                            } else {
                                jsonView.failPack(false, "包装失败,该条码或包装箱不存在");
                            }
                        } else {
                            jsonView.failPack(false, "包装失败,该产品任务未到包装站");
                        }
                    } else {
                        jsonView.failPack(false, "包装失败,请输入包装箱号");
                    }
                } else {
                    jsonView.failPack(false, "包装失败,请输入产品条码");
                }
            } else {
                jsonView.failPack(false, "包装失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "包装失败,服务器异常");
            this.addOperationLog("产品添加到包装箱失败", "", false);
            log.error("PackageBaseRestServer saveProductToBox is error", e);
        }
        return jsonView;
    }


    /**
     * 验证产品是否已经和包装箱绑定
     *
     * @param number
     * @param boxKey
     * @return ledengyun--2017/09/08
     */
    @GET
    @Path("/checkCode")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "验证产品是否已经绑定", notes = "验证产品是否已经绑定", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject checkCode(@ApiParam(value = "条码") @QueryParam("number") String number, @ApiParam(value = "包装箱码") @QueryParam("boxKey") String boxKey) {
        try {
            jsonView = this.dpBoxProductInfoProvider.checkCode(number, boxKey);
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "验证失败!");
            this.addOperationLog("验证失败", "", false);
            log.error("PackageBaseRestServer checkCode is error", e);
        }
        return jsonView;
    }

    /**
     * 解除产品与包装箱的绑定
     * ledengyun--2017/09/08
     *
     * @param number
     * @param boxKey
     * @return
     */
    @GET
    @Path("/deleteByNum")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "解除绑定", notes = "解除绑定", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject deleteByNum(@ApiParam(value = "条码") @QueryParam("number") String number, @ApiParam(value = "包装箱码") @QueryParam("boxKey") String boxKey) {
        boolean flag;
        try {
            flag = this.dpBoxProductInfoProvider.deleteByNum(number, boxKey);
            if (flag) {
                jsonView.successPack(flag);
                this.addOperationLog("该产品与该包装箱绑定已解除", "", true);
            } else {
                jsonView.failPack(flag, "该产品与包装箱绑定关系无法解除");
                this.addOperationLog("该产品与包装箱绑定关系无法解除", "", false);
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("该产品与该包装箱绑定解除失败", "", false);
            log.error("PackageBaseRestServer deleteByNum is error", e);
        }

        return jsonView;
    }

    /**
     * 以包装信息分页查询
     *
     * @param page 分页对象
     * @return
     */
    @POST
    @Path("/productBoxByPage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据条件分页查询包装记录", notes = "根据条件分页查询包装记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject productBoxByPage(@ApiParam(value = "查询条件和分页参数", required = true, defaultValue = "", example = "{\"pageSize\": 10, \"pageNum\": 1}") Page page) {
        JSON result;
        String jsonStr = JSON.toJSONString(page);
        try {
            Map<String, Object> mapBean = Maps.newHashMap();
            if (page != null) {
                if (page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
                    mapBean = (Map) page.getCondition();
                }
            }
            page = this.dpBoxProductInfoProvider.productBoxByPage(page, mapBean);
            result = (JSON) JSON.toJSON(page);
            jsonView.successPack(result);
            this.addOperationLog("分页查询包装记录", jsonStr, true);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("分页查询包装记录", jsonStr, false);
            log.error("PackageBaseRestServer productBoxByPage is error,{jsonStr:" + jsonStr + "}", e);
        }
        return jsonView;
    }

    /**
     * 装箱
     *
     * @param boxKey 箱号
     * @return
     */
    @GET
    @Path("/boxUp")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "强制装箱", notes = "强制装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject boxUp(@ApiParam(value = "箱号") @QueryParam("boxKey") String boxKey, @ApiParam(value = "AgentID") @QueryParam("agentId") String agentId) {
        try {
            agentId = "H51FEAF0C454645DCB1B48EC2BFF56D5E";
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                PdWorkOrder pdWorkOrder = super.getSessionWorkOrder();
                User user = super.getSessionUser();
                DpProduceProcess dpProduceProcess = super.getSessionProduceProcess();
                boolean flag = this.dpBoxProductInfoProvider.passStation(boxKey, user.getId(), dpProduceProcess.getId());
                if (flag) {
                    //调用agent打印箱标签
                    boolean printFlag = agentProvider.printBoxLabel(agentId, pdWorkOrder, boxKey);
                    if (printFlag) {
                        DpBox dpBox = this.dpBoxProvider.findByBoxKey(boxKey);
                        dpBox.setIsForcedPack("1");
                        dpBoxProvider.update(dpBox);
                        return jsonView.successPack(true, "强制装箱成功");
                    }
                    return jsonView.failPack(false, "强制装箱失败,箱标签打印失败");
                }
                return jsonView.failPack(false, "强制装箱失败,产品过站失败");
            }
            return jsonView.failPack(false, "强制装箱失败,请重新登录");
        } catch (Exception e) {
            jsonView.failPack(false, "强制装箱失败,服务器异常");
            this.addOperationLog("强制装箱", "", false);
            log.error("PackageBaseRestServer boxUp is error", e);
        }
        return jsonView;
    }

    /**
     * 将原包装箱产品移至目标包装箱
     *
     * @param sourceBoxKey      原箱号
     * @param targetBoxKey      目标箱号
     * @param boxProductInfoIds 待移动箱产品
     * @return
     */
    @GET
    @Path("/unionBox")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "将原包装箱产品移至目标包装箱", notes = "将原包装箱产品移至目标包装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject unionBox(
            @ApiParam(value = "原箱号") @QueryParam("sourceBoxKey") String sourceBoxKey,
            @ApiParam(value = "目标箱号") @QueryParam("targetBoxKey") String targetBoxKey,
            @ApiParam(value = "包装产品ID") @QueryParam("boxProductInfoIds") String boxProductInfoIds) {
        try {
            jsonView = this.dpBoxProductInfoProvider.updateProductUnionBox(sourceBoxKey, targetBoxKey, boxProductInfoIds);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("将原包装箱产品移至目标包装箱", "将原包装箱产品移至目标包装箱失败", false);
            log.error("PackageBaseRestServer unionBox is error", e);
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
            @ApiParam(value = "包装产品ID") @QueryParam("boxProductInfoIds") String boxProductInfoIds) {
        try {
            jsonView = this.dpBoxProductInfoProvider.updateUnBox(boxKey, boxProductInfoIds);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("将原包装箱产品移至目标包装箱", "将原包装箱产品移至目标包装箱失败", false);
            log.error("PackageBaseRestServer unBox is error", e);
        }
        return jsonView;
    }

    /**
     * 获取指定箱中的所有产品
     *
     * @param boxKey
     * @return
     */
    @GET
    @Path("/getBoxProduct")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取指定箱中的所有产品", notes = "获取指定箱中的所有产品", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getBoxProduct(@ApiParam(value = "箱号") @QueryParam("boxKey") String boxKey) {
        try {
            jsonView = this.dpBoxProductInfoProvider.getBoxProduct(boxKey);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("获取指定箱中的所有产品", "获取指定箱中的所有产品失败", false);
            log.error("PackageBaseRestServer getBoxProduct is error", e);
        }
        return jsonView;
    }

    @GET
    @Path("/findByPdId")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品Id查询包装箱", notes = "根据产品Id查询包装箱", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByPdId(@ApiParam(value = "产品Id") @QueryParam("pdId") String pdId, @ApiParam(value = "包装箱嘛") @QueryParam("boxKey") String boxKey) {
        DpBox box = null;
        try {
            box = this.dpBoxProvider.findByPdId(pdId, boxKey);
            this.addOperationLog("包装箱数据数据查询成功", "", true);
            jsonView.successPack(box);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("包装箱数据数据查询失败", "", false);
            log.error("PackageBaseRestServer findByPdId is error", e);
        }
        return jsonView;
    }

    /**
     * 根据箱码获取包装箱信息
     *
     * @param boxKey
     * @return
     */
    @GET
    @Path("/findByBoxKey")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据箱码查询包装箱信息", notes = "根据箱码查询包装箱信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByBoxKey(@ApiParam(value = "包装箱嘛") @QueryParam("boxKey") String boxKey) {
        DpBox box = null;
        try {
            box = this.dpBoxProvider.findByBoxKey(boxKey);
            if (null != box) {
                this.addOperationLog("包装箱数据数据查询成功", "", true);
                jsonView.successPack(box, "包装箱数据数据查询成功");
            } else {
                this.addOperationLog("包装箱数据数据查询失败", "", true);
                jsonView.failPack(box, "包装箱数据数据查询失败");
            }

        } catch (DubboProviderException e) {
            jsonView.failPack(box, "包装箱数据数据查询失败");
            this.addOperationLog("包装箱数据数据查询失败", "", false);
            log.error("PackageBaseRestServer findByPdId is error", e);
        }
        return jsonView;
    }

    /**
     * 根据产品条码查询装箱产品信息
     *
     * @param number
     * @return
     */
    @GET
    @Path("/boxProduct")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品条码查询装箱产品信息", notes = "根据产品条码查询装箱产品信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findBoxProductByNumber(@ApiParam(value = "产品条码") @QueryParam("number") String number, @ApiParam(value = "包装箱嘛") @QueryParam("boxKey") String boxKey) {
        try {
            if (StringUtils.isNotBlank(number)) {
                jsonView = this.dpBoxProductInfoProvider.findBoxProductByNumber(number, boxKey);
            } else {
                jsonView.failPack("请输入指定参数");
            }
            this.addOperationLog("根据产品条码查询装箱产品信息", "", true);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("根据产品条码查询装箱产品信息失败", "", false);
            log.error("PackageBaseRestServer boxProduct is error", e);
        }
        return jsonView;
    }
}
