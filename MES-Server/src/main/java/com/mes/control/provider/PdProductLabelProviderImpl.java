package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdProductLabelMapper;
import com.mes.dubbo.interprovider.control.IPdProductLabelProvider;
import com.mes.entity.control.PdProductLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 产品管理-产品标签
 * Created by xiuyou.xu on 2017/09/28.
 */
public class PdProductLabelProviderImpl extends BaseProviderImpl<PdProductLabel> implements IPdProductLabelProvider {
    private static Logger logger = LoggerFactory.getLogger(PdProductLabelProviderImpl.class);

    @Autowired
    @Qualifier("pdProductLabelMapper")
    private PdProductLabelMapper pdProductLabelMapper;

    @Override
    public PdProductLabelMapper getBaseInterfaceMapper() {
        return pdProductLabelMapper;
    }

    @Override
    public Object getTemplate(String param) throws DubboProviderException {
        return param;
    }

    @Override
    public Object postTemplate(String param) throws DubboProviderException {
        return param;
    }
}
