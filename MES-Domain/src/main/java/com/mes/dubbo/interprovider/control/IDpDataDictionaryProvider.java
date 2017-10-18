package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpDataDictionary;

import java.util.List;

/**
 * 开发平台-数据字典表
*/
public interface IDpDataDictionaryProvider extends DubboBaseInterface<DpDataDictionary> {

    /**
     * 根据字典分类key获取该分类下的所有字典项
     *
     * @param typeKey
     * @return
     * @throws DubboProviderException
     */
    public List<DpDataDictionary> findDictionaryByTypeKey(String typeKey) throws DubboProviderException;
}
