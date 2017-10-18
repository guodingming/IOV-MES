package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.ExpandTableConfig;
import com.mes.entity.control.Metadata;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface IMetadataProvider extends DubboBaseInterface<Metadata> {

    public String saveFieldList(String tableId,List<Metadata> list)throws DubboProviderException;

    public List<Metadata>findByTableId(String tableId,String isExpand)throws DubboProviderException;
}
