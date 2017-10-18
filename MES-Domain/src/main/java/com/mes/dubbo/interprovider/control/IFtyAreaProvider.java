package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.FtyArea;

public interface IFtyAreaProvider extends DubboBaseInterface<FtyArea> {

    /**
     * 分类删除验证
     * @param id
     * @return
     * lednegyun--2017/10/10
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
