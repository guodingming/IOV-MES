package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.entity.control.DpRoutes;
import com.mes.entity.control.PdProductInfo;
import com.mes.entity.control.User;
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
import java.util.Map;

/**
 * 开发平台-工艺路径管理（Routes）
 */
@Api(value = "开发平台-工艺路径管理（Routes）", description = "开发平台-工艺路径管理（Routes）")
@Path(RestConstants.RestPathPrefix.DPROUTES)
public class DpRoutesRestServer extends BaseRestServerInterfaceImpl<DpRoutes> {
    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    @Override
    public IDpRoutesProvider getDubboBaseInterface() {
        return dpRoutesProvider;
    }


    /**
     * 工艺路径流程
     * 流程部署
     *
     * @return
     */
    @GET
    @Path("deployWorkFlow")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "工艺路径流程部署", notes = "部署流程", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject deployWorkFlow(@ApiParam(value = "", required = true, defaultValue = "") @QueryParam("ids") String ids) {
        try {
            boolean flag = dpRoutesProvider.updateDeployWorkFlow(ids);
            this.addOperationLog("流程部署成功!", "", true);
            jsonView.successPack(flag);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("流程部署失败!", "", false);
            log.error("DpRoutesRestServer deployWorkFlow is error", e);
        }
        return jsonView;
    }


    /**
     * 工艺路径流程
     * 流程部署
     * 取消
     *
     * @return
     */
    @GET
    @Path("unDeployWorkFlow")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "工艺路径流程部署", notes = "取消部署流程", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject unDeployWorkFlow(@ApiParam(value = "", required = true, defaultValue = "") @QueryParam("ids") String ids) {
        try {
            boolean flag = dpRoutesProvider.updateUnDeployWorkFlow(ids);
            this.addOperationLog("取消流程部署成功!", "", true);
            jsonView.successPack(flag);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("取消流程部署失败!", "", false);
            log.error("DpRoutesRestServer unDeployWorkFlow is error", e);
        }
        return jsonView;
    }

