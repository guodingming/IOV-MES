package com.mes.restful.control.station.Impl;

import com.google.common.collect.Maps;
import com.mes.common.framework.Constants;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.*;
import com.mes.entity.control.*;
import com.mes.restful.control.station.StationBaseRestServer;
import com.mes.utils.RestConstants;
import edu.emory.mathcs.backport.java.util.Arrays;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * Created by bo.zhou1 on 2017/9/13.
 */
@Api(value = "工作站-公共接口", description = "工作站-公共接口")
@Path(RestConstants.RestPathPrefix.STATION + "/common")
public class CommonBaseRestServer extends StationBaseRestServer {

    private IUserProvider userProvider = ControlConsumer.getUserProvider();

    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    private IDpRepairStationBadInfoProvider dpRepairStationBadInfoProvider = ControlConsumer.getDpRepairStationBadInfoProvider();

    private IDpProduceProcessProvider dpProduceProcessProvider = ControlConsumer.getDpProduceProcessProvider();


    /**
     * 工作站用户登录鉴权
     *
     * @param userProcess
     * @return
     */
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "工作站用户登录鉴权", notes = "工作站用户登录鉴权", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject stationLogin(UserProcess userProcess) {
        try {
            jsonView = this.userProvider.auth(userProcess);
            Map<String, Object> ret = (Map<String, Object>) jsonView.getContent();
            if (ret != null) {
                request.getSession().setAttribute("station", ret);
                request.getSession().setAttribute("stationInfo", userProcess);
                this.addOperationLog("用户登录成功", "", true);
                jsonView.successPack(ret, "用户登录成功!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("工作站用户登录鉴权失败", "", false);
            log.error("UserRestServer auth is error", e);
        }
        return jsonView;
    }

    /**
     * 工作站用户信息校验
     *
     * @return
     */
    @GET
    @Path("/validate")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "用户Session验证", notes = "用户Session验证", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public Response stationValidate() {
        try {
            Object ret = request.getSession().getAttribute("stationInfo");
            if (ret != null) {
                UserProcess userProcess = (UserProcess) ret;
                jsonView = this.userProvider.stationValidate(userProcess);
                if (jsonView.getStatus().equalsIgnoreCase(Constants.jsonView.STATUS_FAIL)) {
                    jsonView.failPack("用户信息校验失败");
                    return Response.status(Response.Status.UNAUTHORIZED).entity(jsonView).build();
                } else {
                    this.addOperationLog("用户Session验证成功", "", true);
                    jsonView.setMessage("用户Session验证成功");
                }
            } else {
                jsonView.failPack("用户未登录");
                return Response.status(Response.Status.UNAUTHORIZED).entity(jsonView).build();
            }
        } catch (Exception e) {
            jsonView.failPack(false, "用户Session验证失败");
            this.addOperationLog("用户Session验证失败", "", false);
            log.error("UserRestServer stationValidate is error", e);
        }
        return Response.ok(jsonView).build();
    }

    /**
     * 不良记录保存
     *
     * @param
     * @return ledengyun--2017/09/07
     */
    @POST
    @Path("/saveRepairBadInfo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "保存不良记录", notes = "保存不良记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject saveRepairBadInfo(@ApiParam(value = "不良信息对象", required = true) DpRepairStationBadInfo dpRepairStationBadInfo) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                User user = super.getSessionUser();
                PdWorkOrder workOrder = super.getSessionWorkOrder();
                DpProduceProcess produceProcess = super.getSessionProduceProcess();
                dpRepairStationBadInfo.setEntryUserId(user.getId());
                dpRepairStationBadInfo.setEntryUserName(user.getName());
                dpRepairStationBadInfo.setWorkOrderId(workOrder.getId());
                dpRepairStationBadInfo.setIsRework("0");
                boolean flag = this.dpRoutesProvider.completeTaskToRepairStation(dpRepairStationBadInfo.getPdProductInfoId(), user.getId(), produceProcess.getId());
                if (flag) {
                    jsonView = this.dpRepairStationBadInfoProvider.saveRepairInfo(dpRepairStationBadInfo, produceProcess);
                } else {
                    jsonView.failPack(false, "保存不良记录失败,服务器异常");
                }
                this.addOperationLog("不良信息保存成功！", "", true);
            } else {
                jsonView.failPack(false, "保存不良记录失败,请重新登录");
                this.addOperationLog("不良信息保存失败！", "", true);
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "保存不良记录失败,服务器异常");
            this.addOperationLog("不良信息保存失败！", "", false);
            log.error("RepairStationBaseRestServer saveRepairStationInfo is error", e);
        }
        return jsonView;

    }

