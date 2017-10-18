package com.mes.control.provider;

import com.mes.control.mapper.PdWorkTestDetailTbMapper;
import com.mes.dubbo.interprovider.control.IPdWorkTestDetailTbProvider;
import com.mes.entity.control.PdWorkTestDetailTb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 终端测试项结果
 * Created by xiuyou.xu on 2017/09/01.
 */
public class PdWorkTestDetailTbProviderImpl extends BaseProviderImpl<PdWorkTestDetailTb> implements IPdWorkTestDetailTbProvider {
    private static Logger logger = LoggerFactory.getLogger(PdWorkTestDetailTbProviderImpl.class);

    @Autowired
    @Qualifier("pdWorkTestDetailTbMapper")
    private PdWorkTestDetailTbMapper pdWorkTestDetailTbMapper;

    @Override
    public PdWorkTestDetailTbMapper getBaseInterfaceMapper() {
        return pdWorkTestDetailTbMapper;
    }
}
