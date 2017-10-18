package com.mes.control.provider;

import com.mes.control.mapper.PdBaseReplaceTbMapper;
import com.mes.dubbo.interprovider.control.IPdBaseReplaceTbProvider;
import com.mes.entity.control.PdBaseReplaceTb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 产品管理-条码通配符日期替换
 * Created by xiuyou.xu on 2017/10/11.
 */
public class PdBaseReplaceTbProviderImpl extends BaseProviderImpl<PdBaseReplaceTb> implements IPdBaseReplaceTbProvider {
    private static Logger logger = LoggerFactory.getLogger(PdBaseReplaceTbProviderImpl.class);

    @Autowired
    @Qualifier("pdBaseReplaceTbMapper")
    private PdBaseReplaceTbMapper pdBaseReplaceTbMapper;

    @Override
    public PdBaseReplaceTbMapper getBaseInterfaceMapper() {
        return pdBaseReplaceTbMapper;
    }
}