    /**
     * 工作站登出
     *
     * @return
     */
    @GET
    @Path("logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "工作站用户退出登录", notes = "工作站用户退出登录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject stationLogout() {
        try {
            Object ret = request.getSession().getAttribute("station");
            Object stationInfo = request.getSession().getAttribute("stationInfo");
            if (ret != null) {
                request.getSession().removeAttribute("user");
                request.getSession().invalidate();
            }
            if (stationInfo != null) {
                request.getSession().removeAttribute("stationInfo");
                request.getSession().invalidate();
            }
            this.addOperationLog("工作站用户退出登录", "", true);
            jsonView.successPack(true, "工作站用户退出登录成功!");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("工作站用户退出登录失败", "", false);
            log.error("UserRestServer authOut is error", e);
        }
        return jsonView;
    }

    /**
     * 工作站切换工序信息
     *
     * @param userProcess
     * @return
     */
    @POST
    @Path("switchStation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "切换工序信息", notes = "切换工序信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject switchStation(UserProcess userProcess) {
        try {
            Object o = request.getSession().getAttribute("stationInfo");
            if (o != null) {
                UserProcess info = (UserProcess) o;
                info.setProcessId(userProcess.getProcessId());
                request.getSession().setAttribute("stationInfo", info);
                //更新session信息
                jsonView = this.userProvider.switchStation(info);
                if (null != jsonView.getContent()) {
                    Map<String, Object> ret = (Map<String, Object>) jsonView.getContent();
                    request.getSession().setAttribute("station", ret);
                }
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("切换工序信息失败", "", false);
            log.error("UserRestServer switchStation is error", e);
        }
        return jsonView;
    }

    /**
     * 获取工单信息
     *
     * @return
     */
    @GET
    @Path("/getOrderInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取工单信息", notes = "获取工单信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getOrderInfo() {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                PdWorkOrder workOrder = super.getSessionWorkOrder();
                DpProduceProcess produceProcess = super.getSessionProduceProcess();
                Map map = this.userProvider.getOrderInfo(workOrder.getId(), produceProcess.getId(), produceProcess.getProcessName());
                this.addOperationLog("工单信息获取成功", "", true);
                jsonView.successPack(map, "工单信息获取成功");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Maps.newHashMap(), "工单信息获取失败");
            this.addOperationLog("工单信息获取失败", " ", false);
            log.error("UserRestServer getOrderInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 良品过站
     *
     * @param productInfoIds
     * @return
     */
    @GET
    @Path("passStation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "良品过站", notes = "良品过站", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject passStation(@ApiParam(value = "产品信息ID", required = true) @QueryParam("productInfoIds") String productInfoIds) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                User user = super.getSessionUser();
                DpProduceProcess produceProcess = super.getSessionProduceProcess();
                if (StringUtils.isNotBlank(productInfoIds)) {
                    List<String> ids = Arrays.asList(productInfoIds.split(","));
                    for (String productInfoId : ids) {
                        this.dpRoutesProvider.completeTask(productInfoId, user.getId(), produceProcess.getId(), "1");
                    }
                }
                this.addOperationLog("完成当前任务成功!", "", true);
                jsonView.successPack(true, "完成当前任务成功");
            } else {
                jsonView.failPack(false, "请确认登录信息!");
                this.addOperationLog("完成当前任务失败！", "", true);
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "完成当前任务失败");
            this.addOperationLog("完成当前任务失败！", "", false);
            log.error("RepairStationBaseRestServer passStation is error", e);
        }
        return jsonView;
    }

    /**
     * 根据当前用户信息获取当前工单对应的所有工序
     *
     * @return
     */
    @GET
    @Path("getProduceProcess")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据当前用户信息获取当前工单对应的所有工序", notes = "根据当前用户信息获取当前工单对应的所有工序", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getProduceProcess() {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                PdWorkOrder workOrder = super.getSessionWorkOrder();
                Map<String, Object> query = Maps.newHashMap();
                query.put("projectId", workOrder.getProjectId());
                List<DpProduceProcess> produceProcessList = this.dpProduceProcessProvider.findByMap(query);
                jsonView.successPack(produceProcessList, "获取工序成功!");
            } else {
                jsonView.failPack("请确认登录信息!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据当前用户信息获取当前工单对应的所有工序", "", false);
            log.error("DpProcessBaseConfigRestServer getProduceProcess is error", e);
        }
        return jsonView;
    }

}
