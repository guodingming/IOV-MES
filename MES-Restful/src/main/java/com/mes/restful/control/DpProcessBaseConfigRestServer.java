package com.mes.restful.control;

import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.IDGenerator;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProcessBaseConfigProvider;
import com.mes.entity.control.DpProcessBaseConfig;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.net.URLDecoder;

/**
 * 开发平台-工序基础配置
 */
@Api(value = "开发平台-工序基础配置", description = "开发平台-工序基础配置")
@Path(RestConstants.RestPathPrefix.DPPROCESSBASECONFIG)
public class DpProcessBaseConfigRestServer extends BaseRestServerInterfaceImpl<DpProcessBaseConfig> {
    @Override
    public IDpProcessBaseConfigProvider getDubboBaseInterface() {
        return ControlConsumer.getDpProcessBaseConfigProvider();
    }

    /**
     * 工序基础配置
     *
     * @param process
     * @return
     */
    @POST
    @Path("baseConfig")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "工序基础配置", notes = "工序基础配置", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject baseConfig(@ApiParam(value = "产品生产工序", required = true, defaultValue = "") DpProcessBaseConfig process) {
        try {
            boolean ret = this.getDubboBaseInterface().saveBaseConfig(process);
            this.addOperationLog("工序基础配置成功", "", true);
            jsonView.successPack(ret, "工序基础配置成功");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("工序基础配置失败", "", false);
            log.error("DpProcessBaseConfigRestServer baseConfig is error", e);
        }
        return jsonView;
    }

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "上传工序基础文件类型配置文件", notes = "上传工序基础文件类型配置文件", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject upload(@ApiParam(value = "工序id") @FormDataParam("processId") String processId,
                                 @ApiParam(value = "文件名", defaultValue = "") @FormDataParam("fileName") String fileName,
                                 @FormDataParam("file") FormDataContentDisposition disposition,
                                 @ApiParam(value = "配置文件") @FormDataParam("file") InputStream is) {
        try {
            String filePath = null;
            if (disposition != null && is != null) {
                fileName = URLDecoder.decode(fileName, "UTF-8");
                String realName = IDGenerator.getID() + "-" + fileName;
                filePath = "/process-base-config-files/" + processId + "/" + realName;
                String path = ConfigHelper.getValue("shared.fs.dir") + filePath;
                FileUtils.write(path, is);
            }
            this.addOperationLog("上传配置文件成功", "", true);
            jsonView.successPack(filePath);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("上传配置文件失败", "", false);
            log.error("DpProcessBaseConfigRestServer upload is error", e);
        }
        return jsonView;
    }

}
