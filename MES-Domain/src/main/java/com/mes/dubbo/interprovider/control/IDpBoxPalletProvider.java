package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpBoxPallet;

import java.util.List;

/**
* 开发平台-栈板管理
* Created by xiuyou.xu on 2017/7/4.
*/
public interface IDpBoxPalletProvider extends DubboBaseInterface<DpBoxPallet> {

    public DpBoxPallet findByPdId(String pdId,String palletKey)throws DubboProviderException;

}
