package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdSchedulingDeviceProvider;
import com.mes.entity.control.PdSchedulingDevice;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * 产品管理--排班-设备
*/
@Api(value = "产品管理--排班-设备", description = "产品管理--排班-设备")
@Path(RestConstants.RestPathPrefix.PDSCHEDULINGDEVICE)
public class PdSchedulingDeviceRestServer extends BaseRestServerInterfaceImpl<PdSchedulingDevice> {
	@Override
	public IPdSchedulingDeviceProvider getDubboBaseInterface() {
		return ControlConsumer.getPdSchedulingDeviceProvider();
	}

	@POST
	@Path("saveWorkstations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "保存workstationIds", notes = "保存workstationIds", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON/*,
            authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "general:save", description = "新建操作")})}*/)
	public JsonViewObject saveWorkstations(@ApiParam(value = "记录的JSON格式字符串", required = true) PdSchedulingDevice pdSchedulingDevice){
		try{
			this.getDubboBaseInterface().saveWorkstations(pdSchedulingDevice);
			this.addOperationLog("保存workstationIds成功","",true);
			jsonView.successPack("保存workstationIds成功");
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("保存workstationIds失败","",false);
			log.error("PdSchedulingDeviceRestServer saveWorkstations is error",e);
		}
		return jsonView;
	}

	@POST
	@Path("getRestWorkstation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取未添加的workstation",notes = "获取未添加的workstation",response = JsonViewObject.class,produces = MediaType.APPLICATION_JSON,consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject getRestWorkstation(@ApiParam(value = "workCenterId和schedulingId",required = true) Map<String,Object> map){
		try{
			List<PdSchedulingDevice> pdSchedulingDeviceList = this.getDubboBaseInterface().getRestWorkstation(map);
			this.addOperationLog("获取未添加的workstation成功","",true);
			jsonView.successPack(pdSchedulingDeviceList);
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("获取未添加的workstation失败","",false);
			log.error("PdSchedulingDeviceRestServer getRestWorkstation is error :",e);
		}
		return jsonView;
	}

}
