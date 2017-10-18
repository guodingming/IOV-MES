package com.mes.restful.control;

import com.google.common.collect.Lists;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpProductInfoLogProvider;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品生产工序记录
*/
@Api(value = "开发平台-产品生产工序记录", description = "开发平台-产品生产工序记录")
@Path(RestConstants.RestPathPrefix.DPPRODUCTINFOLOG)
public class DpProductInfoLogRestServer extends BaseRestServerInterfaceImpl<DpProductInfoLog> {
	@Override
	public IDpProductInfoLogProvider getDubboBaseInterface() {
		return ControlConsumer.getDpProductInfoLogProvider();
	}

	@GET
	@Path("getInt")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取工序完成的产品数量", notes = "获取工序完成的产品数量", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getInt(@QueryParam("produceProcessId") String produceProcessId,@QueryParam("isSuccess")String isSuccess){

		try {
			int a = this.getDubboBaseInterface().getInt( produceProcessId,isSuccess);
			jsonView.successPack(a);
			this.addOperationLog("查询成功！", "", true);
		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("查询成功！", "", false);
			log.error("DpProductInfoLogRestServer getInt is error", e);
		}
		return jsonView;
	}

	/**
	 * 获取当前工单当前产品最新的工序执行结果信息
	 *
	 * @param number 产品条码
	 * @return
	 */
	@GET
	@Path("getProduceProcessInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取当前工单当前产品最新的工序执行结果信息", notes = "获取当前工单当前产品最新的工序执行结果信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getProduceProcessInfo(@ApiParam(value = "产品条码", required = true, defaultValue = "", example = "") @QueryParam("number") String number) {
		List<DpProductInfoLog> productInfoLogList = Lists.newArrayList();
		try {
			productInfoLogList = this.getDubboBaseInterface().getProduceProcessInfo(number);
			jsonView.successPack(productInfoLogList, "获取当前工单当前产品最新的工序执行结果信息");
		}catch (DubboProviderException e){
			jsonView.failPack(e);
			this.addOperationLog("获取当前工单当前产品最新的工序执行结果信息", number, true);
			log.error("DpProductInfoLogRestServer getProduceProcessInfo is error");
		}
		return jsonView;
	}
}
