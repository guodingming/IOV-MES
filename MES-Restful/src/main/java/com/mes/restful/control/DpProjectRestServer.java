package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProjectProvider;
import com.mes.entity.control.DpProject;
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
 * 开发平台--开发工程
 */
@Api(value = "开发平台--开发工程", description = "开发平台--开发工程")
@Path(RestConstants.RestPathPrefix.DPPROJECT)
public class DpProjectRestServer extends BaseRestServerInterfaceImpl<DpProject> {
    @Override
    public IDpProjectProvider getDubboBaseInterface() {
        return ControlConsumer.getDpProjectProvider();
    }

    /**
     * 修改工程是否启用
     * 
     * @param ids
     * @param enable
     * @return
     */
    @GET
    @Path("updateEnable")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "修改工程是否启用", notes = "修改工程是否启用", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject updateEnable(@ApiParam(value = "工程id，逗号分隔", required = true, defaultValue = "", example = "1,2") @QueryParam("ids") String ids,
                                       @ApiParam(value = "启用（1）或停用（0）", required = true, defaultValue = "", example = "1") @QueryParam("enable") int enable) {
        try {
            boolean ret = this.getDubboBaseInterface().updateEnable(ids, enable);
            this.addOperationLog("修改工程是否启用成功！", "", true);
            jsonView.successPack(ret, "修改工程是否启用成功！");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("修改工程是否启用失败！", "", false);
            log.error("DpProjectRestServer updateEnable is error", e);
        }
        return jsonView;
    }

    /**
     * 修改工程是否发布
     *
     * @param ids
     * @param release
     * @return
     */
    @GET
    @Path("updateRelease")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "修改工程是否发布", notes = "修改工程是否发布", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject updateRelease(@ApiParam(value = "工程id，逗号分隔", required = true, defaultValue = "", example = "1,2") @QueryParam("ids") String ids,
                                        @ApiParam(value = "发布（1）或取消发布（0）", required = true, defaultValue = "", example = "1") @QueryParam("release") int release) {
        try {
            boolean ret = this.getDubboBaseInterface().updateRelease(ids, release);
            this.addOperationLog("修改工程是否发布成功！", "", true);
            jsonView.successPack(ret, "修改工程是否发布成功！");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("修改工程是否发布失败！", "", false);
            log.error("DpProjectRestServer updateRelease is error", e);
        }
        return jsonView;
    }
    

}
