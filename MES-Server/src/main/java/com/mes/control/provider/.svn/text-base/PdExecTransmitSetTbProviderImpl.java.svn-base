package com.mes.control.provider;

import com.mes.control.mapper.PdExecTransmitSetTbMapper;
import com.mes.dubbo.interprovider.control.IPdExecTransmitSetTbProvider;
import com.mes.entity.control.PdExecTransmitSetTb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * $table.description
 * Created by xiuyou.xu on 2017/09/01.
 */
public class PdExecTransmitSetTbProviderImpl extends BaseProviderImpl<PdExecTransmitSetTb> implements IPdExecTransmitSetTbProvider {
    private static Logger logger = LoggerFactory.getLogger(PdExecTransmitSetTbProviderImpl.class);

    @Autowired
    @Qualifier("pdExecTransmitSetTbMapper")
    private PdExecTransmitSetTbMapper pdExecTransmitSetTbMapper;

    @Override
    public PdExecTransmitSetTbMapper getBaseInterfaceMapper() {
        return pdExecTransmitSetTbMapper;
    }
}
