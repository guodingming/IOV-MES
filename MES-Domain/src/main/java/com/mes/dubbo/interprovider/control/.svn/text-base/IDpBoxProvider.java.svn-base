package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpBox;

import java.util.List;

/**
* 开发平台-包装箱管理
* Created by xiuyou.xu on 2017/7/4.
*/
public interface IDpBoxProvider extends DubboBaseInterface<DpBox> {

    public DpBox findByPdId(String pdId,String boxKey)throws DubboProviderException;

    /**
     * 根据箱码获取包装箱信息
     * @param boxKey
     * @return
     * @throws DubboProviderException
     */
    public DpBox findByBoxKey(String boxKey) throws DubboProviderException;

}
