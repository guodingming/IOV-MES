package com.mes.restful.control;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.PackageUtil;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpFunctionProvider;
import com.mes.entity.control.DpFunction;
import com.mes.entity.control.DpSubassembly;
import com.mes.entity.control.JavaMethod;
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
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 开发平台-脚本
 */
@Api(value = "开发平台-脚本", description = "开发平台-脚本")
@Path(RestConstants.RestPathPrefix.DPFUNCTION)
public class DpFunctionRestServer extends BaseRestServerInterfaceImpl<DpFunction> {
    @Override
    public IDpFunctionProvider getDubboBaseInterface() {
        return ControlConsumer.getDpFunctionProvider();
    }


    /**
     * java.class文件上传或jar包上传
     */
    @POST
    @Path("uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "java文件或jar包上传", notes = "java文件或jar包上传", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject uploadFile(@ApiParam(value = "函数分类Id", required = true, defaultValue = "") @FormDataParam("functionTypeId") String functionTypeId,
                                     @ApiParam(value = "名称", required = true, defaultValue = "") @FormDataParam("name") String name,
                                     @ApiParam(value = "描述", defaultValue = "") @FormDataParam("description") String description,
                                     @ApiParam(value = "类型", defaultValue = "") @FormDataParam("type") String type,
                                     @ApiParam(value = "clazz", defaultValue = "") @FormDataParam("clazz") String clazz,
                                     @ApiParam(value = "文件名", defaultValue = "") @FormDataParam("filename") String filename,
                                     @FormDataParam("file") FormDataContentDisposition disposition,
                                     @ApiParam("file") @FormDataParam("file") InputStream is) {
        String filePath = null;
        String filePath1 = null;
        String fileName = null;
        boolean flag = false;
        if (disposition != null && is != null) {
            try {
                fileName = URLDecoder.decode(filename, "UTF-8");
                String checksuffxi = fileName.substring(fileName.lastIndexOf("."));
                flag = checksuffxi.equals(".jar");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
            filePath = "/lib/" + fileName;
            filePath1 = ConfigHelper.getValue("shared.fs.dir") + filePath;
            if (flag) {
                boolean ret = FileUtils.write(filePath1, is);
                if (!ret) {
                    jsonView.failPack("jar上传失败，请重试！");
                    return jsonView;
                }

            try {
                DpFunction dpFunction = new DpFunction();
                dpFunction.setName(name);
                dpFunction.setClazz(clazz);
                dpFunction.setType(type);
                dpFunction.setFilePath(filePath);
                dpFunction.setFunctionTypeId(functionTypeId);
                dpFunction.setJarName(fileName);
                dpFunction.setDescription(description);
                String id = this.getDubboBaseInterface().save(dpFunction);
                this.addOperationLog("jar包上传成功", "", true);
                jsonView.successPack(id);
            } catch (DubboProviderException e) {
                jsonView.failPack(e);
                this.addOperationLog("jar包上传失败", "", false);
                log.error("DpFunctionRestServer uploadFile is error", e);
            }
        }else {
            jsonView.failPack("不是jar包，上传失败");
            log.error("DpFunctionRestServer uploadFile is error,不是jar包");
        }

        return jsonView;
    }

    /**
     * 解析上传的jar，获取其中所有的类及其方法列表
     *
     * @param disposition
     * @param is
     * @return
     */
    @POST
    @Path("parseJar")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "解析上传的jar，获取其中所有的类及其方法列表", notes = "解析上传的jar，获取其中所有的类及其方法列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject parseJar(@ApiParam(value = "文件名", defaultValue = "") @FormDataParam("fileName") String fileName,
                                   @FormDataParam("file") FormDataContentDisposition disposition,
                                   @ApiParam("file") @FormDataParam("file") InputStream is) {
        try {
            String filePath = null;
            if (disposition != null && is != null) {
                try {
                    fileName = URLDecoder.decode(fileName, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                filePath = ConfigHelper.getValue("shared.fs.dir") + "/jars/" + fileName;
                boolean ret = FileUtils.write(filePath, is);
                if (!ret) {
                    jsonView.failPack("文件上传失败，请重试！");
                    return jsonView;
                }
            }
            Map<Class, List<Method>> cms = PackageUtil.getMethods(Lists.newArrayList(filePath));
            Map<String, List<JavaMethod>> ret = Maps.newHashMap();
            if (cms != null && !cms.isEmpty()) {
                cms.keySet().forEach(key -> {
                    List<Method> methodList = cms.get(key);
                    List<JavaMethod> methods = Lists.newArrayList();
                    if (methodList != null && !methodList.isEmpty()) {
                        methodList.forEach(method -> {
                            JavaMethod m = new JavaMethod();
                            m.setModifier(Modifier.toString(method.getModifiers()));
                            m.setName(method.getName());
                            m.setParamTypes(Arrays.stream(method.getParameterTypes()).map(type -> {
                                return type.getName();
                            }).collect(Collectors.toList()));
                            m.setReturnType(method.getAnnotatedReturnType().getType().getTypeName());

                            methods.add(m);
                        });
                    }
                    ret.put(key.getName(), methods);
                });
            }

            this.addOperationLog("解析上传的jar，获取其中所有的类及其方法列表成功", "", true);
            jsonView.successPack(ret);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("解析上传的jar，获取其中所有的类及其方法列表失败", "", false);
            log.error("DpFunctionRestServer uploadFile is error", e);
        }

        return jsonView;
    }

    /**
     * java管理Jar包下载
     * @param id
     * @return
     */
    @GET
    @Path("/downLoad")
    @ApiOperation(value = "jar下载", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public Response downLoad(@ApiParam(value = "Id")@QueryParam("id") String id) {
        Response response=null;
        String path = null;
        try {
            DpFunction dpFunction = this.getDubboBaseInterface().findById(id);
            path = ConfigHelper.getValue("shared.fs.dir")+ dpFunction.getFilePath();
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
