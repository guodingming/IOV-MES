package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdOrderProvider;
import com.mes.entity.control.PdOrder;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 产品管理-产品订单管理
*/
@Api(value = "产品管理-产品订单管理", description = "产品管理-产品订单管理")
@Path(RestConstants.RestPathPrefix.PDORDER)
public class PdOrderRestServer extends BaseRestServerInterfaceImpl<PdOrder> {
	@Override
	public IPdOrderProvider getDubboBaseInterface() {
		return ControlConsumer.getPdOrderProvider();
	}

	/**
	 * 根据产品Id分页查询订单列表
	 * @param page
	 * @return
	 */
	@POST
	@Path("findByPdId")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据产品分页查询订单列表", notes = "根据产品分页查询订单列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject findByPdId(Page page){

		try {
			page = this.getDubboBaseInterface().findByPdId(page);
			this.addOperationLog("根据产品分页查询订单列表", "", true);
			jsonView.successPack(page);
		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("根据产品分页查询订单列表", "", false);
			log.error("PdOrderRestServer findByPdId is error", e);
		}

		return jsonView;
	}
	@GET
	@Path("/findById")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "根据Id查询记录", notes = "根据Id查询记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject findById(@ApiParam(value = "工单Id") @QueryParam("id")String id){
		try {
			PdOrder pdOrder = this.getDubboBaseInterface().findById(id);
			this.addOperationLog("根据Id查询记录", "", true);
			jsonView.successPack(pdOrder);
		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("根据Id查询记录", "", false);
			log.error("PdOrderRestServer findById is error", e);
		}
		return jsonView;
	}
}
