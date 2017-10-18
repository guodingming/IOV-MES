package com.mes.control.provider;

import com.mes.control.mapper.SerialRuleDetailMapper;
import com.mes.dubbo.interprovider.control.ISerialRuleDetailProvider;
import com.mes.entity.control.SerialRuleDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 开发平台-流水规则-明细
 * Created by xiuyou.xu on 2017/10/16.
 */
public class SerialRuleDetailProviderImpl extends BaseProviderImpl<SerialRuleDetail> implements ISerialRuleDetailProvider {
    private static Logger logger = LoggerFactory.getLogger(SerialRuleDetailProviderImpl.class);

    @Autowired
    @Qualifier("serialRuleDetailMapper")
    private SerialRuleDetailMapper serialRuleDetailMapper;

    @Override
    public SerialRuleDetailMapper getBaseInterfaceMapper() {
        return serialRuleDetailMapper;
    }

}
