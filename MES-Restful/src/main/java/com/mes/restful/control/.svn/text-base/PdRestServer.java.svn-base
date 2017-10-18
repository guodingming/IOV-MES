package com.mes.restful.control;

import com.google.common.collect.Lists;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProvider;
import com.mes.entity.control.Pd;
import com.mes.entity.control.PdproductionLineInfoList;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 产品管理-产品
*/
@Api(value = "产品管理-产品", description = "产品管理-产品")
@Path(RestConstants.RestPathPrefix.PD)
public class PdRestServer extends BaseRestServerInterfaceImpl<Pd> {
	@Override
	public IPdProvider getDubboBaseInterface() {
		return ControlConsumer.getPdProvider();
	}

	@POST
	@Path("/savePd")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "新建产品", notes = "新建产品", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject savePd(@ApiParam(value = "记录的JSON格式字符串", required = true)PdproductionLineInfoList pdproductionLineInfoList){
		String id = null;

		try {
			id = this.getDubboBaseInterface().savePd(pdproductionLineInfoList);
			jsonView.successPack(id);
			this.addOperationLog("产品新建成功",id,true);

		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("产品新建失败","",false);
			log.error("PdRestServer savePd is error",e);
		}

		return jsonView;

	}

	/**
	 * 根据产品线获取工程树数据
	 *
	 * @param pdLineId
	 * @return
	 */
	@GET
	@Path("/getProjectTree")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据产品线获取工程树数据", notes = "根据产品线获取工程树数据", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject getProjectTree(@ApiParam(value = "产品线ID", required = true) @QueryParam("pdLineId") String pdLineId){
		List<Node> result = Lists.newArrayList();
		try {
			result = this.getDubboBaseInterface().getProjectTree(pdLineId);
			jsonView.successPack(result, "根据产品线获取工程树数据成功");
			this.addOperationLog("根据产品线获取工程树数据成功","",true);
		} catch (DubboProviderException e) {
			jsonView.failPack(result, "根据产品线获取工程树数据成功");
			this.addOperationLog("根据产品线获取工程树数据失败","",false);
			log.error("PdRestServer getProjectTree is error",e);
		}

		return jsonView;

	}

}
