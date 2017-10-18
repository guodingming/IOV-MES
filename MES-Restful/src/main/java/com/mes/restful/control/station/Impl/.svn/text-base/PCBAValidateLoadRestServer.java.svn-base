package com.mes.restful.control.station.Impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProductInfoLogProvider;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider;
import com.mes.dubbo.interprovider.control.IPdProductInfoProvider;
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
 * Created by bo.zhou1 on 2017/9/26.
 */
@Api(value = "工作站-PCBA投产", description = "工作站-PCBA投产")
@Path(RestConstants.RestPathPrefix.STATION + "/pcbaload")
public class PCBAValidateLoadRestServer extends StationBaseRestServer {

    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    private IPdProductInfoProvider pdProductInfoProvider = ControlConsumer.getPdProductInfoProvider();

    private IPdProductInfoNumberProvider pdProductInfoNumberProvider = ControlConsumer.getPdProductInfoNumberProvider();

    private IDpProductInfoLogProvider dpProductInfoLogProvider = ControlConsumer.getDpProductInfoLogProvider();

    /**
     * 上料投产
     *
     * @param number
     * @return
     */
    @GET
    @Path("operation")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "工单投产", notes = "投产", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject production(@ApiParam(value = "产品条码", required = true) @QueryParam("number") String number) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                PdWorkOrder workOrder = super.getSessionWorkOrder();
                DpProduceProcess produceProcess = super.getSessionProduceProcess();
                User user = super.getSessionUser();
                // TODO 1.校验是否投产和投产数量 如果投产校验是否在当前工单 需要优化
                jsonView = this.dpRoutesProvider.checkStartWorkFlow(number, workOrder);
                String status = jsonView.getStatus();
                boolean content = (boolean) jsonView.getContent();
                if (status.equals("fail") && content) {
                    //2.启动流程
                    this.dpRoutesProvider.startWorkFlow(number, workOrder.getNum(), workOrder.getPdId(), workOrder.getId());
                }
                if (status.equals("fail") && !content) {
                    return jsonView;
                }
                if (status.equals("success") && !content) {
                    return jsonView;
                }
                List<PdProductInfo> productInfoList = this.pdProductInfoProvider.getProduceInfoByNumber(number, workOrder);
                if (productInfoList != null) {
                    //3.默认良品过站
                    for (PdProductInfo pdProductInfo : productInfoList) {
                        this.completeProcessTask(pdProductInfo.getId(), user, workOrder, produceProcess);
                    }
                    this.addOperationLog("检验投产成功!", "", true);
                    jsonView.successPack(true, "检验投产成功");
                } else {
                    jsonView.failPack(false, "检验投产失败,启动流程失败");
                }
//                boolean isAllInThisProcess = true;
//                for (PdProductInfo pdProductInfo : productInfoList) {
//                    //校验产品任务是否在当前工序
//                    boolean processValidate = this.dpRoutesProvider.checkProductProcess(pdProductInfo.getId(), produceProcess.getId());
//                    if (!processValidate) {
//                        String productStatus = pdProductInfo.getStatus();
//                        //连板中如果有一部分产品任务不在当前工序，但是产品已经完工或者在维修站,连板中的其他产品可以重复过站
//                        if (StringUtils.isNotBlank(productStatus)) {
//                            if (PdProductInfo.Status.STATUS_IS_COMPLETE.equals(productStatus)
//                                    || PdProductInfo.Status.STATUS_ON_REPAIRSTATION.equals(productStatus)) {
//                                isAllInThisProcess = true;
//                            } else {
//                                isAllInThisProcess = false;
//                            }
//                        }
//                    }
//                }
//                if (isAllInThisProcess) {
//                    for (PdProductInfo pdProductInfo : productInfoList) {
//                        dpRoutesProvider.completeTask(pdProductInfo.getId(), user.getId(), produceProcess.getId(), "1");
//                    }
//                    this.addOperationLog("产品重新过站成功!", "", true);
//                    jsonView.successPack(true, "产品重新过站成功");
//                } else {
//                    this.addOperationLog("重复过站失败,有未完成产品不在当前工序!", "重复过站失败,有未完成产品不在当前工序", true);
//                    jsonView.successPack(true, "重复过站失败,有未完成产品不在当前工序");
//                }
            } else {
                jsonView.failPack(false, "投产失败,请重新登录");
            }
        } catch (Exception e) {
            jsonView.failPack(false, "投产失败,服务器异常");
            this.addOperationLog("投产失败!", "", false);
            log.error("PCBAValidateLoadRestServer startWorkFlow is error", e);
        }
        return jsonView;
    }

    /**
     * 产品过站
     *
     * @param pdProductInfoId
     * @param user
     * @param workOrder
     * @param produceProcess
     * @return
     */
    private boolean completeProcessTask(String pdProductInfoId, User user, PdWorkOrder workOrder, DpProduceProcess produceProcess) throws DubboProviderException {
        boolean flag = false;
        boolean completeFlag = this.validateCompleteTask(pdProductInfoId, workOrder, produceProcess);
        if (completeFlag) {
            flag = dpRoutesProvider.completeTask(pdProductInfoId, user.getId(), produceProcess.getId(), "1");
        }
        return flag;
    }

    /**
     * 校验当前产品是否可以过站
     *
     * @param pdProductInfoId
     * @param workOrder
     * @param produceProcess
     * @return
     */
    private boolean validateCompleteTask(String pdProductInfoId, PdWorkOrder workOrder, DpProduceProcess produceProcess) throws DubboProviderException {
        boolean flag = false;
        //产品工序任务是否在当前工序
        boolean processValidate = this.dpRoutesProvider.checkProductProcess(pdProductInfoId, produceProcess.getId());
        //产品工序过站次数校验
        boolean executeTimesValidate = this.processExecuteTimesValidate(pdProductInfoId, produceProcess);
        if (processValidate && executeTimesValidate) {
            flag = true;
        }
        return flag;
    }

    /**
     * 工序过站次数限制校验
     *
     * @param pdProductInfoId
     * @param dpProduceProcess
     * @return
     */
    private boolean processExecuteTimesValidate(String pdProductInfoId, DpProduceProcess dpProduceProcess) throws DubboProviderException {
        boolean flag = true;
        int executeTime = dpProduceProcess.getExecuteTime();
        Map<String, Object> query = Maps.newHashMap();
        query.put("pdProductInfoId", pdProductInfoId);
        query.put("produceProcessId", dpProduceProcess.getId());
        List<DpProductInfoLog> executeLogs = this.dpProductInfoLogProvider.findByMap(query);
        if (!executeLogs.isEmpty() && executeLogs.size() == executeTime) {
            flag = false;
        }
        return flag;
    }

    /**
     * 根据条码查询PCBA信息
     *
     * @param number
     * @return ledengyun--2017/09/07
     */
    @GET
    @Path("/getPCBAInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产条码PCBA信息", notes = "根据产条码PCBA信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getPCBAInfo(@ApiParam(value = "条码") @QueryParam("number") String number) {
        Map<String, Object> map = Maps.newHashMap();
        try {
            map = this.pdProductInfoNumberProvider.getPCBAInfo(number);
            this.addOperationLog("数据查询成功", "", true);
            jsonView.successPack(map, "查询产品PCBA成功");
        } catch (DubboProviderException e) {
            jsonView.failPack(map, "查询产品PCBA失败,服务器异常");
            this.addOperationLog("数据数据查询失败", "", false);
            log.error("PCBAValidateLoadRestServer getProductInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 分页获取每个产品最新的工序记录
     *
     * @param page
     * @return
     */
    @POST
    @Path("/getProductInfo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "分页获取每个产品信息记录", notes = "分页获取每个产品信息记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject getProductInfo(@ApiParam(value = "查询条件和分页参数", required = true, defaultValue = "", example = "{\"pageSize\": 10, \"pageNum\": 1}") Page page) {
        JSON result;
        String jsonStr = JSON.toJSONString(page);
        try {
            Map<String, Object> mapBean = Maps.newHashMap();
            if (page != null) {
                if (page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
                    mapBean = (Map) page.getCondition();
                }
            }
            page = this.pdProductInfoProvider.findByPage(page, mapBean);
            result = (JSON) JSON.toJSON(page);
            jsonView.successPack(result);
            this.addOperationLog("分页查询", jsonStr, true);
        } catch (Exception e) {
            jsonView.failPack("分页获取每个产品最新的工序记录失败");
            this.addOperationLog("分页查询", jsonStr, false);
            log.error("PCBAValidateLoadRestServer getProductInfoLog is error,{jsonStr:" + jsonStr + "}", e);
        }
        return jsonView;
    }
}
