package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceFaultProcessProvider;
import com.mes.entity.control.FtyDeviceFaultProcess;
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

@Api(value = "工厂管理-设备异常-异常分类", description = "工厂管理-设备异常-异常分类")
@Path(RestConstants.RestPathPrefix.FTYDEVICEFAULTPROCESS)
public class FtyDeviceFaultProcessRestServer extends BaseRestServerInterfaceImpl<FtyDeviceFaultProcess> {
	@Override
	public IFtyDeviceFaultProcessProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceFaultProcessProvider();
	}

	/**
	 * 根据异常分类Id获取异常信息
	 * @param deviceFaultInfoId
	 * @return
	 * ledengyun--2017/09/20
	 */
	@GET
	@Path("/findByDeviceFaultInfoId")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据异常分类Id获取异常信息", notes = "根据异常分类Id获取异常信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject findByDeviceFaultInfoId(@ApiParam(value = "异常分类Id") @QueryParam("deviceFaultInfoId") String deviceFaultInfoId) {
		try {
			List<FtyDeviceFaultProcess> list = this.getDubboBaseInterface().findByDeviceFaultInfoId(deviceFaultInfoId);
			this.addOperationLog("根据异常分类Id获取异常信息成功", "", true);
			jsonView.successPack(list, "根据异常分类Id获取异常信息成功!");
		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("根据异常分类Id获取异常信息失败", "", false);
			log.error("FtyDeviceFaultProcessRestServer findByDeviceFaultInfoId is error", e);
		}

		return jsonView;
	}
}
