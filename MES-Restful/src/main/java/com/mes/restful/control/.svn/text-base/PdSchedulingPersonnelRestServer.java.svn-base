package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdSchedulingPersonnelProvider;
import com.mes.entity.control.PdSchedulingPersonnel;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.util.Json;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * 排班管理-班次人员
*/
@Api(value = "排班管理-班次人员", description = "排班管理-班次人员")
@Path(RestConstants.RestPathPrefix.PDSCHEDULINGPERSONNEL)
public class PdSchedulingPersonnelRestServer extends BaseRestServerInterfaceImpl<PdSchedulingPersonnel> {
	@Override
	public IPdSchedulingPersonnelProvider getDubboBaseInterface() {
		return ControlConsumer.getPdSchedulingPersonnelProvider();
	}

	@POST
	@Path("savePersonnels")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "保存userIds", notes = "保存userIds", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON/*,
            authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "general:save", description = "新建操作")})}*/)
	public JsonViewObject savePersonnels(@ApiParam(value = "记录的JSON格式字符串", required = true) PdSchedulingPersonnel pdSchedulingPersonnel){
		try{
			this.getDubboBaseInterface().savePersonnels(pdSchedulingPersonnel);
			this.addOperationLog("保存userIds成功","",true);
			jsonView.successPack("保存userIds成功");
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("保存userIds失败","",false);
			log.error("PdSchedulingPersonnelRestServer savePersonnels is error",e);
		}

		return jsonView;
	}

	@POST
	@Path("getRestUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取未添加的人员",notes = "获取未添加的人员",response = JsonViewObject.class,produces = MediaType.APPLICATION_JSON,consumes = MediaType.APPLICATION_JSON)
	public JsonViewObject getRestUser(@ApiParam(value = "班次Id和groupId",required = true,example = "{\"userGroupId\":\"1\",\"schedulingId\":\"1\"}") Map<String,Object> map){
		try{
			List<PdSchedulingPersonnel>  pdSchedulingPersonnelList = this.getDubboBaseInterface().getRestUser(map);
			this.addOperationLog("获取未添加的人员成功","",true);
			jsonView.successPack(pdSchedulingPersonnelList);
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("获取未添加的人员失败","",false);
			log.error("PdSchedulingPersonnelRestServer getRestUser is error :",e);
		}
		return jsonView;
	}


}
