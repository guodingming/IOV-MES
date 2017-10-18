package com.mes.restful.control.station.Impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
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
import java.util.List;
import java.util.Map;

/**
 * Created by bo.zhou1 on 2017/9/13.
 */
@Api(value = "工作站-组装", description = "工作站-组装")
@Path(RestConstants.RestPathPrefix.STATION + "/assemble")
public class AssembleBaseRestServer extends StationBaseRestServer {

    private IDpMaterialsAssembleProvider materialsAssembleProvider = ControlConsumer.getDpMaterialsAssembleProvider();

    private IPdProductInfoProvider pdProductInfoProvider = ControlConsumer.getPdProductInfoProvider();

    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    private IPdProductInfoNumberProvider pdProductInfoNumberProvider = ControlConsumer.getPdProductInfoNumberProvider();

    private IDpMaterialsInfoProvider dpMaterialsInfoProvider = ControlConsumer.getDpMaterialsInfoProvider();

    private IDpMaterialsLoadProvider dpMaterialsLoadProvider = ControlConsumer.getDpMaterialsLoadProvider();

    /**
     * 组装
     *
     * @param number
     * @param materialIds
     * @return
     */
    @GET
    @Path("/operation")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "组装", notes = "组装", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject operation(@ApiParam(value = "产品条码", required = true) @QueryParam("number") String number, @ApiParam(value = "组装物料对应的上料信息IDs", required = true) @QueryParam("materialIds") String materialIds) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                if (StringUtils.isNotBlank(number)) {
                    DpProduceProcess produceProcess = super.getSessionProduceProcess();
                    User user = super.getSessionUser();
                    PdWorkOrder workOrder = super.getSessionWorkOrder();
                    PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberProvider.findByNumber(number);
                    if (null != productInfoNumber) {
                        boolean processValidate = this.dpRoutesProvider.checkProductProcess(productInfoNumber.getPdProductInfoId(), produceProcess.getId());
                        JsonViewObject result = this.pdProductInfoProvider.checkPassProcess(number, produceProcess.getId());
                        boolean flag = (boolean) result.getContent();
                        if (processValidate) {
                            jsonView = materialsAssembleProvider.updateOperation(number, materialIds, session, false);
                            if (!flag) {
                                this.dpRoutesProvider.completeTask(productInfoNumber.getPdProductInfoId(), user.getId(), produceProcess.getId(), "1");
                            }
                        } else {
                            jsonView.failPack(Lists.newArrayList(), "组装失败,当前产品任务未到组装站");
                        }
                    } else {
                        jsonView.failPack(Lists.newArrayList(), "组装失败,该条码不存在");
                    }
                } else {
                    jsonView.failPack(Lists.newArrayList(), "组装失败,请输入产品条码");
                }
            } else {
                jsonView.failPack(Lists.newArrayList(), "组装失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "组装失败,服务器异常");
            this.addOperationLog("组装失败！", "", false);
            log.error("AssembleBaseRestServer operation is error", e);
        }
        return jsonView;
    }

    /**
     * 获取当前产品已经组装物料
     *
     * @param number
     * @return
     */
    @GET
    @Path("/assembleMaterialsInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取当前产品已经组装物料", notes = "获取当前产品已经组装物料", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject assembleMaterialsInfo(@ApiParam(value = "产品条码", required = true) @QueryParam("number") String number) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (session != null) {
                if (StringUtils.isNotBlank(number)) {
                    PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberProvider.findByNumber(number);
                    if (null != productInfoNumber) {
                        PdWorkOrder workOrder = super.getSessionWorkOrder();
                        DpProduceProcess produceProcess = super.getSessionProduceProcess();
                        List<DpMaterialsAssemble> dpMaterialsAssembleList = this.materialsAssembleProvider.findMaterialsAssemble(productInfoNumber.getPdProductInfoId(), produceProcess, workOrder);
                        jsonView.successPack(dpMaterialsAssembleList, "获取当前产品已经组装物料成功");
                    } else {
                        jsonView.failPack(Lists.newArrayList(), "获取当前产品已经组装物料失败,输入条码不存在");
                    }
                } else {
                    jsonView.failPack(Lists.newArrayList(), "获取当前产品已经组装物料失败,请输入条码");
                }
            } else {
                jsonView.failPack(Lists.newArrayList(), "获取当前产品已经组装物料失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "获取当前产品已经组装物料失败,服务器异常");
            this.addOperationLog("获取当前产品已经组装物料失败！", "", false);
            log.error("AssembleBaseRestServer assembleMaterialsInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 检查是否已经组装
     *
     * @param number
     * @return
     */
    @GET
    @Path("/checkIsAssemble")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "检查是否已经组装", notes = "检查是否已经组装", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject checkIsAssemble(@ApiParam(value = "产品条码", required = true) @QueryParam("number") String number) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                if (StringUtils.isNotBlank(number)) {
                    jsonView = materialsAssembleProvider.checkIsAssemble(number, session);
                } else {
                    jsonView.failPack("请输入正确参数!");
                }
            } else {
                jsonView.failPack("请确认登录信息!");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "检查是否已经组装失败");
            this.addOperationLog("检查是否已经组装失败！", "", false);
            log.error("AssembleBaseRestServer operation is error", e);
        }
        return jsonView;
    }

    /**
     * 重工
     *
     * @param number
     * @param materialIds
     * @return
     */
    @GET
    @Path("/reworkAssemble")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "重工", notes = "重工", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject repeatAssemble(@ApiParam(value = "产品条码", required = true) @QueryParam("number") String number, @ApiParam(value = "组装物料对应的上料信息IDs", required = true) @QueryParam("materialIds") String materialIds) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                if (StringUtils.isNotBlank(number)) {
                    DpProduceProcess produceProcess = super.getSessionProduceProcess();
                    User user = super.getSessionUser();
                    PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberProvider.findByNumber(number);
                    if (null != productInfoNumber) {
                        boolean processValidate = this.dpRoutesProvider.checkProductProcess(productInfoNumber.getPdProductInfoId(), produceProcess.getId());
                        if (processValidate) {
                            jsonView = materialsAssembleProvider.updateOperation(number, materialIds, session, true);
                            this.dpRoutesProvider.completeTask(productInfoNumber.getPdProductInfoId(), user.getId(), produceProcess.getId(), "1");
                        } else {
                            jsonView.failPack(Lists.newArrayList(), "重工失败,当前产品任务未到组装站");
                        }
                    } else {
                        jsonView.failPack(Lists.newArrayList(), "重工失败,该条码不存在");
                    }
                } else {
                    jsonView.failPack(Lists.newArrayList(), "重工失败,请输入产品条码");
                }
            } else {
                jsonView.failPack(Lists.newArrayList(), "重工失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "重工失败,服务器异常");
            this.addOperationLog("重工失败！", "", false);
            log.error("AssembleBaseRestServer operation is error", e);
        }
        return jsonView;
    }

    /**
     * 获取当前工单当前工序所上物料
     *
     * @return
     */
    @GET
    @Path("/materialsInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取当前工单当前工序所上物料", notes = "获取当前工单当前工序所上物料", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject getMaterialsInfo() {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (session != null) {
                PdWorkOrder workOrder = super.getSessionWorkOrder();
                DpProduceProcess produceProcess = super.getSessionProduceProcess();
                if (workOrder != null && produceProcess != null) {
                    jsonView = materialsAssembleProvider.getMaterialsInfo(workOrder, produceProcess);
                } else {
                    jsonView.failPack(Lists.newArrayList(), "获取当前工单当前工序所上物料失败,请重新登录");
                }
            } else {
                jsonView.failPack(Lists.newArrayList(), "获取当前工单当前工序所上物料失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "获取当前工单当前工序所上物料失败,服务器异常");
            this.addOperationLog("获取当前工单当前工序所上物料失败！", "", false);
            log.error("AssembleBaseRestServer getMaterialsInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 获取当前工序所上物料类型
     *
     * @return
     */
    @GET
    @Path("/processLoadMaterials")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取当前工序所上物料类型", notes = "获取当前工序所上物料类型", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject getProcessLoadMaterials() {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (session != null) {
                DpProduceProcess produceProcess = super.getSessionProduceProcess();
                if (produceProcess != null) {
                    Map<String, Object> query = Maps.newHashMap();
                    query.put("produceProcessId", produceProcess.getId());
                    List<DpMaterialsInfo> materialsInfoList = this.dpMaterialsInfoProvider.findByMap(query);
                    jsonView.successPack(materialsInfoList, "获取当前工序所上物料类型成功");
                } else {
                    jsonView.failPack(Lists.newArrayList(), "获取当前工序所上物料类型失败,请重新登录");
                }
            } else {
                jsonView.failPack(Lists.newArrayList(), "获取当前工序所上物料类型失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "获取当前工序所上物料类型失败,服务器异常");
            this.addOperationLog("获取当前工序所上物料类型失败！", "", false);
            log.error("AssembleBaseRestServer getProcessLoadMaterials is error", e);
        }
        return jsonView;
    }

    /**
     * 根据物料类型上料
     *
     * @param dpMaterialsLoad
     * @return
     */
    @POST
    @Path("loadMaterial")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据物料类型上料", notes = "根据物料类型上料", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject loadMaterial(DpMaterialsLoad dpMaterialsLoad) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (session != null) {
                DpProduceProcess produceProcess = super.getSessionProduceProcess();
                PdWorkOrder pdWorkOrder = super.getSessionWorkOrder();
                if (produceProcess != null && pdWorkOrder != null) {
                    jsonView = this.dpMaterialsLoadProvider.saveLoadMaterial(dpMaterialsLoad, pdWorkOrder, produceProcess);
                } else {
                    jsonView.failPack(false, "根据物料类型上料失败,请重新登录");
                }
            } else {
                jsonView.failPack(false, "根据物料类型上料失败,请重新登录");
            }
        } catch (Exception e) {
            jsonView.failPack(false, "根据物料类型上料失败,服务器异常");
            this.addOperationLog("根据物料类型上料失败", "", false);
            log.error("AssembleBaseRestServer loadMaterial is error", e);
        }
        return jsonView;
    }

}
