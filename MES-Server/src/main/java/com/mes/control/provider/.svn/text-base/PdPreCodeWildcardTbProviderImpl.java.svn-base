package com.mes.control.provider;

import com.mes.control.mapper.PdPreCodeWildcardTbMapper;
import com.mes.dubbo.interprovider.control.IPdPreCodeWildcardTbProvider;
import com.mes.entity.control.PdPreCodeWildcardTb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 产品管理-条码扩展通配符
 * Created by xiuyou.xu on 2017/10/11.
 */
public class PdPreCodeWildcardTbProviderImpl extends BaseProviderImpl<PdPreCodeWildcardTb> implements IPdPreCodeWildcardTbProvider {
    private static Logger logger = LoggerFactory.getLogger(PdPreCodeWildcardTbProviderImpl.class);

    @Autowired
    @Qualifier("pdPreCodeWildcardTbMapper")
    private PdPreCodeWildcardTbMapper pdPreCodeWildcardTbMapper;

    @Override
    public PdPreCodeWildcardTbMapper getBaseInterfaceMapper() {
        return pdPreCodeWildcardTbMapper;
    }

}
