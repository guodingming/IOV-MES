package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider;
import com.mes.entity.control.FtyDevice;
import com.mes.entity.control.FtyProcess;
import com.mes.entity.control.PdWorkOrder;
import com.mes.entity.control.User;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 产品管理-工单管理
 */
@Api(value = "产品管理-工单管理", description = "产品管理-工单管理")
@Path(RestConstants.RestPathPrefix.PDWORKORDER)
public class PdWorkOrderRestServer extends BaseRestServerInterfaceImpl<PdWorkOrder> {
    @Override
    public IPdWorkOrderProvider getDubboBaseInterface() {
        return ControlConsumer.getPdWorkOrderProvider();
    }

    /**
     * 修改工单状态，启动或停止
     *
     * @param op
     * @param ids
     * @return
     */
    @GET
    @Path("op/{op:start|stop}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "修改工单状态，启动或停止", notes = "修改工单状态，启动或停止", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject updateStatus(@ApiParam(value = "操作类型，只能为start或stop") @PathParam("op") String op, @ApiParam(value = "工单id", required = true, defaultValue = "", example = "1,2") @QueryParam("ids") String ids) {
        try {
            boolean ret = this.getDubboBaseInterface().updateStatus(ids, "start".equals(op) ? PdWorkOrder.PdWorkOrderStatus.STATUS_START : PdWorkOrder.PdWorkOrderStatus.STATUS_STOP);
            if (ret) {
                this.addOperationLog("修改工单状态成功", "", true);
                jsonView.successPack(ret, "修改工单状态成功!");
            } else {
                this.addOperationLog("修改工单状态失败", "", true);
                jsonView.failPack("修改工单状态失败!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("修改工单状态失败", "", false);
            log.error("PdWorkOrderRestServer updateStatus is error", e);
        }
        return jsonView;
    }

    /**
     * 保存生产线信息并启动工单
     *
     * @param id
     * @param productLineId
     * @return
     */
    @GET
    @Path("saveProductLineStart")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "保存生产线信息并启动工单", notes = "保存生产线信息并启动工单", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveProductLineStart(@ApiParam(value = "工单ID") @QueryParam("id") String id, @ApiParam(value = "生产线", required = true) @QueryParam("productLineId") String productLineId, @ApiParam(value = "班次", required = true) @QueryParam("shiftId") String shiftId) {
        try {
            boolean flag = this.getDubboBaseInterface().saveProductLineStart(id, productLineId, shiftId);
            if (flag) {
                this.addOperationLog("启动工单成功", "", true);
                jsonView.successPack(true, "启动工单成功!");
            } else {
                this.addOperationLog("启动工单失败", "", true);
                jsonView.failPack(false, "启动工单失败!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("保存生产线信息并启动工单失败", "", false);
            log.error("PdWorkOrderRestServer saveProductLineStart is error", e);
        }
        return jsonView;
    }

    /**
     * 根据产品id查询工序列表
     *
     * @return
     */
    @GET
    @Path("getProcesses/byPd")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品id查询工序列表", notes = "根据产品id查询工序列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getProcesses(@ApiParam(value = "产品id", required = true, defaultValue = "", example = "1") @QueryParam("pdId") String pdId) {
        try {
            List<FtyProcess> processes = this.getDubboBaseInterface().getProcesses(pdId);
            if (processes != null) {
                this.addOperationLog("根据产品id查询工序列表成功", "", true);
                jsonView.successPack(processes, "根据产品id查询工序列表成功!");
            } else {
                this.addOperationLog("根据产品id查询工序列表失败", "", true);
                jsonView.failPack("根据产品id查询工序列表失败!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据产品id查询工序列表失败", "", false);
            log.error("PdWorkOrderRestServer getProcesses is error", e);
        }
        return jsonView;
    }

    /**
     * 根据工单id查询对应的设备列表
     *
     * @param workOrderId
     * @return
     */
    @GET
    @Path("getDevices/byWorkOrder")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据工单id查询对应的设备列表", notes = "根据工单id查询对应的设备列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getDevices(@ApiParam(value = "工单id", required = true, defaultValue = "", example = "1") @QueryParam("workOrderId") String workOrderId) {
        try {
            List<FtyDevice> devices = this.getDubboBaseInterface().getDevices(workOrderId);
            if (devices != null) {
                this.addOperationLog("根据工单id查询对应的设备列表成功", "", true);
                jsonView.successPack(devices, "根据工单id查询对应的设备列表成功!");
            } else {
                this.addOperationLog("根据工单id查询对应的设备列表失败", "", true);
                jsonView.failPack("根据工单id查询对应的设备列表失败!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据工单id查询对应的设备列表失败", "", false);
            log.error("PdWorkOrderRestServer getDevices is error", e);
        }
        return jsonView;
    }

    /**
     * 根据工单id查询对应的人员列表
     *
     * @param workOrderId
     * @return
     */
    @GET
    @Path("getUsers/byWorkOrder")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据工单id查询对应的人员列表", notes = "根据工单id查询对应的人员列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getUsers(@ApiParam(value = "工单id", required = true, defaultValue = "", example = "1") @QueryParam("workOrderId") String workOrderId) {
        try {
            List<User> users = this.getDubboBaseInterface().getUsers(workOrderId);
            if (users != null) {
                this.addOperationLog("根据工单id查询对应的人员列表成功", "", true);
                jsonView.successPack(users, "根据工单id查询对应的人员列表成功!");
            } else {
                this.addOperationLog("根据工单id查询对应的人员列表失败", "", true);
                jsonView.failPack("根据工单id查询对应的人员列表失败!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据工单id查询对应的人员列表失败", "", false);
            log.error("PdWorkOrderRestServer getUsers is error", e);
        }
        return jsonView;
    }

    /**
     * 删除验证工单是否，是否允许删除
     * @param ids
     * @return
     * lednegyun--2017/10/13
     */
    @GET
    @Path("/deleting")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "根据多个id删除记录", notes = "根据多个id删除记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject deleteByIds(@ApiParam(value = "多个记录id，用逗号分隔", required = true, defaultValue = "", example = "1,2") @QueryParam("ids") String ids){
        boolean flag = true;
        boolean ff = false;
        int count = 0;
        try {
            if (!StringUtils.isBlank(ids)) {
                String[] idArray = ids.split(",");
                for (String id : idArray) {
                    //验证分类下是否有数据，是否可以删除
                    ff = this.getDubboBaseInterface().check(id);
                    if (ff) {
                        flag = this.getDubboBaseInterface().deleteById(id);
                        if (!flag) {
                            continue;
                        } else {
                            count++;
                        }
                    }else {
                        count =0;
                    }
                }
            }
            if (count > 0) {
                jsonView.successPack("true", "删除数据成功!");
                this.addOperationLog("删除数据", "ids=" + ids, false);
            } else {
                jsonView.failPack("false", "删除数据失败，该工单正在生产或者该工单为历史数据");
                this.addOperationLog("删除数据", "ids=" + ids, false);
            }
        } catch (Exception e) {
            jsonView.failPack("false", "删除数据失败!" + e.getMessage());
            this.addOperationLog("删除数据", "id=" + ids, false);
            log.error("PdWorkOrderRestServer deleteByIds is error,{Id:" + ids + "}", e);
        }
        return jsonView;
    }
}
