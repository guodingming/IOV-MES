package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpSubassemblyType;

/**
 * 开发平台-组件分类
*/
public interface IDpSubassemblyTypeProvider extends DubboBaseInterface<DpSubassemblyType> {
    /**
     * 验证分类下是否有数据
     * @param id
     * @return
     * ledengyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
