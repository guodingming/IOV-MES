package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.Table;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface ITableProvider extends DubboBaseInterface<Table> {
    public boolean deleteById(String id) throws DubboProviderException;

    public List findData(String id) throws DubboProviderException;
}
