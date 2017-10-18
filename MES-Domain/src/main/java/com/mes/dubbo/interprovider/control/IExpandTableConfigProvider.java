package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.ExpandTableConfig;
import com.mes.entity.control.Metadata;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface IExpandTableConfigProvider extends DubboBaseInterface<ExpandTableConfig> {
    /**
     * 添加扩展对象
     * @param tableId
     * @param list
     * @return
     * @throws DubboProviderException
     */
    public String saveExpandField(String tableId,List<Metadata> list)throws DubboProviderException;

    public ExpandTableConfig findByTableId(String tableId) throws DubboProviderException;
}
