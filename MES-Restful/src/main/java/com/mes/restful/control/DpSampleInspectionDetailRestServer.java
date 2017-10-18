package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpSampleInspectionDetailProvider;
import com.mes.entity.control.DpSampleInspectionDetail;
import com.mes.entity.control.PdWorkOrder;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * 产品管理-抽检管理-抽检详细
 * Created by xiuyou.xu on 2017/09/12.
 */
@Api(value = "产品管理-抽检管理-抽检详细", description = "产品管理-抽检管理-抽检详细"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpsampleinspectiondetail", description = "产品管理-抽检管理-抽检详细")})}*/)
@Path(RestConstants.RestPathPrefix.DPSAMPLEINSPECTIONDETAIL)
public class DpSampleInspectionDetailRestServer extends BaseRestServerInterfaceImpl<DpSampleInspectionDetail> {
    @Override
    public IDpSampleInspectionDetailProvider getDubboBaseInterface() {
        return ControlConsumer.getDpSampleInspectionDetailProvider();
    }

    /**
     * 获取抽检信息和数据
     *
     * @return
     */
    @GET
    @Path("/getQCInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取抽检信息和数据", notes = "获取抽检信息和数据", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getQCInfo() {
        try {
            Object o = request.getSession().getAttribute("station");
            if (null != o) {
                Map<String, Object> session = (Map<String, Object>) o;
                PdWorkOrder workOrder = (PdWorkOrder) session.get("workOrder");
                if (workOrder != null) {
                    jsonView = this.getDubboBaseInterface().getQCInfo(workOrder);
                } else {
                    jsonView.failPack(false, "请确认登录信息");
                }
            } else {
                jsonView.failPack(false, "请确认登录信息");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("获取抽检信息和数据", "获取抽检信息和数据失败", false);
            log.error("DpSampleInspectionDetailRestServer getQCInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 保存良品抽检信息
     *
     * @param number
     * @return
     */
    @GET
    @Path("/saveQualifiedInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "保存良品抽检信息", notes = "保存良品抽检信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveQualifiedInfo(@ApiParam(value = "产品条码") @QueryParam("number") String number) {
        try {
            Object o = request.getSession().getAttribute("station");
            if (null != o) {
                Map<String, Object> session = (Map<String, Object>) o;
                PdWorkOrder workOrder = (PdWorkOrder) session.get("workOrder");
                if (workOrder != null) {
                    jsonView = this.getDubboBaseInterface().saveQualifiedInfo(workOrder, number);
                } else {
                    jsonView.failPack(false, "请确认登录信息");
                }
            } else {
                jsonView.failPack(false, "请确认登录信息");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("保存良品抽检信息", "保存良品抽检信息失败", false);
            log.error("DpSampleInspectionDetailRestServer saveQualifiedInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 保存不良信息
     *
     * @return
     */
    @POST
    @Path("unqualifiedInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "保存不良信息", notes = "保存不良信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject unqualifiedInfo(@ApiParam(value = "产品条码") DpSampleInspectionDetail sampleInspectionDetail) {
        try {
            if (sampleInspectionDetail != null) {
                sampleInspectionDetail.setStatus("0");
                boolean flag = this.getDubboBaseInterface().update(sampleInspectionDetail);
                if (flag) {
                    jsonView.successPack(flag, "保存良品抽检信息成功");
                } else {
                    jsonView.failPack(flag, "保存良品抽检信息失败");
                }
            } else {
                jsonView.failPack(false, "请传入指定信息");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("保存良品抽检信息", "保存良品抽检信息失败", false);
            log.error("DpSampleInspectionDetailRestServer saveQualifiedInfo is error", e);
        }
        return jsonView;
    }

}
