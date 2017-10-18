package com.mes.restful.control;

import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.dubbo.interprovider.control.IFtyProcessProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.FtyProcess;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "工厂管理-工序字典", description = "工厂管理-工序字典")
@Path(RestConstants.RestPathPrefix.FTYPROCESS)
public class FtyProcessRestServer extends BaseRestServerInterfaceImpl<FtyProcess> {

	private IDpDataDictionaryProvider dpDataDictionaryProvider = ControlConsumer.getDpDataDictionaryProvider();

	@Override
	public IFtyProcessProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyProcessProvider();
	}

	/**
	 * 获取所有工序配置类型
	 *
	 * @return
	 */
	@GET
	@Path("processConfigType")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取所有工序配置类型", notes = "获取所有工序配置类型", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getProcessConfigType() {
		try {
			String typeKey = ConfigHelper.getValue("process.dic.type");
			if (StringUtils.isNotBlank(typeKey)) {
				List<DpDataDictionary> dpDataDictionaryList = this.dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
				jsonView.successPack(dpDataDictionaryList, "获取所有工序配置类型成功");
			} else {
				jsonView.failPack("获取所有工序配置类型失败,请确认字典项配置");
			}

		} catch (Exception e) {
			jsonView.failPack("获取所有工序配置类型失败");
			this.addOperationLog("获取所有工序配置类型", "", false);
			log.error("DpProcessBaseConfigRestServer getProcessConfigType is error", e);
		}
		return jsonView;
	}

	/**
	 * 获取所有工序擴展屬性
	 *
	 * @return
	 */
	@GET
	@Path("processExtendAttrs")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取所有工序擴展屬性", notes = "获取所有工序擴展屬性", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getProcessExtendAttrs() {
		try {
			String typeKey = ConfigHelper.getValue("processEA.dic.type");
			if (StringUtils.isNotBlank(typeKey)) {
				List<DpDataDictionary> dpDataDictionaryList = this.dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
				jsonView.successPack(dpDataDictionaryList, "获取所有工序擴展屬性成功");
			} else {
				jsonView.failPack("获取所有工序擴展屬性失败,请确认字典项配置");
			}

		} catch (Exception e) {
			jsonView.failPack("获取所有工序擴展屬性失败");
			this.addOperationLog("获取所有工序擴展屬性", "", false);
			log.error("DpProcessBaseConfigRestServer getProcessExtendAttrs is error", e);
		}
		return jsonView;
	}

}
