package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpRepairStationProvider;
import com.mes.entity.control.DpRepairStation;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 开发平台-产品维修站
 * Created by xiuyou.xu on 2017/08/25.
 */
@Api(value = "开发平台-产品维修站", description = "开发平台-产品维修站"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dprepairstation", description = "开发平台-产品维修站")})}*/)
@Path(RestConstants.RestPathPrefix.DPREPAIRSTATION)
public class DpRepairStationRestServer extends BaseRestServerInterfaceImpl<DpRepairStation> {
    @Override
    public IDpRepairStationProvider getDubboBaseInterface() {
        return ControlConsumer.getDpRepairStationProvider();
    }

    @GET
    @Path("/findByWorkOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取当前工单的不良产品", notes = "获取当前工单的不良产品", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByWorkOrderId(@ApiParam(value = "工单Id") @QueryParam("workOrderId") String workOrderId) {
        //  List list = this.getDubboBaseInterface().findByWorkOrderId(workOrderId);


        return jsonView;
    }

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
                jsonView = this.getDubboBaseInterface().getRepairStationInfoByNumber(number);
            } else {
                jsonView.failPack(false, "请传入指定参数");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
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
                boolean flag = this.getDubboBaseInterface().update(repairStation);
                if (flag) {
                    jsonView.successPack(true, "操作成功");
                } else {
                    jsonView.failPack(false, "操作失败");
                }
            } else {
                jsonView.failPack(false, "请传入指定参数");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("维修站报废产品", "维修站报废产品失败", false);
            log.error("getRepairStationInfoByNumber reject is error", e);
        }
        return jsonView;
    }

    /**
     * 维修站判定良品并转到指定工序
     *
     * @param repairStationId
     * @param produceProcessId
     * @return
     */
    @GET
    @Path("/gotoProcess")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "维修站判定良品并转到指定工序", notes = "维修站判定良品并转到指定工序", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject gotoProcess(@ApiParam(value = "维修站记录ID") @QueryParam("repairStationId") String repairStationId, @ApiParam(value = "生产工序ID") @QueryParam("produceProcessId") String produceProcessId) {
        try {
            if (StringUtils.isNotBlank(repairStationId) &&
                    StringUtils.isNotBlank(produceProcessId)) {
                DpRepairStation repairStation = new DpRepairStation();
                repairStation.setId(repairStationId);
                repairStation.setStatus(DpRepairStation.Status.QUALIFIED);
                boolean flag = this.getDubboBaseInterface().update(repairStation);
                //TODO 完成当前节点任务 并根据传入生产工序ID转到工序
                if (flag) {
                    jsonView.successPack(true, "操作成功");
                } else {
                    jsonView.failPack(false, "操作失败");
                }
            } else {
                jsonView.failPack(false, "请传入指定参数");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack("维修站良品判断跳转工序失败");
            this.addOperationLog("维修站良品判断跳转工序", "维修站良品判断跳转工序失败", false);
            log.error("getRepairStationInfoByNumber gotoProcess is error", e);
        }
        return jsonView;
    }

}
