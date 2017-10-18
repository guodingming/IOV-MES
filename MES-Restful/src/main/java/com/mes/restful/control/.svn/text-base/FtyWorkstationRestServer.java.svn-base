package com.mes.restful.control;

import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.dubbo.interprovider.control.IFtyWorkstationProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.FtyWorkstation;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Api(value = "工作站管理-（workstation ）", description = "工作站管理-（workstation ）")
@Path(RestConstants.RestPathPrefix.FTYWORKSTATION)
public class FtyWorkstationRestServer extends BaseRestServerInterfaceImpl<FtyWorkstation> {

	private IDpDataDictionaryProvider dpDataDictionaryProvider = ControlConsumer.getDpDataDictionaryProvider();
	@Override
	public IFtyWorkstationProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyWorkstationProvider();
	}

	@POST
	@Path("saveWorkstationDevices")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "保存工作站及工作站下的设备信息",notes ="保存工作站及工作站下的设备信息",response = JsonViewObject.class,
			produces = MediaType.APPLICATION_JSON)
	public JsonViewObject saveWorkStationDevicesByIds(FtyWorkstation ftyWorkstation){
		try{
			this.getDubboBaseInterface().saveWorkStationAndDevicesInfo(ftyWorkstation);
			jsonView.successPack("工作站和设备-工作站信息添加成功！");
		}catch(Exception e){
			jsonView.failPack(e);
		}
		return  jsonView;
	}

	@POST
	@Path("updateWorkstationDevices")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "更新工作站及工作站下的设备信息",notes ="更新工作站及工作站下的设备信息",response = JsonViewObject.class,
			produces = MediaType.APPLICATION_JSON)
	public JsonViewObject updateWorkStationDevicesByIds(FtyWorkstation ftyWorkstation){
		try{
			this.getDubboBaseInterface().updateWorkStationAndDevicesInfo(ftyWorkstation);
			jsonView.successPack("工作站和设备-工作站信息更新成功！");
		}catch(Exception e){
			jsonView.failPack(e);
		}
		return  jsonView;
	}

	/**
	 * 获取所有工作站名称
	 *ledengyun--2017/10/09
	 * @return
	 */
	@GET
	@Path("/getWorkStationName")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取所有工作站名称", notes = "获取所有工作站名称", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getWorkStationName() {
		try {
			String typeKey = ConfigHelper.getValue("workstationType.dic.type");
			if (StringUtils.isNotBlank(typeKey)) {
				List<DpDataDictionary> dpDataDictionaryList = this.dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
				jsonView.successPack(dpDataDictionaryList, "获取所有工作站名称成功");
			} else {
				jsonView.failPack("获取所有工作站名称失败,请确认字典项配置");
			}
		} catch (Exception e) {
			jsonView.failPack("获取所有工作站名称失败");
			this.addOperationLog("获取所有工作站名称", "", false);
			log.error("FtyWorkstationRestServer getWorkStationName is error", e);
		}
		return jsonView;
	}
}
