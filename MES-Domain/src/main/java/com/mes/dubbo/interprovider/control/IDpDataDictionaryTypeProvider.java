package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpDataDictionaryType;

/**
 * 开发平台-数据字典类型
*/
public interface IDpDataDictionaryTypeProvider extends DubboBaseInterface<DpDataDictionaryType> {
    /**
     * 验证分类下是否有数据
     * @param id
     * @return
     * ledengyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
