package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceProcessProvider;
import com.mes.entity.control.FtyDeviceProcess;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Api(value = "工厂管理-工序-设备", description = "工厂管理-工序-设备")
@Path(RestConstants.RestPathPrefix.FTYDEVICEPROCESS)
public class FtyDeviceProcessRestServer extends BaseRestServerInterfaceImpl<FtyDeviceProcess> {
	@Override
	public IFtyDeviceProcessProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceProcessProvider();
	}

/**
 * 根据车间查询以设备类别分类的设备列表
 *
 * @param ftyDeviceProcess
 * @return
 */
	@POST
	@Path("saveFtyDeviceProcessByIds")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据deviceId 、processIds保存数据", notes = "根据deviceId 、processIds保存数据",
			response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject saveFtyDeviceProcessByIds(FtyDeviceProcess ftyDeviceProcess){
		try{
			this.getDubboBaseInterface().saveFtyDeviceProcessByIds(ftyDeviceProcess);
			this.addOperationLog("根据deviceId 、processIds保存数据成功", "", true);
			jsonView.successPack("saveFtyDeviceProcessByIds : 保存数据成功");
		}catch(Exception e){
			jsonView.failPack("saveFtyDeviceProcessByIds error",e.toString());
			this.addOperationLog("根据deviceId 、processIds保存数据失败", "", false);
			log.error("saveFtyDeviceProcessByIds is error",e);
		}
		return jsonView;
	}
}
