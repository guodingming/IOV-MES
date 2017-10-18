package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpServiceLogProvider;
import com.mes.entity.control.DpServiceLog;
import com.mes.entity.control.ServiceMonitorLineData;
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
 * 开发平台-服务日志
 */
@Api(value = "开发平台-服务日志", description = "开发平台-服务日志")
@Path(RestConstants.RestPathPrefix.DPSERVICELOG)
public class DpServiceLogRestServer extends BaseRestServerInterfaceImpl<DpServiceLog> {
    @Override
    public IDpServiceLogProvider getDubboBaseInterface() {
        return ControlConsumer.getDpServiceLogProvider();
    }

    /**
     * 查询服务调用统计结果折线图数据
     *
     * @param serviceId
     * @param year
     * @param month
     * @return
     */
    @GET
    @Path("queryLineData")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询服务调用统计结果折线图数据", notes = "查询服务调用统计结果折线图数据", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject queryLineData(@ApiParam(value = "服务id", required = true, defaultValue = "", example = "1") @QueryParam("serviceId") String serviceId,
                                        @ApiParam(value = "月统计数据所在年份", required = true, defaultValue = "", example = "2017") @QueryParam("year") String year,
                                        @ApiParam(value = "日统计数据所在月份", required = true, defaultValue = "", example = "2017-07") @QueryParam("month") String month) {
        try {
            ServiceMonitorLineData serviceMonitorLineData = this.getDubboBaseInterface().queryLineData(serviceId, year, month);
            jsonView.successPack(serviceMonitorLineData);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("查询服务调用统计结果折线图数据失败", "", false);
            log.error("DpServiceLogRestServer queryLineData is error", e);
        }
        return jsonView;
    }
}
