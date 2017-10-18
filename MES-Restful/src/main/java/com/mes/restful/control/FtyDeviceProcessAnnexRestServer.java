package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceProcessAnnexProvider;
import com.mes.entity.control.FtyDeviceProcessAnnex;
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

@Api(value = "工厂管理-工序-设备-附件", description = "工厂管理-工序-设备-附件")
@Path(RestConstants.RestPathPrefix.FTYDEVICEPROCESSANNEX)
public class FtyDeviceProcessAnnexRestServer extends BaseRestServerInterfaceImpl<FtyDeviceProcessAnnex> {
	@Override
	public IFtyDeviceProcessAnnexProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceProcessAnnexProvider();
	}

	@POST
	@Path("saveFtyDeviceProcessAnnex")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "保存设备-工序-附件及从表", notes = "保存设备-工序-附件及从表",
			response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject saveFtyDeviceProcessAnnex(FtyDeviceProcessAnnex ftyDeviceProcessAnnex){
		boolean flag = false;
		try{
			flag = this.getDubboBaseInterface().saveFtyDeviceProcessAnnex(ftyDeviceProcessAnnex);
			if(flag) {
				this.addOperationLog("保存设备-工序-附件及从表", "", true);
				jsonView.successPack(flag,"saveFtyDeviceProcessAnnex : 保存数据成功");
			}else {
				this.addOperationLog("保存设备-工序-附件及从表", "", true);
				jsonView.failPack(flag,"saveFtyDeviceProcessAnnex : 请勿重复添加附件");
			}
		}catch(Exception e){
			jsonView.failPack("saveFtyDeviceProcessAnnex error",e.toString());
			this.addOperationLog("保存设备-工序-附件及从表", "", false);
			log.error("saveFtyDeviceProcessAnnex is error",e);
		}
		return jsonView;
	}

	@POST
	@Path("updateFtyDeviceProcessAnnex")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "更新设备-工序-附件及从表", notes = "更新设备-工序-附件及从表",
			response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject updateFtyDeviceProcessAnnex(FtyDeviceProcessAnnex ftyDeviceProcessAnnex){
		try{
			this.getDubboBaseInterface().updateFtyDeviceProcessAnnex(ftyDeviceProcessAnnex);
			this.addOperationLog("更新设备-工序-附件及从表", "", true);
			jsonView.successPack("saveFtyDeviceProcessAnnex : 保存数据成功");
		}catch(Exception e){
			jsonView.failPack("saveFtyDeviceProcessAnnex error",e.toString());
			this.addOperationLog("更新设备-工序-附件及从表", "", false);
			log.error("saveFtyDeviceProcessAnnex is error",e);
		}
		return jsonView;
	}

	/**
	 * 根据设备工序ID查询工装类型
	 *
	 * @param params
	 * @return
	 */
	@POST
	@Path("getAnnexByDeviceProcessId")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据设备工序ID查询工装类型", notes = "根据设备工序ID查询工装类型", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getAnnexByDeviceProcessId(@ApiParam(value = "查询条件", required = true) Map<String, Object> params) {
		try {
			List<FtyDeviceProcessAnnex> ftyDeviceProcessAnnexList = this.getDubboBaseInterface().findAnnexByDeviceProcessId(params);
			jsonView.successPack(ftyDeviceProcessAnnexList, "根据设备工序ID查询工装类型成功");
		} catch (Exception e) {
			jsonView.failPack(false, "根据设备工序ID查询工装类型失败");
			this.addOperationLog("根据设备工序ID查询工装类型失败", "", false);
			log.error("getAnnexByDeviceProcessId is error", e);
		}
		return jsonView;
	}

}
