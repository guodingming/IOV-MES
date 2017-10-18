package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpFunctionType;

/**
 * 开发平台-函数分类
*/
public interface IDpFunctionTypeProvider extends DubboBaseInterface<DpFunctionType> {
    public boolean deleteById(String id) throws DubboProviderException;
}
