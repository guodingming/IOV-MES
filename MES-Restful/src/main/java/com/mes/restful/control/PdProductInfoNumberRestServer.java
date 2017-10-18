package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.entity.control.PdProductInfoNumber;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 开发平台-产品明细-产品编码
*/
@Api(value = "开发平台-产品明细-产品编码", description = "开发平台-产品明细-产品编码")
@Path(RestConstants.RestPathPrefix.PDPRODUCTINFONUMBER)
public class PdProductInfoNumberRestServer extends BaseRestServerInterfaceImpl<PdProductInfoNumber> {
	@Override
	public IPdProductInfoNumberProvider getDubboBaseInterface() {
		return ControlConsumer.getPdProductInfoNumberProvider();
	}

	@GET
	@Path("/findByNumber")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据产品编码查询", notes = "根据产品编码查询", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject findByNumber(@ApiParam(value = "产品编码")@QueryParam("number")String number){
		PdProductInfoNumber pdProductInfoNumbers =null;
		try {
			pdProductInfoNumbers = this.getDubboBaseInterface().findByNumber(number);
			this.addOperationLog("数据查询成功", "", true);
			jsonView.successPack(pdProductInfoNumbers);
		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("数据数据查询失败", "", false);
			log.error("PdProductInfoNumberRestServer findByNumber is error", e);
		}

return jsonView;
	}


	/**
	 * 根据条码获取产品生产信息
	 * @param number
	 * @return
	 * ledengyun--2107/09/06
	 */
	@GET
	@Path("/getProductInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据产条码获取产品信息", notes = "根据产条码获取产品信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getProductInfo(@ApiParam(value = "条码")@QueryParam("number") String number,@ApiParam(value = "生产工序Id")@QueryParam("produceProcessId")String produceProcessId ){
		List<DpProductInfoLog> pdProductInfo = null;
		try {
			pdProductInfo = this.getDubboBaseInterface().getProductInfo(number,produceProcessId);
			this.addOperationLog("数据查询成功", "", true);
			jsonView.successPack(pdProductInfo);
		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("数据数据查询失败", "", false);
			log.error("PdProductInfoNumberRestServer getProductInfo is error", e);
		}
		return jsonView;
	}
}
