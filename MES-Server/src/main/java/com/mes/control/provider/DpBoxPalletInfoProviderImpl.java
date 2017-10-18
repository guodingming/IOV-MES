package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.DpBoxMapper;
import com.mes.control.mapper.DpBoxPalletInfoMapper;
import com.mes.control.mapper.DpBoxPalletMapper;
import com.mes.dubbo.interprovider.control.IDpBoxPalletInfoProvider;
import com.mes.entity.control.DpBox;
import com.mes.entity.control.DpBoxPallet;
import com.mes.entity.control.DpBoxPalletInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

/**
 * 开发平台-栈板管理-包装箱
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DpBoxPalletInfoProviderImpl extends BaseProviderImpl<DpBoxPalletInfo> implements IDpBoxPalletInfoProvider {
    private static Logger logger = LoggerFactory.getLogger(DpBoxPalletInfoProviderImpl.class);

    @Autowired
    @Qualifier("dpBoxPalletInfoMapper")
    private DpBoxPalletInfoMapper dpBoxPalletInfoMapper;
    @Autowired
    @Qualifier("dpBoxMapper")
    private DpBoxMapper dpBoxMapper;
    @Autowired
    @Qualifier("dpBoxPalletMapper")
    private DpBoxPalletMapper dpBoxPalletMapper;



    @Override
    public DpBoxPalletInfoMapper getBaseInterfaceMapper() {
        return dpBoxPalletInfoMapper;
    }

    public String saveBoxToPallet(String palletKey,String boxKey)throws DubboProviderException{
        String id = null;
        DpBox dpBox = new DpBox();
        dpBox = dpBoxMapper.findByBoxKey(boxKey);
        DpBoxPalletInfo dpBoxPalletInfo = new DpBoxPalletInfo();
        DpBoxPallet dpBoxPallet = new DpBoxPallet();
        if(dpBox !=null){
            dpBoxPallet = dpBoxPalletMapper.findByPdId(dpBox.getPdId(),palletKey);
            id = IDGenerator.getID();
            dpBoxPalletInfo.setId(id);
            dpBoxPalletInfo.setBoxId(dpBox.getId());
            dpBoxPalletInfo.setBoxKey(boxKey);
            dpBoxPalletInfo.setPalletId(dpBoxPallet.getId());
            dpBoxPalletInfo.setCreateDate(new Date());
            dpBoxPalletInfoMapper.save(dpBoxPalletInfo);
            dpBoxPallet.setId(dpBoxPallet.getId());
            Long dd = dpBoxPallet.getQuantity();
            if(dd !=null) {
                dpBoxPallet.setQuantity(dd + 1);
            }else {
                dpBoxPallet.setQuantity(1L);
            }
            dpBoxPalletMapper.update(dpBoxPallet);
        }
        return id;

    }
}
