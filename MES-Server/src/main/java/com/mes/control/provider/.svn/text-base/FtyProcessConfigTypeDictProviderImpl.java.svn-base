package com.mes.control.provider;

import com.mes.control.mapper.FtyProcessConfigTypeDictMapper;
import com.mes.dubbo.interprovider.control.IFtyProcessConfigTypeDictProvider;
import com.mes.entity.control.FtyProcessConfigTypeDict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 工厂管理-工序配置类型字典
 * Created by xiuyou.xu on 2017/7/4.
 */
public class FtyProcessConfigTypeDictProviderImpl extends BaseProviderImpl<FtyProcessConfigTypeDict> implements IFtyProcessConfigTypeDictProvider {
    private static Logger logger = LoggerFactory.getLogger(FtyProcessConfigTypeDictProviderImpl.class);

    @Autowired
    @Qualifier("ftyProcessConfigTypeDictMapper")
    private FtyProcessConfigTypeDictMapper ftyProcessConfigTypeDictMapper;

    @Override
    public FtyProcessConfigTypeDictMapper getBaseInterfaceMapper() {
        return ftyProcessConfigTypeDictMapper;
    }
}
