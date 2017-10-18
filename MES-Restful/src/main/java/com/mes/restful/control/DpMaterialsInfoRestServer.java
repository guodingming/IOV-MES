package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.rest.MyValidator;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpMaterialsInfoProvider;
import com.mes.entity.control.DpMaterialsInfo;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.ConstraintViolation;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * 开发平台-上料管理
*/
@Api(value = "开发平台-上料管理", description = "开发平台-上料管理")
@Path(RestConstants.RestPathPrefix.DPMATERIALSINFO)
public class DpMaterialsInfoRestServer extends BaseRestServerInterfaceImpl<DpMaterialsInfo> {
	@Override
	public IDpMaterialsInfoProvider getDubboBaseInterface() {
		return ControlConsumer.getDpMaterialsInfoProvider();
	}

	/**
	 * 批量新建
	 *
	 * @param materialsInfo
	 * @return
	 */
	@POST
	@Path("/saveUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "批量新建", notes = "批量新建", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject saveUpdate(@ApiParam(value = "记录的JSON格式字符串", required = true) DpMaterialsInfo materialsInfo){
		Set<ConstraintViolation<DpMaterialsInfo>> violations = MyValidator.validate(materialsInfo, BeanValidationGroups.CreateGroup.class);
		if (violations != null && !violations.isEmpty()) {
			String msg = MyValidator.buildConstraintViolationMessage(violations);
			jsonView.failPack(msg);
			log.error("failed to validate request entity while creating: class=" + materialsInfo.getCreateDate() + ", " + msg);
			return jsonView;
		}

		boolean result = false;
		String jsonStr = JSON.toJSONString(materialsInfo);
		try {
			if (materialsInfo != null) {
				result = this.getDubboBaseInterface().saveUpdate(materialsInfo);
				if (!result) {
					jsonView.failPack("false", "保存数据失败！");
				} else {
					jsonView.successPack(result);
					this.addOperationLog("保存数据", "jsonStr=" + jsonStr, true);
				}
			}
		} catch (Exception e) {
			jsonView.failPack("false", "保存数据失败！" + e.getMessage());
			this.addOperationLog("保存数据", "jsonStr=" + jsonStr, false);
			log.error("BaseRestServerInterfaceImpl saveUpdate is error,{jsonStr:" + jsonStr + "}," + e.getMessage(), e);
		}
		return jsonView;
	}
}
