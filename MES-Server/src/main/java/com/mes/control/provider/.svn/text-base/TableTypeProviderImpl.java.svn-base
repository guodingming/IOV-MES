package com.mes.control.provider;

import com.mes.control.mapper.TableTypeMapper;
import com.mes.dubbo.interprovider.control.ITableTypeProvider;
import com.mes.entity.control.TableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-对象分类
*/
public class TableTypeProviderImpl extends BaseProviderImpl<TableType> implements ITableTypeProvider {
	@Autowired
	@Qualifier("tableTypeMapper")
	private TableTypeMapper tableTypeMapper;

	@Override
	public TableTypeMapper getBaseInterfaceMapper() {
		return tableTypeMapper;
	}
}
