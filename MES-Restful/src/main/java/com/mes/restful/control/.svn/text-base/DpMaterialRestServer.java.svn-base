package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.IDGenerator;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpMaterialProvider;
import com.mes.entity.control.DpMaterial;
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

import static org.glassfish.grizzly.http.util.Header.Date;

/**
 * 开发平台-素材管理
*/
@Api(value = "开发平台-素材管理", description = "开发平台-素材管理")
@Path(RestConstants.RestPathPrefix.DPMATERIAL)
public class DpMaterialRestServer extends BaseRestServerInterfaceImpl<DpMaterial> {
	@Override
	public IDpMaterialProvider getDubboBaseInterface() {
		return ControlConsumer.getDpMaterialProvider();
	}

	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "上传素材文件", notes = "上传素材文件", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject upload(
								 @ApiParam(value = "文件名", defaultValue = "") @FormDataParam("fileName") String fileName,
								 @FormDataParam("file") FormDataContentDisposition disposition,
								 @ApiParam(value = "素材文件") @FormDataParam("file") InputStream is) {
		try {
			String filePath = null;
			if (disposition != null && is != null) {
				fileName = URLDecoder.decode(fileName, "UTF-8");
				filePath = "/mes-material-files/" +IDGenerator.getID()+ "/" + fileName;
				String path = ConfigHelper.getValue("shared.fs.dir") + filePath;
				FileUtils.write(path, is);
			}
			this.addOperationLog("上传素材文件成功", "", true);
			jsonView.successPack(filePath);
		} catch (Exception e) {
			jsonView.failPack(e);
			this.addOperationLog("上传素材文件失败", "", false);
			log.error("DpProcessBaseConfigRestServer upload is error", e);
		}
		return jsonView;
	}

	/**
	 * 素材文件下载
	 * @param id
	 * @return
	 * ledengyun--2017/09/22
	 */
	@GET
	@Path("/downLoad")
	@ApiOperation(value = "素材文件下载", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public Response downLoad(@ApiParam(value = "Id")@QueryParam("id") String id) {
		Response response=null;
		String path = null;
		try {
			DpMaterial dpMaterial = this.getDubboBaseInterface().findById(id);
			path =ConfigHelper.getValue("shared.fs.dir")+ dpMaterial.getPath();
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
