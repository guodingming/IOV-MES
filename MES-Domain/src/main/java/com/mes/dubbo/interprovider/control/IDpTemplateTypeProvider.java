package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpTemplateType;

/**
 * 开发平台-模板分类
*/
public interface IDpTemplateTypeProvider extends DubboBaseInterface<DpTemplateType> {

    /**
     * 验证模板分类下否有数据
     * @param id
     * @return
     * lednegyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
