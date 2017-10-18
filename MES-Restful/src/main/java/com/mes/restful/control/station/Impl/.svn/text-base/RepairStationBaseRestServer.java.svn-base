package com.mes.restful.control.station.Impl;

/**
 * Created by bo.zhou1 on 2017/9/8.
 */

import com.google.common.collect.Lists;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpRepairStationBadInfoProvider;
import com.mes.dubbo.interprovider.control.IDpRepairStationProvider;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.entity.control.*;
import com.mes.restful.control.station.StationBaseRestServer;
import com.mes.utils.RestConstants;
import edu.emory.mathcs.backport.java.util.Arrays;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-条码
 */
@Api(value = "工作站-维修站", description = "工作站-维修站")
@Path(RestConstants.RestPathPrefix.STATION + "/repair")
public class RepairStationBaseRestServer extends StationBaseRestServer {


    private IDpRepairStationProvider dpRepairStationProvider = ControlConsumer.getDpRepairStationProvider();

    private IDpRepairStationBadInfoProvider dpRepairStationBadInfoProvider = ControlConsumer.getDpRepairStationBadInfoProvider();

    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    /**
     * 根据产品条码获取产品维修站信息
     *
     * @param number
     * @return
     */
    @GET
    @Path("/getRepairStationInfoByNumber")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品条码获取产品维修站信息", notes = "根据产品条码获取产品维修站信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getRepairStationInfoByNumber(@ApiParam(value = "产品条码") @QueryParam("number") String number) {
        try {
            if (StringUtils.isNotBlank(number)) {
                jsonView = this.dpRepairStationProvider.getRepairStationInfoByNumber(number);
            } else {
                jsonView.failPack(Lists.newArrayList(), "根据产品条码获取产品维修站信息失败,服务器异常");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "根据产品条码获取产品维修站信息失败,服务器异常");
            this.addOperationLog("根据产品条码获取产品维修站信息", "根据产品条码获取产品维修站信息失败", false);
            log.error("getRepairStationInfoByNumber getRepairStationInfoByNumber is error", e);
        }
        return jsonView;
    }

    /**
     * 维修站产品报废
     *
     * @return
     */
    @GET
    @Path("/reject")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "维修站报废产品", notes = "维修站报废产品", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject reject(@ApiParam(value = "维修站记录ID") @QueryParam("repairStationId") String repairStationId) {
        try {
            if (StringUtils.isNotBlank(repairStationId)) {
                DpRepairStation repairStation = new DpRepairStation();
                repairStation.setId(repairStationId);
                repairStation.setStatus(DpRepairStation.Status.REJECT);
                boolean flag = this.dpRepairStationProvider.update(repairStation);
                //TODO 需要修改产品状态
                if (flag) {
                    jsonView.successPack(true, "报废产品成功");
                } else {
                    jsonView.failPack(false, "报废产品失败,服务器异常");
                }
            } else {
                jsonView.failPack(false, "报废产品失败,服务器异常");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "报废产品失败,服务器异常");
            this.addOperationLog("维修站报废产品", "维修站报废产品失败", false);
            log.error("getRepairStationInfoByNumber reject is error", e);
        }
        return jsonView;
    }

    /**
     * 维修站判定良品并转到指定工序
     *
     * @param repairStationId
     * @param condition
     * @return
     */
    @GET
    @Path("/gotoProcess")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "维修站判定良品并转到指定工序", notes = "维修站判定良品并转到指定工序", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject gotoProcess(@ApiParam(value = "维修站记录ID") @QueryParam("repairStationId") String repairStationId, @ApiParam(value = "工序流转条件") @QueryParam("condition") String condition) {
        try {
            if (StringUtils.isNotBlank(repairStationId) &&
                    StringUtils.isNotBlank(condition)) {
                User user = super.getSessionUser();
                DpProduceProcess dpProduceProcess = super.getSessionProduceProcess();
                if (null != user) {
                    boolean flag = this.dpRoutesProvider.completeTaskToProcess(repairStationId, user.getId(), condition, dpProduceProcess);
                    if (flag) {
                        jsonView.successPack(true, "转到指定工序成功");
                    } else {
                        jsonView.failPack(false, "转到指定工序失败,服务器异常");
                    }
                } else {
                    jsonView.failPack(false, "转到指定工序失败,请重新登录");
                }
            } else {
                jsonView.failPack(false, "转到指定工序失败,服务器异常");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "转到指定工序失败,服务器异常");
            this.addOperationLog("维修站良品判断跳转工序", "维修站良品判断跳转工序失败", false);
            log.error("getRepairStationInfoByNumber gotoProcess is error", e);
        }
        return jsonView;
    }


