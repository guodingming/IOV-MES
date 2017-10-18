package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpBoxPalletInfo;
/**
* 开发平台-栈板管理-包装箱
* Created by xiuyou.xu on 2017/7/4.
*/
public interface IDpBoxPalletInfoProvider extends DubboBaseInterface<DpBoxPalletInfo> {

    public String saveBoxToPallet(String palletKey, String boxKey)throws DubboProviderException;

}
