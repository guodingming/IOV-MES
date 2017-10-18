package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.dubbo.interprovider.control.IDpLabelProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.DpLabel;
import com.mes.utils.DownLoadUntil;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * 开发平台-标签管理
 */
@Api(value = "开发平台-标签管理", description = "开发平台-标签管理")
@Path(RestConstants.RestPathPrefix.DPLABEL)
public class DpLabelRestServer extends BaseRestServerInterfaceImpl<DpLabel> {

    private IDpDataDictionaryProvider dpDataDictionaryProvider = ControlConsumer.getDpDataDictionaryProvider();
    @Override
    public IDpLabelProvider getDubboBaseInterface() {
        return ControlConsumer.getDpLabelProvider();
    }

    @POST
    @Path("uploadTemplate")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "上传标签模板文件", notes = "上传标签模板文件", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject uploadTemplate(
            @ApiParam(value = "文件名", defaultValue = "") @FormDataParam("fileName") String fileName,
            @FormDataParam("file") FormDataContentDisposition disposition,
            @ApiParam(value = "标签模板文件") @FormDataParam("file") InputStream is) {
        try {
            String filePath = null;
            if (disposition != null && is != null) {
                fileName = URLDecoder.decode(fileName, "UTF-8");
                String realName = IDGenerator.getID() + "-" + fileName;
                filePath = "/mes-label-files/" + realName;
                String path = ConfigHelper.getValue("shared.fs.dir") + filePath;
                FileUtils.write(path, is);
            }
            this.addOperationLog("上传标签模板文件成功", "", true);
            jsonView.successPack(filePath);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("上传标签模板文件失败", "", false);
            log.error("DpLabelRestServer uploadTemplate is error", e);
        }
        return jsonView;
    }

    @POST
    @Path("uploadInstruction")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "上传说明文档", notes = "上传说明文档", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject uploadInstruction(
            @ApiParam(value = "文件名", defaultValue = "") @FormDataParam("fileName") String fileName,
            @FormDataParam("file") FormDataContentDisposition disposition,
            @ApiParam(value = "说明文档") @FormDataParam("file") InputStream is) {
        try {
            String filePath = null;
            if (disposition != null && is != null) {
                fileName = URLDecoder.decode(fileName, "UTF-8");
                String realName = IDGenerator.getID() + "-" + fileName;
                filePath = "/mes-label-files/" + realName;
                String path = ConfigHelper.getValue("shared.fs.dir") + filePath;
                FileUtils.write(path, is);
            }
            this.addOperationLog("上传说明文档成功", "", true);
            jsonView.successPack(filePath);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("上传说明文档失败", "", false);
            log.error("DpLabelRestServer uploadInstruction is error", e);
        }
        return jsonView;
    }

    /**
     * 根据标签分类Id查询标签
     *
     * @param typeId
     * @return
     */
    @GET
    @Path("/findByTypeId")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据标签分类Id查询", notes = "根据标签分类Id查询", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByTypeId(@ApiParam(value = "标签分类Id") @QueryParam("typeId") String typeId) {
        List<DpLabel> labels = null;
        try {
            labels = this.getDubboBaseInterface().findByTypeId(typeId);
            this.addOperationLog("分类数据数据查询成功", "", true);
            jsonView.successPack(labels);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("分类数据数据查询失败", "", false);
            log.error("DpLabelRestServer findByTypeId is error", e);
        }
        return jsonView;
    }


    /**
     * 标签模板下载
     *
     * @param id
     * @return ledengyun--2017/09/22
     */
    @GET
    @Path("/downLoad")
    @ApiOperation(value = "标签模板下载", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public Response downLoad(@ApiParam(value = "Id") @QueryParam("id") String id) {
        Response response = null;
        String path = null;
        try {
            DpLabel dpLabel = this.getDubboBaseInterface().findById(id);
            path = ConfigHelper.getValue("shared.fs.dir") + dpLabel.getTemplatePath();
        } catch (DubboProviderException e) {
            e.printStackTrace();
        }
        File file = new File(path);
        String filename = file.getName();
        try {
            StreamingOutput stream = DownLoadUntil.LoadFileByPath(path);
            response = Response.ok(stream).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM + ";charset=UTF-8")
                    .header("Content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8")).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 标签说明文档下载
     *
     * @param id
     * @return ledengyun--2017/09/22
     */
    @GET
    @Path("/downLoadFile")
    @ApiOperation(value = "标签说明文档下载", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public Response downLoadFile(@ApiParam(value = "Id") @QueryParam("id") String id) {
        Response response = null;
        String path = null;
        try {
            DpLabel dpLabel = this.getDubboBaseInterface().findById(id);
            path = ConfigHelper.getValue("shared.fs.dir") + dpLabel.getInstructionPath();
        } catch (DubboProviderException e) {
            e.printStackTrace();
        }
        File file = new File(path);
        String filename = file.getName();
        try {
            StreamingOutput stream = DownLoadUntil.LoadFileByPath(path);
            response = Response.ok(stream).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM + ";charset=UTF-8")
                    .header("Content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8")).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return response;
    }


    /**
     * 获取产品标签分类字典
     *
     * @return
     */
    @GET
    @Path("/getLabelTypes")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取产品标签分类字典", notes = "获取产品标签分类字典", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getLabelTypes() {
        try {
            String typeKey = ConfigHelper.getValue("label.dic.type");
            if (StringUtils.isNotBlank(typeKey)) {
                List<DpDataDictionary> dpDataDictionaryList = this.dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
                jsonView.successPack(dpDataDictionaryList, "获取产品标签分类字典成功");
            } else {
                jsonView.failPack("获取产品标签分类字典失败,请确认字典项配置");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(false, "获取产品标签分类字典失败");
            log.error("获取产品标签分类字典");
        }
        return jsonView;
    }
}
