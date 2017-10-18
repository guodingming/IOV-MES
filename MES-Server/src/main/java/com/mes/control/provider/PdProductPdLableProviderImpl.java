package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdProductPdLableMapper;
import com.mes.dubbo.interprovider.control.IPdProductPdLableProvider;
import com.mes.entity.control.PdProductPdLable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 开发平台-产品明细-产品标签
 * Created by xiuyou.xu on 2017/09/27.
 */
public class PdProductPdLableProviderImpl extends BaseProviderImpl<PdProductPdLable> implements IPdProductPdLableProvider {
    private static Logger logger = LoggerFactory.getLogger(PdProductPdLableProviderImpl.class);

    @Autowired
    @Qualifier("pdProductPdLableMapper")
    private PdProductPdLableMapper pdProductPdLableMapper;

    @Override
    public PdProductPdLableMapper getBaseInterfaceMapper() {
        return pdProductPdLableMapper;
    }

    @Override
    public PdProductPdLable findByProductInfoId(String pdProductInfoId) throws DubboProviderException {
        PdProductPdLable pdProductPdLable = null;
        try {
            pdProductPdLable = this.getBaseInterfaceMapper().findByProductInfoId(pdProductInfoId);
        } catch (Exception e) {
            log.error("PdProductPdLableProviderImpl findByProductInfoId ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return pdProductPdLable;
    }
}
