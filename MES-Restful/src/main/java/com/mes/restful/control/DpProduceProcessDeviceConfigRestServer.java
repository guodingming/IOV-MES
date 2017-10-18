package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.rest.MyValidator;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProduceProcessDeviceConfigProvider;
import com.mes.entity.control.DpProduceProcessDeviceConfig;
import com.mes.entity.control.PdBomProduce;
import com.mes.utils.DownLoadUntil;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.ConstraintViolation;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/**
 * 开发平台-设备配置信息
*/
@Api(value = "开发平台-设备配置信息", description = "开发平台-设备配置信息")
@Path(RestConstants.RestPathPrefix.DPPRODUCEPROCESSDEVICECONFIG)
public class DpProduceProcessDeviceConfigRestServer extends BaseRestServerInterfaceImpl<DpProduceProcessDeviceConfig> {
	@Override
	public IDpProduceProcessDeviceConfigProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProduceProcessDeviceConfigProvider();
	}


	@POST
	@Path("/saveCopyConfig")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "新建记录", notes = "新建记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject saveCopyConfig(@ApiParam(value = "记录的JSON格式字符串", required = true) DpProduceProcessDeviceConfig dpProduceProcessDeviceConfig){
		Map<String, Object> result = Maps.newHashMap();
		String jsonStr = JSON.toJSONString(dpProduceProcessDeviceConfig);
		try {
			if (dpProduceProcessDeviceConfig != null) {
				result = this.getDubboBaseInterface().saveCopyConfig(dpProduceProcessDeviceConfig);
				if ("exists".equals(result.get("content"))) {
					jsonView.setMessage("exists");
				} else {
					jsonView.successPack(result.get("content"), result.get("message").toString());
					this.addOperationLog("保存数据", "jsonStr=" + jsonStr, true);
				}
			}
		} catch (Exception e) {
			jsonView.failPack("false", "保存数据失败！" + e.getMessage());
			this.addOperationLog("保存数据", "jsonStr=" + jsonStr, false);
			log.error("BaseRestServerInterfaceImpl save is error,{jsonStr:" + jsonStr + "}," + e.getMessage(), e);
		}
		return jsonView;
	}

	@GET
	@Path("/downLoad")
	@ApiOperation(value = "文件下载", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public Response downLoad(@ApiParam(value = "Id")@QueryParam("id") String id) {
		Response response=null;
		String path = null;
		try {
			DpProduceProcessDeviceConfig dpProduceProcessDeviceConfig = this.getDubboBaseInterface().findById(id);
			path =ConfigHelper.getValue("shared.fs.dir")+ dpProduceProcessDeviceConfig.getFilePath()+dpProduceProcessDeviceConfig.getFileName();
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
