package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdSchedulingProvider;
import com.mes.entity.control.PdScheduling;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * 产品管理-排班-人员
*/
@Api(value = "产品管理-排班-人员", description = "产品管理-排班-人员")
@Path(RestConstants.RestPathPrefix.PDSCHEDULING)
public class PdSchedulingRestServer extends BaseRestServerInterfaceImpl<PdScheduling> {
	@Override
	public IPdSchedulingProvider getDubboBaseInterface() {
		return ControlConsumer.getPdSchedulingProvider();
	}


	@POST
	@Path("saveScheduling")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "新增排班信息",notes = "新增排班信息",response = JsonViewObject.class,produces = MediaType.APPLICATION_JSON)
	public JsonViewObject saveScheduling(@ApiParam(value = "")PdScheduling pdScheduling){
		try{
			this.getDubboBaseInterface().saveScheduling(pdScheduling);
			addOperationLog("新增排班信息","",true);
			jsonView.successPack("新增成功");
		}catch (Exception e){
			jsonView.failPack(e);
			addOperationLog("","",false);
			log.error("pdSchedulingRestServer saveScheduling is error",e);
		}
		return jsonView;
	}

	@GET
	@Path("deleteScheduling")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "根据多个id删除记录班次主表和明细表信息", notes = "根据多个id删除记录班次主表和明细表信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject deleteScheduling(@ApiParam(value = "多个记录id，用逗号分隔", required = true, defaultValue = "", example = "1,2") @QueryParam("ids") String ids){
		try{
			this.getDubboBaseInterface().deleteScheduling(ids);
			this.addOperationLog("根据多个id删除记录班次主表和明细表信息成功","",true);
			jsonView.successPack("true","删除数据成功");
		}catch (Exception e){
			jsonView.failPack("false","删除数据失败");
			this.addOperationLog("根据多个id删除记录班次主表和明细表信息成功","",false);
			log.error("pdSchedulingRestServer deleteScheduling is error",e);
		}
		return jsonView;
	}


	@POST
	@Path("getSchedulingPage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据条件分页查询记录", notes = "根据条件分页查询记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject getSchedulingPage(@ApiParam(value = "查询条件和分页参数", required = true, defaultValue = "", example = "{\"pageSize\": 10, \"pageNum\": 1}") Page page){
		try{
			Page pageResult = this.getDubboBaseInterface().getSchedulingPage(page);
			this.addOperationLog("分页查询成功","",true);
			jsonView.successPack((JSON) JSON.toJSON(pageResult));
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("分页查询失败", "", false);
			log.error("PdSchedulingRestServer getSchedulingPage is error :", e);
		}
		return jsonView;
	}


}
