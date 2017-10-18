package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.FileUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigInfoProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.FtyDeviceConfig;
import com.mes.entity.control.FtyDeviceConfigInfo;
import com.mes.utils.DownLoadUntil;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.validation.constraints.NotNull;
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
 * Created by xiuyou.xu on 2017/7/19.
 */
@Api(value = "工厂管理-设备配置", description = "工厂管理-设备配置")
@Path(RestConstants.RestPathPrefix.FTYDEVICECONFIGINFO)
public class FtyDeviceConfigInfoRestServer extends BaseRestServerInterfaceImpl<FtyDeviceConfigInfo> {
    @Override
    public IFtyDeviceConfigInfoProvider getDubboBaseInterface() {
        return ControlConsumer.getFtyDeviceConfigInfoProvider();
    }

    /**
     * 根据车间查询以设备类别分类的设备列表
     *
     * @param areaId
     * @return
     */
    @GET
    @Path("getDevicesTypedTree")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据车间查询以设备类别分类的设备列表", notes = "根据车间查询以设备类别分类的设备列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getDevicesTypedTree(@ApiParam(value = "车间id", required = true, defaultValue = "", example = "1") @QueryParam("areaId") String areaId) {
        try {
            List<Node> nodes = this.getDubboBaseInterface().getDevicesTypedTree(areaId);
            this.addOperationLog("根据车间查询以设备类别分类的设备列表成功", "", true);
            jsonView.successPack(nodes);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据车间查询以设备类别分类的设备列表失败", "", false);
            log.error("FtyDeviceConfigInfoRestServer getDevicesTypedTree is error", e);
        }
        return jsonView;
    }

    /**
     * 上传设备配置文件
     *
     * @param deviceId
     * @param deviceConfigTypeId
     * @param content
     * @param disposition
     * @param is
     * @return
     */
    @POST
    @Path("uploadConfigInfo")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "上传设备配置文件", notes = "上传设备配置文件", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject uploadConfigInfo(@ApiParam(value = "设备id", required = true, defaultValue = "", example = "1") @FormDataParam("deviceId") String deviceId,
                                           @ApiParam(value = "设备配置类型id", required = true, defaultValue = "", example = "2") @FormDataParam("deviceConfigTypeId") String deviceConfigTypeId,
                                           @ApiParam(value = "设备配置数据类型") @NotNull(message = "设备配置数据类型不可为null") @FormDataParam("type") String type,
                                           @ApiParam(value = "设备配置详情名称") @NotNull(message = "设备配置详情名称不可为null") @FormDataParam("name") String name,
                                           @ApiParam(value = "设备配置内容", defaultValue = "") @FormDataParam("content") String content,
                                           @ApiParam(value = "文件名", defaultValue = "") @FormDataParam("filename") String filename,
                                           @ApiParam(value = "设备配置配置内容的版本") @NotNull(message = "设备配置配置内容的版本不可为null") @FormDataParam("version") String version,
                                           @ApiParam(value = "Excel配置文件转换为XML格式的函数id") @FormDataParam("fnId") String fnId,
                                           @FormDataParam("file") FormDataContentDisposition disposition,
                                           @ApiParam(value = "设备配置文件") @FormDataParam("file") InputStream is) {
        try {
            String filePath = null;
            if (disposition != null && is != null) {
                filename = URLDecoder.decode(filename,"UTF-8");
                filePath = "/device-config-files/" + deviceId + "/" + deviceConfigTypeId;
                boolean ret = FileUtils.write(ConfigHelper.getValue("shared.fs.dir") + filePath + "/" +filename, is);
                if(!ret) {
                    jsonView.failPack("保存设备配置文件失败，请重试！");
                    return jsonView;
                }
            }

            FtyDeviceConfig config = new FtyDeviceConfig();
            config.setDeviceConfigTypeId(deviceConfigTypeId);
            config.setDeviceId(deviceId);

            FtyDeviceConfigInfo info = new FtyDeviceConfigInfo();
            info.setDeviceConfigTypeId(deviceConfigTypeId);
            info.setType(type);
            info.setName(name);
            info.setVersion(version);
            if (filePath!=null) {
                info.setFilename(filename);
                info.setFilePath(filePath);
            }
            info.setFnId(fnId);
            info.setContent(content);

            String id = this.getDubboBaseInterface().saveUploadConfigInfo(config, info);
            this.addOperationLog("设备配置上传成功", "", true);
            jsonView.successPack(id);

//            boolean ret = this.getDubboBaseInterface().saveDeviceConfigInfo(deviceId, deviceConfigTypeId, content, disposition.getFileName(), is);
//            if (ret) {
//                this.addOperationLog("设备配置上传成功", "", true);
//                jsonView.successPack(ret, "设备配置上传成功!");
//            } else {
//                this.addOperationLog("设备配置上传失败", "", true);
//                jsonView.failPack("设备配置上传失败!");
//            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("设备配置上传失败", "", false);
            log.error("FtyDeviceConfigInfoRestServer uploadConfigInfo is error", e);
        }
        return jsonView;
    }

