package com.mes.restful.control;

import com.google.common.collect.Lists;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.dubbo.interprovider.control.IFtyDeviceProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.FtyDevice;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "工厂管理-设备管理", description = "工厂管理-设备管理")
@Path(RestConstants.RestPathPrefix.FTYDEVICE)
public class FtyDeviceRestServer extends BaseRestServerInterfaceImpl<FtyDevice> {

    private IDpDataDictionaryProvider dpDataDictionaryProvider = ControlConsumer.getDpDataDictionaryProvider();

	@Override
	public IFtyDeviceProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceProvider();
	}

	@POST
	@Path("byPage/area")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据车间分页查询设备列表",notes = "根据车间分页查询设备列表",response = JsonViewObject.class,produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getDevicePageByAreaId(Page page){
		try{
			page = this.getDubboBaseInterface().getDevicePageByAreaId(page);
			this.addOperationLog("根据车间分页查询设备列表","",true);
			jsonView.successPack(page);
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("根据车间分页查询设备列表","",false);
			log.error("FtyDeviceRestServer getDevicePageByAreaId is error",e);
		}
		return jsonView;
	}

	@POST
	@Path("updateFtyDevicesAndDeviceConfig")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "更新设备信息及设备配置信息",notes ="更新设备信息及设备配置信息",response = JsonViewObject.class,
			produces = MediaType.APPLICATION_JSON)
	  public JsonViewObject updateDeviceAndDeviceConfigInfo(FtyDevice ftyDevice){
		try{
		  this.getDubboBaseInterface().updateDeviceAndConfigInfo(ftyDevice);
		  jsonView.successPack("更新设备信息及设备配置信息 -- success");
		}catch(Exception e){
			jsonView.failPack("更新设备信息及设备配置信息 -- failed");
		}
		return jsonView;
	}

	@POST
	@Path("saveFtyDevicesAndDeviceConfig")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "更新设备信息及设备配置信息",notes ="更新设备信息及设备配置信息",response = JsonViewObject.class,
			produces = MediaType.APPLICATION_JSON)
	public JsonViewObject saveDeviceAndDeviceConfigInfo(FtyDevice ftyDevice){
		try{
			this.getDubboBaseInterface().saveDeviceAndConfigInfo(ftyDevice);
			jsonView.successPack("新增设备信息及设备配置信息 -- success");
		}catch(Exception e){
			jsonView.failPack("新增设备信息及设备配置信息 -- failed");
		}
		return jsonView;
	}


	@GET
	@Path("getDevicesByProcess")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "根据工序ID查询设备列表", notes = "根据工序ID查询设备列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getDevicesByProcess(@ApiParam(value = "工序ID", required = true, defaultValue = "", example = "1") @QueryParam("processId") String processId){
		List<FtyDevice> result = Lists.newArrayList();
		try {
			result = this.getDubboBaseInterface().findDeviceListByProcessId(processId);
			jsonView.successPack(result, "根据工序ID查询设备列表成功");
		}catch (Exception e){
			jsonView.failPack(e, "根据工序ID查询设备列表失败");
			this.addOperationLog("根据工序ID查询设备列表", processId, false);
			log.error("FtyDeviceRestServer getDevicesByProcess is error,{processId:" + processId + "}", e);
		}
		return jsonView;
	}

	/**
	 * 根据设备Ip获取设备ID
	 * @param ip
	 * @return
	 * ledengyun--2017/8/29
	 */
	@GET
	@Path("findByIp")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "根据设备Ip查设备Id", notes = "根据设备Ip查设备Id", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject findByIp(@ApiParam(value = "设备IP", required = true, defaultValue = "", example = "127.0.0.1") @QueryParam("ip") String ip){
		String result = null;
		try {
			result = this.getDubboBaseInterface().findByIp(ip);
			if(result !=null && !result.isEmpty()) {
				jsonView.successPack(result, "根据设备Ip查设备Id成功");
			}else {
				jsonView.failPack(result,"该设备IP不存在");
			}
		}catch (Exception e){
			jsonView.failPack(e, "根据设备Ip查设备Id失败");
			this.addOperationLog("根据设备Ip查设备Id", ip, false);
			log.error("FtyDeviceRestServer findByIp is error,{processId:" + ip + "}", e);
		}
		return jsonView;
	}

    /**
     * 获取所有设备配置类型
     *
     * @return
     */
    @GET
    @Path("deviceConfigType")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取所有设备配置类型", notes = "获取所有设备配置类型", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getDeviceConfigType() {
        try {
            String typeKey = ConfigHelper.getValue("device.dic.type");
            if (StringUtils.isNotBlank(typeKey)) {
                List<DpDataDictionary> dpDataDictionaryList = this.dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
                jsonView.successPack(dpDataDictionaryList, "获取所有设备配置类型成功");
            } else {
                jsonView.failPack("获取所有设备配置类型失败,请确认字典项配置");
            }

        } catch (Exception e) {
            jsonView.failPack("获取所有设备配置类型失败");
            this.addOperationLog("获取所有设备配置类型", "", false);
            log.error("DpProcessBaseConfigRestServer getDeviceConfigType is error", e);
        }
        return jsonView;
    }

}
