package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-数据字典表
*/
@Api(value = "开发平台-数据字典表", description = "开发平台-数据字典表")
@Path(RestConstants.RestPathPrefix.DPDATADICTIONARY)
public class DpDataDictionaryRestServer extends BaseRestServerInterfaceImpl<DpDataDictionary> {
	@Override
	public IDpDataDictionaryProvider getDubboBaseInterface() {
		return ControlConsumer.getDpDataDictionaryProvider();
	}
}