    /**
     * 获取维修站出口工序信息
     *
     * @param pdProductInfoId
     * @return
     */
    @GET
    @Path("/getRepairStationNextProcess")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取维修站出口工序信息", notes = "获取维修站出口工序信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getRepairStationNextProcess(@ApiParam(value = "产品信息ID") @QueryParam("pdProductInfoId") String pdProductInfoId) {
        try {
            if (StringUtils.isNotBlank(pdProductInfoId)) {
                jsonView = this.dpRepairStationProvider.getRepairStationNextProcess(pdProductInfoId);
            } else {
                jsonView.failPack(Lists.newArrayList(), "获取维修站出口工序信息失败,服务器异常");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "获取维修站出口工序信息,服务器异常");
            this.addOperationLog("维修站良品判断跳转工序", "维修站良品判断跳转工序失败", false);
            log.error("getRepairStationInfoByNumber gotoProcess is error", e);
        }
        return jsonView;
    }

    /**
     * 根据产品条码获取产品不良信息
     *
     * @param number
     * @return
     */
    @GET
    @Path("/getBadInfoByNumber")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品条码获取产品不良信息", notes = "根据产品条码获取产品不良信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getBadInfoByNumber(@ApiParam(value = "产品条码") @QueryParam("number") String number) {
        try {
            if (StringUtils.isNotBlank(number)) {
                jsonView = this.dpRepairStationBadInfoProvider.getBadInfoByNumber(number);
            } else {
                jsonView.failPack(false, "请传入指定参数");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("根据产品条码获取产品不良信息", "根据产品条码获取产品不良信息失败", false);
            log.error("DpRepairStationBadInfoRestServer getBadInfoByNumber is error", e);
        }
        return jsonView;
    }


    /**
     * 维修不良并录入维修信息
     *
     * @param dpRepairStationBadInfo
     * @return
     */
    @POST
    @Path("operation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "维修不良并录入维修信息", notes = "维修不良并录入维修信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject repair(@ApiParam(value = "维修信息对象") DpRepairStationBadInfo dpRepairStationBadInfo) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                User user = super.getSessionUser();
                if (dpRepairStationBadInfo != null) {
                    String ids = dpRepairStationBadInfo.getPdProductInfoIds();
                    if (StringUtils.isNotBlank(ids)) {
                        boolean flag = false;
                        List<String> pdProductBadInfoIds = Arrays.asList(ids.split(","));
                        for (String pdProductInfoId : pdProductBadInfoIds) {
                            dpRepairStationBadInfo.setId(pdProductInfoId);
                            dpRepairStationBadInfo.setRepairUserName(user.getName());
                            dpRepairStationBadInfo.setRepairUserId(user.getId());
                            dpRepairStationBadInfo.setIsRework("1");
                            flag = this.dpRepairStationBadInfoProvider.update(dpRepairStationBadInfo);
                        }
                        if (flag) {
                            jsonView.successPack(true, "维修不良并录入维修信息成功");
                        } else {
                            jsonView.failPack(false, "维修不良并录入维修信息失败,服务器异常");
                        }
                    } else {
                        jsonView.failPack(false, "维修不良并录入维修信息失败,服务器异常");
                    }
                } else {
                    jsonView.failPack(false, "维修不良并录入维修信息失败,服务器异常");
                }
            } else {
                jsonView.failPack(false, "维修不良并录入维修信息失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "维修不良并录入维修信息失败,服务器异常");
            this.addOperationLog("维修不良并录入维修信息", "维修不良并录入维修信息失败", false);
            log.error("DpRepairStationBadInfoRestServer repair is error", e);
        }
        return jsonView;
    }

    /**
     * 修改不良记录
     *
     * @param dpRepairStationBadInfo
     * @return
     */
    @POST
    @Path("/editRepairBadInfo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "修改不良记录", notes = "修改不良记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject editRepairBadInfo(@ApiParam(value = "不良信息对象", required = true) DpRepairStationBadInfo dpRepairStationBadInfo) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                boolean flag = this.dpRepairStationBadInfoProvider.update(dpRepairStationBadInfo);
                if (flag) {
                    jsonView.failPack(true, "修改不良记录成功");
                } else {
                    jsonView.failPack(false, "修改不良记录失败,服务器异常");
                }
                this.addOperationLog("修改不良记录成功！", "", true);
            } else {
                jsonView.failPack(false, "修改不良记录失败,请重新登录");
                this.addOperationLog("修改不良记录失败！", "", true);
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "修改不良记录失败,服务器异常");
            this.addOperationLog("修改不良记录失败！", "", false);
            log.error("RepairStationBaseRestServer editRepairBadInfo is error", e);
        }
        return jsonView;
    }


}
