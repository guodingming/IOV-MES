package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpFunctionTypeProvider;
import com.mes.entity.control.DpFunctionType;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 开发平台-函数分类
*/
@Api(value = "开发平台-函数分类", description = "开发平台-函数分类")
@Path(RestConstants.RestPathPrefix.DPFUNCTIONTYPE)
public class DpFunctionTypeRestServer extends BaseRestServerInterfaceImpl<DpFunctionType> {
	@Override
	public IDpFunctionTypeProvider getDubboBaseInterface() {
		return ControlConsumer.getDpFunctionTypeProvider();
	}

	/**
	 * 删除分类
	 * @param ids
	 * @return
	 */
	@GET
	@Path("/deleting")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "根据多个id删除记录", notes = "根据多个id删除记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject deleteByIds(@ApiParam(value = "多个记录id，用逗号分隔", required = true, defaultValue = "", example = "1,2") @QueryParam("ids") String ids){
		boolean flag = true;
		int count = 0;
		try {
			if (!StringUtils.isBlank(ids)) {
				String[] idArray = ids.split(",");
				for (String id : idArray) {
					flag = this.getDubboBaseInterface().deleteById(id);
					if (!flag) {
						continue;
					} else {
						count++;
					}
				}
			}
			if (count > 0) {
				jsonView.successPack("true", "删除数据成功!");
				this.addOperationLog("删除数据", "ids=" + ids, false);
			} else {
				jsonView.failPack("false", "删除数据");
				this.addOperationLog("删除数据", "ids=" + ids, false);
			}
		} catch (Exception e) {
			jsonView.failPack("false", "删除数据失败!" + e.getMessage());
			this.addOperationLog("删除数据", "id=" + ids, false);
			log.error("DpFunctionTypeRestServer deleteByIds is error,{Id:" + ids + "}", e);
		}
		return jsonView;

	}
}
