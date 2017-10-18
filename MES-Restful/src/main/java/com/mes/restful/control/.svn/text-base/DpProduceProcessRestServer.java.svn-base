package com.mes.restful.control;

import com.google.common.collect.Maps;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceProcessProvider;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.PdWorkOrder;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * 产品管理--产品生产工序
 */
@Api(value = "产品管理--产品生产工序", description = "产品管理--产品生产工序")
@Path(RestConstants.RestPathPrefix.DPPRODUCEPROCESS)
public class DpProduceProcessRestServer extends BaseRestServerInterfaceImpl<DpProduceProcess> {


    @Override
    public IDpProduceProcessProvider getDubboBaseInterface() {
        return ControlConsumer.getDpProduceProcessProvider();
    }

    /**
     * 生产工序配置
     *
     * @param process
     * @return
     */
    @POST
    @Path("updateConfig")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "生产工序配置", notes = "生产工序配置", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject updateConfig(@ApiParam(value = "产品生产工序", required = true, defaultValue = "") DpProduceProcess process) {
        try {
            boolean ret = this.getDubboBaseInterface().updateConfig(process);
            this.addOperationLog("生产工序配置成功", "", true);
            jsonView.successPack(ret, "生产工序配置成功");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("生产工序配置失败", "", false);
            log.error("DpProcessBaseConfigRestServer baseConfig is error", e);
        }
        return jsonView;
    }

    /**
     * 添加生产工序
     *
     * @param process
     * @return
     */
    @POST
    @Path("saveProduceProcess")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "添加生产工序", notes = "添加生产工序", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveProduceProcess(@ApiParam(value = "生产工序", required = true, defaultValue = "", example = "") DpProduceProcess process) {
        try {
            String id = this.getDubboBaseInterface().saveProduceProcess(process);
            this.addOperationLog("添加生产工序成功！", "", true);
            jsonView.successPack(id, "添加生产工序成功！");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("添加生产工序失败！", "", false);
            log.error("DpProjectRestServer saveProduceProcess is error", e);
        }
        return jsonView;
    }

    /**
     * 根据产品id查询生产工序id及工序名称列表
     *
     * @param pdId
     * @param isAuto
     * @return
     */
    @GET
    @Path("getProduceProcesses")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品id查询生产工序id及工序名称列表", notes = "根据产品id查询生产工序id及工序名称列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getProduceProcesses(@ApiParam(value = "产品id", required = true, defaultValue = "", example = "1") @QueryParam("pdId") String pdId,
                                              @ApiParam(value = "是否为人工工序（1为是，0为否）", required = true, defaultValue = "", example = "1") @QueryParam("isAuto") String isAuto) {
        try {
            List<Map<String, Object>> produceProcesses = this.getDubboBaseInterface().getProduceProcesses(pdId, isAuto);
            this.addOperationLog("根据产品id查询生产工序id及工序名称列表成功！", "", true);
            jsonView.successPack(produceProcesses);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据产品id查询生产工序id及工序名称列表失败！", "", false);
            log.error("DpProjectRestServer getProduceProcesses is error", e);
        }
        return jsonView;
    }

    /**
     * 生产工序排序
     *
     * @param maxSortId 排序靠前的工序ID
     * @param minSortId 排序靠后的工序ID
     * @return
     */
    @GET
    @Path("updateSort")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "生产工序排序", notes = "生产工序排序", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject updateSort(@ApiParam(value = "排序在前的工序ID", required = true, defaultValue = "", example = " ") @QueryParam("maxSortId") String maxSortId, @ApiParam(value = "排序在后的工序ID", required = true, defaultValue = "", example = " ") @QueryParam("minSortId") String minSortId) {
        try {
            boolean flag = this.getDubboBaseInterface().updateSort(maxSortId, minSortId);
            if (flag) {
                this.addOperationLog("生产工序排序！", "", true);
                jsonView.successPack(false, "生产工序排序成功");
            } else {
                this.addOperationLog("生产工序排序！", "", false);
                jsonView.failPack(false, "生产工序排序失败");
            }

        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("生产工序排序失败！", "", false);
            log.error("DpProjectRestServer updateSort is error", e);
        }
        return jsonView;
    }


    /**
     * 批量新增生产工序
     *
     * @param process
     * @return
     */
    @POST
    @Path("saveDpProduceProcess")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "批量新增生产工序", notes = "批量新增生产工序", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveDpProduceProcess(@ApiParam(value = "产品生产工序", required = true, defaultValue = "") DpProduceProcess process) {
        try {
            boolean ret = this.getDubboBaseInterface().saveDpProduceProcess(process);
            this.addOperationLog("批量新增生产工序成功", "", true);
            jsonView.successPack(ret, "批量新增生产工序成功");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("批量新增生产工序失败", "", false);
            log.error("DpProcessBaseConfigRestServer saveDpProduceProcess is error", e);
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
            Object o = request.getSession().getAttribute("station");
            if (null != o) {
                Map<String, Object> session = (Map<String, Object>) o;
                PdWorkOrder workOrder = (PdWorkOrder) session.get("workOrder");
                Map<String, Object> query = Maps.newHashMap();
                query.put("projectId", workOrder.getProjectId());
                List<DpProduceProcess> produceProcessList = this.getDubboBaseInterface().findByMap(query);
                jsonView.successPack(produceProcessList, "获取工序成功!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据当前用户信息获取当前工单对应的所有工序", "", false);
            log.error("DpProcessBaseConfigRestServer getProduceProcess is error", e);
        }
        return jsonView;
    }
}
