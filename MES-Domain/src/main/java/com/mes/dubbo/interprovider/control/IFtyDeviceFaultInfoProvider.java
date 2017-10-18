package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.FtyDeviceFaultInfo;

public interface IFtyDeviceFaultInfoProvider extends DubboBaseInterface<FtyDeviceFaultInfo> {

    /**
     * 验证分类下是否有数据
     * @param id
     * @return
     * ledengyun--2017/10/13
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
