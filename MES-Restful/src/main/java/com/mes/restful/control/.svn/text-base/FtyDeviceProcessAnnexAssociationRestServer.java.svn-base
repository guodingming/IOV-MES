package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyDeviceProcessAnnexAssociationProvider;
import com.mes.entity.control.FtyDeviceProcessAnnexAssociation;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 设备管理-设备-工序-附件
*/
@Api(value = "设备管理-设备-工序-附件", description = "设备管理-设备-工序-附件")
@Path(RestConstants.RestPathPrefix.FTYDEVICEPROCESSANNEXASSOCIATION)
public class FtyDeviceProcessAnnexAssociationRestServer extends BaseRestServerInterfaceImpl<FtyDeviceProcessAnnexAssociation> {
	@Override
	public IFtyDeviceProcessAnnexAssociationProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyDeviceProcessAnnexAssociationProvider();
	}
}
