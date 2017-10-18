package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.FileUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBomProduceProvider;
import com.mes.entity.control.FtyDeviceConfigInfo;
import com.mes.entity.control.PdBomProduce;
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
import java.util.Map;

/**
 * 产品管理-生产BOM管理
 */
@Api(value = "产品管理-生产BOM管理", description = "产品管理-生产BOM管理")
@Path(RestConstants.RestPathPrefix.PDBOMPRODUCE)
public class PdBomProduceRestServer extends BaseRestServerInterfaceImpl<PdBomProduce> {
    @Override
    public IPdBomProduceProvider getDubboBaseInterface() {
        return ControlConsumer.getPdBomProduceProvider();
    }

    /**
     * 上传BOM
     *
     * @param productId
     * @param version
     * @param code
     * @param disposition
     * @param is
     * @return
     */
    @POST
    @Path("uploadBom")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "上传BOM", notes = "上传BOM", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject uploadBom(@ApiParam(value = "产品id", required = true, defaultValue = "", example = "1") @FormDataParam("productId") String productId,
                                    @ApiParam(value = "版本", required = true, defaultValue = "", example = "2.0") @FormDataParam("version") String version,
                                    @ApiParam(value = "物料编码", required = true, defaultValue = "", example = "A103") @FormDataParam("code") String code,
                                    @ApiParam(value = "解析BOM数据的函数id") @FormDataParam("fnId") String fnId,
                                    @ApiParam(value = "文件名", defaultValue = "") @FormDataParam("fileName") String fileName,
                                    @FormDataParam("file") FormDataContentDisposition disposition,
                                    @ApiParam(value = "BOM文件") @FormDataParam("file") InputStream is) {
        try {
            String filePath = null;
            if (disposition != null && is != null) {
                fileName = URLDecoder.decode(fileName,"UTF-8");
                filePath = "/product-boms/" + productId;
                String path = ConfigHelper.getValue("shared.fs.dir") + filePath + "/" + fileName;
                FileUtils.write(path, is);
            }
            PdBomProduce bomProduce = new PdBomProduce();
            bomProduce.setVersion(version);
            bomProduce.setStatus("1");
            bomProduce.setCode(code);
            bomProduce.setFilePath(filePath + "/" + fileName);
            bomProduce.setPdId(productId);
            bomProduce.setFnId(fnId);
            String id = this.getDubboBaseInterface().save(bomProduce);
            this.addOperationLog("上传BOM成功", "", true);
            jsonView.successPack(id);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("上传BOM失败", "", false);
            log.error("PdBomProduceRestServer uploadBom is error", e);
        }
        return jsonView;
    }

    /**
     * 根据bom id查询bom物料清单树
     *
     * @param bomId
     * @return
     */
    @GET
    @Path("getMaterialTree")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据bom id查询bom物料清单树", notes = "根据bom id查询bom物料清单树", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getMaterialTree(@ApiParam(value = "BOM id", required = true, defaultValue = "", example = "1") @QueryParam("bomId") String bomId) {
        try {
            List<Node> nodes = this.getDubboBaseInterface().getMaterialTree(bomId);
            this.addOperationLog("根据bom id查询bom物料清单树成功", "", true);
            jsonView.successPack(nodes);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据bom id查询bom物料清单树失败", "", false);
            log.error("PdBomProduceRestServer getMaterialTree is error", e);
        }
        return jsonView;
    }

    /**
     * 查询bom下物料不同版本数量相关信息列表
     *
     * @param bomId
     * @param code
     * @return
     */
    @GET
    @Path("getMaterialAmount")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询bom下物料不同版本数量相关信息列表", notes = "查询bom下物料不同版本数量相关信息列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getMaterialAmount(@ApiParam(value = "BOM id", required = true, defaultValue = "", example = "1") @QueryParam("bomId") String bomId,
                                            @ApiParam(value = "物料编码", required = true, defaultValue = "", example = "1") @QueryParam("code") String code) {
        try {
            List<Map<String, Object>> amount = this.getDubboBaseInterface().getMaterialAmount(bomId, code);
            this.addOperationLog("查询bom下物料不同版本数量相关信息列表成功", "", true);
            jsonView.successPack(amount, "查询bom下物料不同版本数量相关信息列表成功");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("查询bom下物料不同版本数量相关信息列表失败", "", false);
            log.error("PdBomProduceRestServer getMaterialAmount is error", e);
        }
        return jsonView;
    }

    /**
     * 生产BOM文件下载
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
            PdBomProduce pdBomProduce = this.getDubboBaseInterface().findById(id);
            path =ConfigHelper.getValue("shared.fs.dir")+ pdBomProduce.getFilePath();
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
