package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpSubassemblyProvider;
import com.mes.entity.control.DpMaterial;
import com.mes.entity.control.DpSubassembly;
import com.mes.utils.DownLoadUntil;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 开发平台-组件管理
*/
@Api(value = "开发平台-组件管理", description = "开发平台-组件管理")
@Path(RestConstants.RestPathPrefix.DPSUBASSEMBLY)
public class DpSubassemblyRestServer extends BaseRestServerInterfaceImpl<DpSubassembly> {
	@Override
	public IDpSubassemblyProvider getDubboBaseInterface() {
		return ControlConsumer.getDpSubassemblyProvider();
	}

	/**
	 * 组件文件上传
	 * @param id
	 * @return
	 * ledengyun--2017/09/22
	 */
	@GET
	@Path("/downLoad")
	@ApiOperation(value = "组件文件下载", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public Response downLoad(@ApiParam(value = "Id")@QueryParam("id") String id) {
		Response response=null;
		String path = null;
		try {
			DpSubassembly dpSubassembly = this.getDubboBaseInterface().findById(id);
			path = ConfigHelper.getValue("shared.fs.dir")+ dpSubassembly.getPath();
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
