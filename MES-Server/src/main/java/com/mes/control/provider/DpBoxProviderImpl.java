package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpBoxMapper;
import com.mes.dubbo.interprovider.control.IDpBoxProvider;
import com.mes.entity.control.DpBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * 开发平台-包装箱管理
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DpBoxProviderImpl extends BaseProviderImpl<DpBox> implements IDpBoxProvider {
    private static Logger logger = LoggerFactory.getLogger(DpBoxProviderImpl.class);

    @Autowired
    @Qualifier("dpBoxMapper")
    private DpBoxMapper dpBoxMapper;

    @Override
    public DpBoxMapper getBaseInterfaceMapper() {
        return dpBoxMapper;
    }

    public DpBox findByPdId(String pdId,String boxKey)throws DubboProviderException{
        DpBox list = null;
        list = dpBoxMapper.findByPdId(pdId,boxKey);
        return list;
    }

    /**
     * 根据箱码获取包装箱信息
     * @param boxKey
     * @return
     * @throws DubboProviderException
     */
    public DpBox findByBoxKey(String boxKey) throws DubboProviderException{
        DpBox dpBox=dpBoxMapper.findByBoxKey(boxKey);
        return dpBox;
    }
}
