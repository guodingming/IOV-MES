package com.mes.restful.control;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.dubbo.interprovider.control.IPdBomAffiliatedProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.PdBomAffiliated;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
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
import java.util.List;
import java.util.Map;

/**
 * 产品管理-BOM-附属信息
*/
@Api(value = "产品管理-BOM-附属信息", description = "产品管理-BOM-附属信息")
@Path(RestConstants.RestPathPrefix.PDBOMAFFILIATED)
public class PdBomAffiliatedRestServer extends BaseRestServerInterfaceImpl<PdBomAffiliated> {

	private IDpDataDictionaryProvider dpDataDictionaryProvider = ControlConsumer.getDpDataDictionaryProvider();
	@Override
	public IPdBomAffiliatedProvider getDubboBaseInterface() {
		return ControlConsumer.getPdBomAffiliatedProvider();
	}


	/**
	 * 批量保存生产BOM属性
	 *
	 * @param bomAffiliateds
	 * @return
	 */
	@POST
	@Path("saveBomAffiliates")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "保存生产BOM属性", notes = "保存生产BOM属性", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject saveBomAffiliates(@ApiParam(value = "保存生产BOM属性集合", required = true, defaultValue = "", example = "[]") List<PdBomAffiliated> bomAffiliateds) {
		try {
			boolean flag = this.getDubboBaseInterface().saveBomAffiliates(bomAffiliateds);
			if (flag) {
				jsonView.successPack(flag, "保存生产BOM属性成功");
				this.addOperationLog("保存生产BOM属性", "保存生产BOM属性成功", true);
			} else {
				jsonView.failPack(flag, "保存生产BOM属性失败");
				this.addOperationLog("保存生产BOM属性", "保存生产BOM属性成功", true);
			}
		} catch (DubboProviderException e) {
			jsonView.failPack("保存生产BOM属性失败", "保存生产BOM属性失败");
			this.addOperationLog("保存生产BOM属性", "保存生产BOM属性失败", false);
			log.error("PdBomAffiliatedRestServer saveBomAffiliates is error,{:" + "" + "}", e);
		}
		return jsonView;
	}

	/**
	 * 批量更新生产BOM属性
	 *
	 * @param bomAffiliateds
	 * @return
	 */
	@POST
	@Path("updateBomAffiliates")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "更新生产BOM属性", notes = "更新生产BOM属性", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject updateBomAffiliates(@ApiParam(value = "更新生产BOM属性集合", required = true, defaultValue = "", example = "[]") List<PdBomAffiliated> bomAffiliateds) {
		try {
			boolean flag = this.getDubboBaseInterface().updateBomAffiliates(bomAffiliateds);
			if (flag) {
				jsonView.successPack(flag, "更新生产BOM属性成功");
				this.addOperationLog("更新生产BOM属性", "更新生产BOM属性成功", true);
			} else {
				jsonView.failPack(flag, "更新生产BOM属性失败");
				this.addOperationLog("更新生产BOM属性", "更新生产BOM属性成功", true);
			}
		} catch (DubboProviderException e) {
			jsonView.failPack("更新生产BOM属性失败", "更新生产BOM属性失败");
			this.addOperationLog("更新生产BOM属性", "更新生产BOM属性失败", false);
			log.error("PdBomAffiliatedRestServer updateBomAffiliates is error,{:" + "" + "}", e);
		}
		return jsonView;
	}

	/**
	 * 单项配置模板导出
	 *
	 * @param bomProduceId
	 * @return ledengyun--2017/09/26
	 */
	@GET
	@Path("/downLoad")
	@ApiOperation(value = "导出模板", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public Response downLoad(@ApiParam(value = "BOMProduceId") @QueryParam("bomProduceId") String bomProduceId) {
		Response response = null;
		Map<String, Object> queryMap = Maps.newHashMap();
		if (StringUtils.isNotBlank(bomProduceId)) {
			queryMap.put("bomProduceId", bomProduceId);
		}
		File f = new File("./temp/" + IDGenerator.getID() + ".xlsx");
		f.getParentFile().mkdirs();
		String fileName = f.getName();

		try {
			this.getDubboBaseInterface().downLoad(queryMap, f);
		} catch (DubboProviderException e) {
			e.printStackTrace();
		}
		StreamingOutput stream = new StreamingOutput() {
			@Override
			public void write(OutputStream os) throws IOException,
					WebApplicationException {
				FileInputStream is = new FileInputStream(f);
				IOUtils.copy(is, os);
				IOUtils.closeQuietly(is);
				f.delete();
			}
		};
		try {
			response = Response.ok(stream).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM + ";charset=GBK")
					.header("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8")).build();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 单项配置EXCLE数据导入
	 * @param pdId
	 * @param bomProduceId
	 * @param disposition
	 * @param is
	 * @return
	 * ledengyun--2017/09/27
	 */
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Excle数据导入", notes = "Excle数据导入", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject upload(@ApiParam(value = "pdId")@FormDataParam("pdId")String pdId,@ApiParam(value = "bomProduceId")@FormDataParam("bomProduceId")String bomProduceId,
								 @FormDataParam("file") FormDataContentDisposition disposition,
								 @ApiParam(value = "Excle文件") @FormDataParam("file") InputStream is) {
		try {
			String filePath = null;
			if (disposition != null && is != null) {
				String fileName = URLDecoder.decode(disposition.getFileName(), "UTF-8");
				filePath = "/ExcleData-import/";
				String path = ConfigHelper.getValue("shared.fs.dir") + filePath + fileName;
				FileUtils.write(path, is);
				this.getDubboBaseInterface().upload(path,pdId,bomProduceId);
				jsonView.successPack(true, "Excle数据导入成功");
				this.addOperationLog("Excle数据导入成功", "Excle数据导入成功", true);

			}

		} catch (Exception e) {
			jsonView.failPack(e);
			this.addOperationLog("Excle数据导入", "", false);
			log.error("PdBomAffiliatedRestServer upload is error", e);
		}
		return jsonView;
	}

	/**
	 * 获取所有工序配置类型
	 *ledengyun--2017/10/12
	 * @return
	 */
	@GET
	@Path("/getProductSingleConfigAttr")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取所有产品单项配置属性", notes = "获取所有产品单项配置属性", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getProductSingleConfigAttr() {
		try {
			String typeKey = ConfigHelper.getValue("productSingleAttr.dic.type");
			if (StringUtils.isNotBlank(typeKey)) {
				List<DpDataDictionary> dpDataDictionaryList = this.dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
				jsonView.successPack(dpDataDictionaryList, "获取所有产品单项配置属性成功");
			} else {
				jsonView.failPack("获取所有产品单项配置属性失败,请确认字典项配置");
			}

		} catch (Exception e) {
			jsonView.failPack("获取所有产品单项配置属性失败");
			this.addOperationLog("获取所有产品单项配置属性类型", "", false);
			log.error("PdBomAffiliatedRestServer getProductSingleConfigAttr is error", e);
		}
		return jsonView;
	}

}