    /**
     * 根据设备id和设备配置类型id分页查询设备配置信息
     *
     * @param deviceId
     * @param deviceConfigTypeId
     * @param page
     * @return
     */
    @POST
    @Path("byPage/configType")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据设备id和设备配置类型id分页查询设备配置信息", notes = "根据设备id和设备配置类型id分页查询设备配置信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getPageByConfigType(@ApiParam(value = "设备id", required = true, defaultValue = "", example = "1") @QueryParam("deviceId") String deviceId,
                                              @ApiParam(value = "设备配置类型id", required = true, defaultValue = "", example = "2") @QueryParam("deviceConfigTypeId") String deviceConfigTypeId,
                                              Page page) {
        try {
            page = this.getDubboBaseInterface().getPageByConfigType(deviceId, deviceConfigTypeId, page);
            this.addOperationLog("根据设备id和设备配置类型id分页查询设备配置信息", "", true);
            jsonView.successPack(page);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据设备id和设备配置类型id分页查询设备配置信息", "", false);
            log.error("FtyDeviceConfigInfoRestServer getPageByConfigType is error", e);
        }
        return jsonView;
    }

    /**
     * 根据设备id和设备配置类型id分页查询设备配置信息
     *
     * @param deviceId
     * @param deviceConfigTypeId
     * @return
     */
    @POST
    @Path("byAll/configType")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据设备id和设备配置类型id查询设备配置信息", notes = "根据设备id和设备配置类型id查询设备配置信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getAllByConfigType(@ApiParam(value = "设备id", required = true, defaultValue = "", example = "1") @QueryParam("deviceId") String deviceId,
                                              @ApiParam(value = "设备配置类型id", required = true, defaultValue = "", example = "2") @QueryParam("deviceConfigTypeId") String deviceConfigTypeId) {
        try {
            List<FtyDeviceConfigInfo> result = this.getDubboBaseInterface().getAllByConfigType(deviceId, deviceConfigTypeId);
            this.addOperationLog("根据设备id和设备配置类型id查询设备配置信息", "", true);
            jsonView.successPack(result, "根据设备id和设备配置类型id查询设备配置信息成功");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据设备id和设备配置类型id查询设备配置信息", "", false);
            log.error("FtyDeviceConfigInfoRestServer getPageByConfigType is error", e);
        }
        return jsonView;
    }

    /**
     * 根据设备id查询设备配置类型列表
     *
     * @param deviceId
     * @return
     */
    @GET
    @Path("getDeviceConfigTypes")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据设备id查询设备配置类型列表", notes = "根据设备id查询设备配置类型列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getDeviceConfigTypes(@ApiParam(value = "设备id", required = true, defaultValue = "", example = "1") @QueryParam("deviceId") String deviceId) {
        try {
            List<DpDataDictionary> types = this.getDubboBaseInterface().getDeviceConfigTypes(deviceId);
            this.addOperationLog("根据设备id查询设备配置类型列表", "", true);
            jsonView.successPack(types);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据设备id查询设备配置类型列表", "", false);
            log.error("FtyDeviceConfigInfoRestServer getDeviceConfigTypes is error", e);
        }
        return jsonView;
    }

    /**
     * 设备配置文件下载
     * @param id
     * @return
     * ledengyun--2017/09/22
     */
    @GET
    @Path("/downLoad")
    @ApiOperation(value = "文件下载", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public Response downLoad(@ApiParam(value = "Id")@QueryParam("id") String id) {
        Response response=null;
        String path = null;
        try {
            FtyDeviceConfigInfo ftyDeviceConfigInfo = this.getDubboBaseInterface().findById(id);
            path =ConfigHelper.getValue("shared.fs.dir")+ ftyDeviceConfigInfo.getFilePath() + "/" + ftyDeviceConfigInfo.getFilename();
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
