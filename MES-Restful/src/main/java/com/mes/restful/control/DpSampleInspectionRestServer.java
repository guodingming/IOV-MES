package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpSampleInspectionProvider;
import com.mes.entity.control.DpSampleInspection;
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
 * 产品管理-抽检管理
 * Created by xiuyou.xu on 2017/09/12.
 */
@Api(value = "产品管理-抽检管理", description = "产品管理-抽检管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpsampleinspection", description = "产品管理-抽检管理")})}*/)
@Path(RestConstants.RestPathPrefix.DPSAMPLEINSPECTION)
public class DpSampleInspectionRestServer extends BaseRestServerInterfaceImpl<DpSampleInspection> {
    @Override
    public IDpSampleInspectionProvider getDubboBaseInterface() {
        return ControlConsumer.getDpSampleInspectionProvider();
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
            if (StringUtils.isNotBlank(id)) {
                DpSampleInspection sampleInspection = new DpSampleInspection();
                sampleInspection.setId(id);
                sampleInspection.setResult("1");
                boolean flag = this.getDubboBaseInterface().update(sampleInspection);
                if (flag) {
                    jsonView.successPack(true, "抽检信息放行成功");
                } else {
                    jsonView.failPack(false, "抽检信息放行失败");
                }
            } else {
                jsonView.failPack(false, "请输入指定参数");
            }
        }catch (DubboProviderException e){
            jsonView.failPack(e);
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
                boolean flag = this.getDubboBaseInterface().update(sampleInspection);
                if (flag) {
                    jsonView.successPack(true, "上报QA成功");
                } else {
                    jsonView.failPack(false, "上报QA失败");
                }
            } else {
                jsonView.failPack(false, "请输入指定参数");
            }
        }catch (DubboProviderException e){
            jsonView.failPack(e);
            this.addOperationLog("上报QA", "上报QA失败", false);
            log.error("DpSampleInspectionRestServer reportQA is error", e);
        }
        return jsonView;
    }
}
