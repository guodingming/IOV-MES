package com.mes.control.provider;

import com.mes.control.mapper.PdExecSoftinjectTbMapper;
import com.mes.dubbo.interprovider.control.IPdExecSoftinjectTbProvider;
import com.mes.entity.control.PdExecSoftinjectTb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 软件注入结果记录
 * Created by xiuyou.xu on 2017/09/01.
 */
public class PdExecSoftinjectTbProviderImpl extends BaseProviderImpl<PdExecSoftinjectTb> implements IPdExecSoftinjectTbProvider {
    private static Logger logger = LoggerFactory.getLogger(PdExecSoftinjectTbProviderImpl.class);

    @Autowired
    @Qualifier("pdExecSoftinjectTbMapper")
    private PdExecSoftinjectTbMapper pdExecSoftinjectTbMapper;

    @Override
    public PdExecSoftinjectTbMapper getBaseInterfaceMapper() {
        return pdExecSoftinjectTbMapper;
    }
}
