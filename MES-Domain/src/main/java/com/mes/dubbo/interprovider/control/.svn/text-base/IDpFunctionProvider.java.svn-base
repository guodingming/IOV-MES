package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpFunction;

/**
 * 开发平台-脚本
*/
public interface IDpFunctionProvider extends DubboBaseInterface<DpFunction> {
    /**
     * 芯片操作，根据source type查找对应的处理函数。映射关系可在配置文件中进行配置
     *
     * @param sourceType
     * @return
     * @throws DubboProviderException
     */
    DpFunction findByBySourceType(String sourceType) throws DubboProviderException;
}
