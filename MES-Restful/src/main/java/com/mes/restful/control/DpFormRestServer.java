package com.mes.restful.control;

import com.fasterxml.jackson.annotation.JsonView;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpFormProvider;
import com.mes.entity.control.DpForm;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 开发平台-表单
*/
@Api(value = "开发平台-表单", description = "开发平台-表单")
@Path(RestConstants.RestPathPrefix.DPFORM)
public class DpFormRestServer extends BaseRestServerInterfaceImpl<DpForm> {
	@Override
	public IDpFormProvider getDubboBaseInterface() {
		return ControlConsumer.getDpFormProvider();
	}

	@GET
	@Path("getFormTypedTree")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据产品Id查询以表单类型分类的表单列表",notes = "根据产品Id查询以表单类型分类的表单列表",response = JsonViewObject.class,produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getFormTypedTree(@ApiParam(value = "",required = true,defaultValue = "",example ="1")@QueryParam("pdId") String pdId){
		try{
			List<Node> nodes = this.getDubboBaseInterface().getFormTypedTree(pdId);
			this.addOperationLog("根据产品Id查询以表单类型分类的表单列表","",true);
			jsonView.successPack(nodes);
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("根据产品Id查询以表单类型分类的表单列表","",false);
			log.error("DpFormRestServer getFormTypedTree is error",e);
		}
		return jsonView;
	}

	/**
	 * 克隆表单
	 * @param dpForm
	 * @return
	 */
	@POST
	@Path("cloneForm")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "克隆表单",notes = "克隆表单",response = JsonViewObject.class,produces = MediaType.APPLICATION_JSON)
	public JsonViewObject cloneForm(DpForm dpForm){
		try{
			boolean flag = this.getDubboBaseInterface().cloneForm(dpForm);
			if (flag) {
				jsonView.successPack(flag, "克隆表单成功!");
			} else {
				jsonView.failPack(flag, "克隆表单失败!");
			}
			this.addOperationLog("克隆表单","",true);
		}catch (Exception e){
			jsonView.failPack(false, "克隆表单失败!");
			this.addOperationLog("克隆表单","",false);
			log.error("DpFormRestServer cloneForm is error",e);
		}
		return jsonView;
	}

}
