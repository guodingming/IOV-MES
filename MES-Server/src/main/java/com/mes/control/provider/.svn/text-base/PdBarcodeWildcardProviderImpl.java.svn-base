package com.mes.control.provider;

import com.mes.control.mapper.PdBarcodeWildcardMapper;
import com.mes.dubbo.interprovider.control.IPdBarcodeWildcardProvider;
import com.mes.entity.control.PdBarcodeWildcard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 产品管理-条码通配符列表
 * Created by xiuyou.xu on 2017/10/11.
 */
public class PdBarcodeWildcardProviderImpl extends BaseProviderImpl<PdBarcodeWildcard> implements IPdBarcodeWildcardProvider {
    private static Logger logger = LoggerFactory.getLogger(PdBarcodeWildcardProviderImpl.class);

    @Autowired
    @Qualifier("pdBarcodeWildcardMapper")
    private PdBarcodeWildcardMapper pdBarcodeWildcardMapper;

    @Override
    public PdBarcodeWildcardMapper getBaseInterfaceMapper() {
        return pdBarcodeWildcardMapper;
    }
}
