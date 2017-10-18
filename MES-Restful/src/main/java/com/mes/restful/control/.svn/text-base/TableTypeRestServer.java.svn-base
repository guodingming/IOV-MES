package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.ITableTypeProvider;
import com.mes.entity.control.TableType;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

/**
 * 开发平台-对象分类
*/
@Api(value = "开发平台-对象分类", description = "开发平台-对象分类")
@Path(RestConstants.RestPathPrefix.TABLETYPE)
public class TableTypeRestServer extends BaseRestServerInterfaceImpl<TableType> {
	@Override
	public ITableTypeProvider getDubboBaseInterface() {
		return ControlConsumer.getTableTypeProvider();
	}
}
