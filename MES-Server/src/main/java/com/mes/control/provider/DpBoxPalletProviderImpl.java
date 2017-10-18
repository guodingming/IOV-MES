package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpBoxPalletMapper;
import com.mes.dubbo.interprovider.control.IDpBoxPalletProvider;
import com.mes.entity.control.DpBoxPallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * 开发平台-栈板管理
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DpBoxPalletProviderImpl extends BaseProviderImpl<DpBoxPallet> implements IDpBoxPalletProvider {
    private static Logger logger = LoggerFactory.getLogger(DpBoxPalletProviderImpl.class);

    @Autowired
    @Qualifier("dpBoxPalletMapper")
    private DpBoxPalletMapper dpBoxPalletMapper;

    @Override
    public DpBoxPalletMapper getBaseInterfaceMapper() {
        return dpBoxPalletMapper;
    }

    public DpBoxPallet findByPdId(String pdId,String palletKey)throws DubboProviderException{
        DpBoxPallet dpBoxPallets = dpBoxPalletMapper.findByPdId(pdId,palletKey);
        return dpBoxPallets;

    }
}