    /**
     * 工单投产
     *
     * @param SN          条码
     * @param num         连版数
     * @param pdId        产品ID
     * @param workOrderId 工单ID
     * @return
     */
    @GET
    @Path("startWorkFlow")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "工单投产", notes = "投产", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject startWorkFlow(@ApiParam(value = "SN号", required = true, defaultValue = "") @QueryParam("SN") String SN, @ApiParam(value = "连板数", required = true, defaultValue = "") @QueryParam("num") int num, @ApiParam(value = "产品ID", required = true, defaultValue = "") @QueryParam("pdId") String pdId, @ApiParam(value = "工单ID", required = true, defaultValue = "") @QueryParam("workOrderId") String workOrderId) {
        try {
            List<PdProductInfo> productInfoList = dpRoutesProvider.startWorkFlow(SN, num, pdId, workOrderId);
            if (!productInfoList.isEmpty()) {
                this.addOperationLog("投产成功!", "", true);
                jsonView.successPack(productInfoList);
            } else {
                jsonView.failPack("投产失败!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("投产失败!", "", false);
            log.error("DpRoutesRestServer startWorkFlow is error", e);
        }
        return jsonView;
    }


    /**
     * 获取指定产品待办任务
     *
     * @param productInfoId 产品信息
     * @return
     */
    @GET
    @Path("getTask")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取待办任务", notes = "获取待办任务", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getTask(
            @ApiParam(value = "产品信息ID", defaultValue = "") @QueryParam("productInfoId")String productInfoId) {
        try {
            DpProductInfoLog productInfoLog = null;
            if (StringUtils.isNotBlank(productInfoId)) {
                productInfoLog = this.dpRoutesProvider.getTask(productInfoId);
            }
            jsonView.successPack(productInfoLog, "获取待办任务成功");
            this.addOperationLog("获取待办任务成功", "", true);
        } catch (Exception e) {
            jsonView.failPack(e.getMessage(), "获取待办任务失败");
            this.addOperationLog("获取待办任务失败", "", false);
            log.error("DpRoutesRestServer getTask is error", e);
        }
        return jsonView;
    }

     /**
     *  完成指定产品任务
      *
     * @param pdProductInfoId   产品ID
     * @param produceProcessId  生产工序ID
     * @param isSuccess         工序执行结果
     * @return
     */
    @GET
    @Path("completeTask")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "完成当前任务", notes = "完成当前任务", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject completeTask(@ApiParam(value = "产品信息ID", required = true, defaultValue = "") @QueryParam("pdProductInfoId") String pdProductInfoId,@ApiParam(value = "生产工序Id", required = true, defaultValue = "") @QueryParam("produceProcessId") String produceProcessId,@ApiParam(value = "工序结果", required = true, defaultValue = "") @QueryParam("isSuccess") String isSuccess) {
        try {
            boolean flag = false;
            Object u = request.getSession().getAttribute("user");
            if (u != null) {
                Map<String, Object> session = (Map<String, Object>) u;
                User user = (User) session.get("userInfo");
                if (StringUtils.isNotBlank(pdProductInfoId)
                        && StringUtils.isNotBlank(pdProductInfoId)) {
                    flag = dpRoutesProvider.completeTask(pdProductInfoId, user.getId(), produceProcessId,isSuccess);
                }
            }
            if (flag) {
                this.addOperationLog("完成当前任务成功!", "", true);
                jsonView.successPack(flag, "完成当前任务成功");
            } else {
                this.addOperationLog("完成当前任务失败!", "", true);
                jsonView.successPack(flag, "完成当前任务失败");
            }
        } catch (Exception e) {
            jsonView.failPack(e.getMessage(), "完成当前任务失败");
            this.addOperationLog("完成当前任务失败!", "", false);
            log.error("DpRoutesRestServer completeTask is error", e);
        }
        return jsonView;
    }

    /**
     * 根据开发工程id查询工艺流程基础插件和工序插件
     *
     * @param projectId
     * @return
     */
    @GET
    @Path("getRouteProcesses")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据开发工程id查询工艺流程基础插件和工序插件", notes = "根据开发工程id查询工艺流程基础插件和工序插件", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getRouteProcesses(@ApiParam(value = "开发工程id", required = true, defaultValue = "") @QueryParam("projectId") String projectId) {
        try {
            List<Node> nodes = this.getDubboBaseInterface().getRouteProcesses(projectId);
            this.addOperationLog("根据开发工程id查询工艺流程基础插件和工序插件成功!", "", true);
            jsonView.successPack(nodes, "根据开发工程id查询工艺流程基础插件和工序插件成功");
        } catch (Exception e) {
            jsonView.failPack(e.getMessage(), "根据开发工程id查询工艺流程基础插件和工序插件失败");
            this.addOperationLog("根据开发工程id查询工艺流程基础插件和工序插件失败!", "", false);
            log.error("DpRoutesRestServer getRouteProcesses is error", e);
        }
        return jsonView;
    }


    /**
     * 查询产品指定工序执行是否成功
     *
     * @param productInfoId
     * @param produceProcessId
     * @return
     */
    @GET
    @Path("getProduceProcessStatus")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询产品指定工序执行是否成功", notes = "查询产品指定工序执行是否成功", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getRouteProcesses(@ApiParam(value = "产品信息id", required = true, defaultValue = "") @QueryParam("productInfoId") String productInfoId,
                                            @ApiParam(value = "生产工序id", required = true, defaultValue = "") @QueryParam("produceProcessId") String produceProcessId) {
        try {
            String ret = this.getDubboBaseInterface().getProduceProcessStatus(productInfoId, produceProcessId);
            this.addOperationLog("查询产品指定工序执行是否成功!", "", true);
            jsonView.successPack(ret, "查询产品指定工序执行是否成功");
        } catch (Exception e) {
            jsonView.failPack(e.getMessage(), "查询产品指定工序执行是否成功");
            this.addOperationLog("查询产品指定工序执行是否成功失败!", "", false);
            log.error("DpRoutesRestServer getProduceProcessStatus is error", e);
        }
        return jsonView;
    }
}
