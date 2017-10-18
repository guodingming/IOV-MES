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
@Api(value = "工作站-抽检", description = "工作站-抽检")
@Path(RestConstants.RestPathPrefix.STATION + "/sample")
public class SampleInspectionBaseRestServer extends StationBaseRestServer {

    private IDpSampleInspectionProvider sampleInspectionProvider = ControlConsumer.getDpSampleInspectionProvider();
    private IDpSampleInspectionDetailProvider sampleInspectionDetailProvider = ControlConsumer.getDpSampleInspectionDetailProvider();
    private IPdProvider pdProvider = ControlConsumer.getPdProvider();
    private IPdProductInfoNumberProvider pdProductInfoNumberProvider = ControlConsumer.getPdProductInfoNumberProvider();
    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    /**
     * 保存抽检信息
     *
     * @param num
     * @return
     */
    @GET
    @Path("/saveSampleInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "保存抽检信息", notes = "保存抽检信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveSampleInfo(@ApiParam(value = "产品抽检信息ID") @QueryParam("num") int num) {
        try {
            if (num != 0) {
                PdWorkOrder workOrder = super.getSessionWorkOrder();
                if (workOrder != null) {
                    boolean flag = this.sampleInspectionProvider.saveOrUpdate(num, workOrder);
                    if (flag) {
                        jsonView.successPack(false, "保存抽检信息成功");
                    } else {
                        jsonView.failPack(false, "保存抽检信息,服务器异常");
                    }
                } else {
                    jsonView.failPack(false, "保存抽检信息,请重新登录");
                }
            } else {
                jsonView.failPack(false, "保存抽检信息,服务器异常");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "保存抽检信息,服务器异常");
            this.addOperationLog("保存抽检信息", "保存抽检信息失败", false);
            log.error("DpSampleInspectionRestServer saveSampleInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 获取当前工单抽检信息
     *
     * @return
     */
    @GET
    @Path("/getSampleInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取当前工单抽检信息", notes = "获取当前工单抽检信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getSampleInfo() {
        List<DpSampleInspection> sampleInspectionList = Lists.newArrayList();
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                PdWorkOrder workOrder = super.getSessionWorkOrder();
                Map<String, Object> query = Maps.newHashMap();
                query.put("workOrderId", workOrder.getId());
                sampleInspectionList = this.sampleInspectionProvider.findByMap(query);
                jsonView.successPack(sampleInspectionList, "获取当前工单抽检信息成功");
            } else {
                jsonView.failPack(sampleInspectionList, "获取当前工单抽检信息,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(sampleInspectionList, "获取当前工单抽检信息,服务器异常");
            this.addOperationLog("获取当前工单抽检信息", "获取当前工单抽检信息失败", false);
            log.error("DpSampleInspectionRestServer getSampleInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 抽检信息放行
     *
     * @param id
     * @return
     */
    @GET
    @Path("/passInspection")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "抽检信息放行", notes = "抽检信息放行", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject passInspection(@ApiParam(value = "产品抽检信息ID") @QueryParam("id") String id) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                if (StringUtils.isNotBlank(id)) {
                    DpProduceProcess produceProcess = super.getSessionProduceProcess();
                    User user = super.getSessionUser();
                    PdWorkOrder pdWorkOrder = super.getSessionWorkOrder();
                    DpSampleInspection sampleInspection = this.sampleInspectionProvider.findById(id);
                    if (sampleInspection != null && sampleInspection.getInspectionNum() == sampleInspection.getSampleNum()) {
                        sampleInspection.setResult("1");
                        boolean flag = this.sampleInspectionProvider.update(sampleInspection);
                        //放行成功批量过站
                        if (flag) {
                            boolean resultFlag = this.sampleInspectionProvider.passStation(pdWorkOrder, user.getId(), produceProcess);
                            if (resultFlag) {
                                return jsonView.successPack(true, "抽检放行成功");
                            }
                            return jsonView.failPack(false, "抽检放行失败,产品过站失败");
                        }
                        return jsonView.failPack(false, "抽检放行失败,服务器异常");
                    }
                    return jsonView.failPack(false, "抽检放行失败,抽检数量不足");
                }
                return jsonView.failPack(false, "抽检放行失败,服务器异常");
            }
            return jsonView.failPack(false, "抽检放行失败,请重新登录");
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "抽检放行失败,服务器异常");
            this.addOperationLog("抽检信息放行", "抽检信息放行失败", false);
            log.error("DpSampleInspectionRestServer passInspection is error", e);
        }
        return jsonView;
    }

    /**
     * 上报QA
     *
     * @param id
     * @return
     */
    @GET
    @Path("/reportQA")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "上报QA", notes = "上报QA", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject reportQA(@ApiParam(value = "产品抽检信息ID") @QueryParam("id") String id) {
        try {
            if (StringUtils.isNotBlank(id)) {
                DpSampleInspection sampleInspection = new DpSampleInspection();
                sampleInspection.setId(id);
                sampleInspection.setResult("2");
                boolean flag = this.sampleInspectionProvider.update(sampleInspection);
                if (flag) {
                    jsonView.successPack(true, "上报QA成功");
                } else {
                    jsonView.failPack(false, "上报QA失败,服务器异常");
                }
            } else {
                jsonView.failPack(false, "上报QA失败,服务器异常");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "上报QA失败,服务器异常");
            this.addOperationLog("上报QA", "上报QA失败", false);
            log.error("DpSampleInspectionRestServer reportQA is error", e);
        }
        return jsonView;
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
                    jsonView = this.sampleInspectionDetailProvider.getQCInfo(workOrder);
                } else {
                    jsonView.failPack(Maps.newHashMap(), "查询抽检数据失败,请重新登录信息");
                }
            } else {
                jsonView.failPack(Maps.newHashMap(), "查询抽检数据失败,请重新登录信息");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Maps.newHashMap(), "查询抽检数据失败,服务器异常");
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
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                PdWorkOrder workOrder = super.getSessionWorkOrder();
                DpProduceProcess produceProcess = super.getSessionProduceProcess();
                if (workOrder != null) {
                    PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberProvider.findByNumber(number);
                    boolean processValidate = this.dpRoutesProvider.checkProductProcess(productInfoNumber.getPdProductInfoId(), produceProcess.getId());
                    if (processValidate) {
                        jsonView = this.sampleInspectionDetailProvider.saveQualifiedInfo(workOrder, number);
                    } else {
                        jsonView.failPack(Lists.newArrayList(), "保存检验结果失败,该产品任务未到抽检站");
                    }
                } else {
                    jsonView.failPack(false, "保存检验结果失败, 请重新登录");
                }
            } else {
                jsonView.failPack(false, "保存检验结果失败, 请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "保存检验结果失败, 服务器异常");
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
                jsonView = this.sampleInspectionDetailProvider.updateUnqualified(sampleInspectionDetail);
            } else {
                jsonView.failPack(false, "保存检验结果失败, 服务器异常");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "保存检验结果失败, 服务器异常");
            this.addOperationLog("保存良品抽检信息", "保存良品抽检信息失败", false);
            log.error("DpSampleInspectionDetailRestServer saveQualifiedInfo is error", e);
        }
        return jsonView;
    }
}
