package com.mes.restful.control;


import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdFileResourcesProvider;
import com.mes.entity.control.PdFileResources;
import com.mes.entity.control.PdMaterialResourceFile;
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
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



/**
 * 资源文件管理
 */
@Api(value = "资源文件管理", description = "资源文件管理")
@Path(RestConstants.RestPathPrefix.PDFILERESOURCES)
public class PdFileResourcesRestServer extends BaseRestServerInterfaceImpl<PdFileResources> {
    @Override
    public IPdFileResourcesProvider getDubboBaseInterface() {
        return ControlConsumer.getPdFileResourcesProvider();
    }

    /**
     * 资源管理文件上传
     */
    @POST
    @Path("uploadPdFileResource")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "资源管理文件上传", notes = "资源管理文件上传", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject uploadPdFileResource(@ApiParam(value = "文件分类Id", required = true, defaultValue = "") @FormDataParam("fileTypeId") String fileTypeId,
                                               @ApiParam(value = "资源文件版本", required = true, defaultValue = "") @FormDataParam("version") String version,
                                               @ApiParam(value = "编码") @FormDataParam("code") String code,
                                               @ApiParam(value = "类型") @FormDataParam("type") String type,
                                               @ApiParam(value = "文件名") @FormDataParam("fileName") String fileName,
                                               @FormDataParam("file") FormDataContentDisposition disposition,
                                               @ApiParam("file") @FormDataParam("file") InputStream is) {
        String filePath = null;
        String filePath1 = null;
        if (disposition != null && is != null) {
            try {
                fileName = URLDecoder.decode(fileName, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");
            String dateString = formatter.format(date);
            filePath = "/pdFileResource/" + dateString + fileName;
            filePath1 = ConfigHelper.getValue("shared.fs.dir") + filePath;
            boolean ret = FileUtils.write(filePath1, is);
            if (!ret) {
                jsonView.failPack("资源管理文件上传失败，请重试！");
                return jsonView;
            }
        }
        try {

            PdFileResources fileResources = new PdFileResources();
            fileResources.setCode(code);
            fileResources.setFileName(fileName);
            fileResources.setFileTypeId(fileTypeId);
            fileResources.setFilePath(filePath);
            fileResources.setType(type);
            fileResources.setOtherFileName(fileName);
            fileResources.setVersion(version);
            String id = this.getDubboBaseInterface().save(fileResources);
            this.addOperationLog("资源管理文件上传成功", "", true);
            jsonView.successPack(id);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("资源管理文件上传失败", "", false);
            log.error("PdFileResourcesRestServer uploadPdFileResource is error", e);
        }

        return jsonView;
    }

    /**
     * 关联资源文件和物料
     *
     * @param pdMaterialResourceFile
     * @return
     */
    @POST
    @Path("saveMaterialResourceFile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "关联资源文件和物料", notes = "关联资源文件和物料", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveMaterialResourceFile(@ApiParam() PdMaterialResourceFile pdMaterialResourceFile) {
        try {
            boolean ret = this.getDubboBaseInterface().saveMaterialResourceFile(pdMaterialResourceFile);
            if (ret) {
                this.addOperationLog("关联资源文件和物料成功", "", true);
                jsonView.successPack(ret, "关联资源文件和物料成功!");
            } else {
                this.addOperationLog("关联资源文件和物料失败", "", true);
                jsonView.failPack("关联资源文件和物料失败!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("关联资源文件和物料失败", "", false);
            log.error("PdFileResourcesRestServer saveMaterialResourceFile is error", e);
        }
        return jsonView;
    }

    /**
     * 根据资源文件id查询已关联的物料列表
     *
     * @param resourceFileId
     * @return
     */
    @GET
    @Path("getResourceFileMaterials")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据资源文件id查询已关联的物料列表", notes = "根据资源文件id查询已关联的物料列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getResourceFileMaterials(@ApiParam() @QueryParam("resourceFileId") String resourceFileId) {
        try {
            List<String> materialIds = this.getDubboBaseInterface().getResourceFileMaterials(resourceFileId);
            this.addOperationLog("根据资源文件id查询已关联的物料列表成功", "", true);
            jsonView.successPack(materialIds, "根据资源文件id查询已关联的物料列表成功!");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据资源文件id查询已关联的物料列表失败", "", false);
            log.error("PdFileResourcesRestServer saveMaterialResourceFile is error", e);
        }
        return jsonView;
    }

    /**
     * 资源文件、工艺文件下载
     * @param id
     * @return
     * ledengyun--2017/09/21
     */
    @GET
    @Path("/downLoad")
    @ApiOperation(value = "文件下载", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public Response downLoad(@ApiParam(value = "Id")@QueryParam("id") String id) {
        //Response response = null;
        Response response=null;
        String path = null;
        try {
            PdFileResources pdFileResources = this.getDubboBaseInterface().findById(id);
            path =ConfigHelper.getValue("shared.fs.dir")+ pdFileResources.getFilePath();
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
        return  response;
    }


}
