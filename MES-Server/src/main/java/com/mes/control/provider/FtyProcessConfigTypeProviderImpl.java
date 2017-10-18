package com.mes.control.provider;

import com.mes.control.mapper.FtyProcessConfigTypeMapper;
import com.mes.dubbo.interprovider.control.IFtyProcessConfigTypeProvider;
import com.mes.entity.control.FtyProcessConfigType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 工厂管理-工序配置类型
 * Created by xiuyou.xu on 2017/7/4.
 */
public class FtyProcessConfigTypeProviderImpl extends BaseProviderImpl<FtyProcessConfigType> implements IFtyProcessConfigTypeProvider {
    private static Logger logger = LoggerFactory.getLogger(FtyProcessConfigTypeProviderImpl.class);

    @Autowired
    @Qualifier("ftyProcessConfigTypeMapper")
    private FtyProcessConfigTypeMapper ftyProcessConfigTypeMapper;

    @Override
    public FtyProcessConfigTypeMapper getBaseInterfaceMapper() {
        return ftyProcessConfigTypeMapper;
    }
}
