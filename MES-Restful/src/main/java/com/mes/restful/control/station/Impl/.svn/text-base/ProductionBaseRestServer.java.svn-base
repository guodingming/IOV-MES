package com.mes.restful.control.station.Impl;

import com.google.common.collect.Lists;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProductInfoLogProvider;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.dubbo.interprovider.control.IPdProductInfoProvider;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.PdProductInfo;
import com.mes.entity.control.PdWorkOrder;
import com.mes.entity.control.User;
import com.mes.restful.control.station.StationBaseRestServer;
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
 * Created by bo.zhou1 on 2017/9/13.
 */
@Api(value = "工作站-三防检验", description = "工作站-三防检验")
@Path(RestConstants.RestPathPrefix.STATION + "/production")
public class ProductionBaseRestServer extends StationBaseRestServer {

    private IDpRoutesProvider dpRoutesProvider = ControlConsumer.getDpRoutesProvider();

    private IPdProductInfoProvider pdProductInfoProvider = ControlConsumer.getPdProductInfoProvider();

    private IDpProductInfoLogProvider dpProductInfoLogProvider = ControlConsumer.getDpProductInfoLogProvider();

    /**
     * 根据产品条获取连板产品信息
     *
     * @param number 产品条码
     * @return
     */
    @GET
    @Path("/operation")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品条码获取连板产品信息", notes = "根据产品条码获取连板产品信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getProduceInfoByNumber(@ApiParam(value = "产品条码") @QueryParam("number") String number) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                if (StringUtils.isNotBlank(number)) {
                    User user = super.getSessionUser();
                    DpProduceProcess produceProcess = super.getSessionProduceProcess();
                    PdWorkOrder workOrder = super.getSessionWorkOrder();
                    List<PdProductInfo> productInfoList = this.pdProductInfoProvider.getProduceInfoByNumber(number, workOrder);
                    if (productInfoList.isEmpty()) {
                        jsonView.failPack(Lists.newArrayList(), "三防检验获取数据失败,服务器异常");
                    } else {
                        //传入条码对应连板上是否有当前工序任务
                        boolean isAllInThisProcess = false;
                        for (PdProductInfo pdProductInfo : productInfoList) {
                            //校验产品任务是否在当前工序
                            boolean processValidate = this.dpRoutesProvider.checkProductProcess(pdProductInfo.getId(), produceProcess.getId());
                            if (processValidate) {
                                isAllInThisProcess = true;
                                //完成当前工序
                                dpRoutesProvider.completeTask(pdProductInfo.getId(), user.getId(), produceProcess.getId(), "1");
                            }
                        }
                        if (isAllInThisProcess) {
                            jsonView.successPack(Lists.newArrayList(), "三防检验过站成功");
                        } else {
                            jsonView.failPack(Lists.newArrayList(), "三防检验过站失败,产品不在当前工序");
                        }
                    }
                } else {
                    jsonView.failPack(Lists.newArrayList(), "三防检验获取数据失败,请传入产品条码");
                }
            } else {
                jsonView.failPack(Lists.newArrayList(), "三防检验获取数据失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "三防检验获取数据失败,服务器异常");
            this.addOperationLog("根据产品条码获取连板产品信息", "根据产品条码获取连板产品信息失败", false);
            log.error("PdProductInfoRestServer getProduceInfoByNumber is error", e);
        }
        return jsonView;
    }

    /**
     * 根据产品条码获取三防检验过站记录
     *
     * @param number
     * @return
     */
    @GET
    @Path("/getProductInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品条码获取三防检验过站记录", notes = "根据产品条码获取三防检验过站记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getProduceInfoLogByNumber(@ApiParam(value = "产品条码") @QueryParam("number") String number) {
        try {
            Map<String, Object> session = super.getRequestSession();
            if (null != session) {
                if (StringUtils.isNotBlank(number)) {
                    PdWorkOrder workOrder = super.getSessionWorkOrder();
                    List<PdProductInfo> productInfoList = this.pdProductInfoProvider.getProduceInfoByNumber(number, workOrder);
                    if (productInfoList.isEmpty()) {
                        jsonView.failPack(Lists.newArrayList(), "根据条码获取三防检验连板产品信息失败,服务器异常");
                    } else {
                        jsonView.successPack(productInfoList, "根据条码获取三防检验连板产品信息成功");
                    }
                } else {
                    jsonView.failPack(Lists.newArrayList(), "根据条码获取三防检验连板产品信息失败,请传入产品条码");
                }
            } else {
                jsonView.failPack(Lists.newArrayList(), "根据条码获取三防检验连板产品信息失败,请重新登录");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(Lists.newArrayList(), "");
            this.addOperationLog("", "", false);
            log.error("根据条码获取三防检验连板产品信息失败");
        }
        return jsonView;
    }
}
