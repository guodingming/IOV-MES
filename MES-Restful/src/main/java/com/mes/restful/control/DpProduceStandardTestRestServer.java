package com.mes.restful.control;

import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.ExcelHandler;
import com.mes.common.utils.FileUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceStandardTestProvider;
import com.mes.entity.control.DpProduceStandardTest;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品测试标准
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "开发平台-产品测试标准", description = "开发平台-产品测试标准"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dpproducestandardtest", description = "开发平台-产品测试标准")})}*/)
@Path(RestConstants.RestPathPrefix.DPPRODUCESTANDARDTEST)
public class DpProduceStandardTestRestServer extends BaseRestServerInterfaceImpl<DpProduceStandardTest> {
    @Override
    public IDpProduceStandardTestProvider getDubboBaseInterface() {
        return ControlConsumer.getDpProduceStandardTestProvider();
    }

    /**
     * 导入测试标准，文件为xls
     *
     * @param disposition
     * @param is
     * @return
     */
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "导入测试标准，文件为xls", notes = "导入测试标准，文件为xls", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject upload(@ApiParam(value = "文件名", defaultValue = "") @FormDataParam("fileName") String fileName,
                                   @FormDataParam("file") FormDataContentDisposition disposition,
                                   @ApiParam("file") @FormDataParam("file") InputStream is,
                                   @ApiParam(value = "生产工序id") @FormDataParam("produceProcessId") String produceProcessId) {
        try {
            String filePath = null;
            String path = "";
            if (disposition != null && is != null) {
                try {
                    fileName = URLDecoder.decode(fileName, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                path = "/product-test-standards/" + produceProcessId + "/" + fileName;
                filePath = ConfigHelper.getValue("shared.fs.dir") + path;
                boolean ret = FileUtils.write(filePath, is);
                if (!ret) {
                    jsonView.failPack("文件上传失败，请重试！");
                    return jsonView;
                }
            }
            boolean ret = this.getDubboBaseInterface().saveImport(path, produceProcessId);

            this.addOperationLog("导入测试标准成功", "", true);
            jsonView.successPack(ret);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("导入测试标准失败", "", false);
            log.error("DpProduceStandardTestRestServer upload is error", e);
        }

        return jsonView;
    }

    /**
     * 导出测试标准，文件为xls
     *
     * @param produceProcessId
     * @return
     */
    @GET
    @Path("download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @ApiOperation(value = "导出测试标准，文件为xls", notes = "导出测试标准，文件为xls", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public Response download(@ApiParam(value = "生产工序id") @QueryParam("produceProcessId") String produceProcessId) {
        try {
            List<Map<String, Object>> rows = this.getDubboBaseInterface().getDownload(produceProcessId);
            this.addOperationLog("导出测试标准成功", "", true);

            return Response.ok(ExcelHandler.write(rows, "测试标准")).header("Content-Disposition", "attachment;filename=" + produceProcessId + ".xlsx").build();
        } catch (Exception e) {
            this.addOperationLog("导出测试标准失败", "", false);
            log.error("DpProduceStandardTestRestServer download is error", e);

            return Response.serverError().entity(e).build();
        }
    }
}
