package com.mes.control.provider;

import com.mes.control.mapper.SerialRuleWorkOrderAssociationMapper;
import com.mes.dubbo.interprovider.control.ISerialRuleWorkOrderAssociationProvider;
import com.mes.entity.control.SerialRuleWorkOrderAssociation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 开发平台-流水规则-规则工单关联
 * Created by xiuyou.xu on 2017/10/16.
 */
public class SerialRuleWorkOrderAssociationProviderImpl extends BaseProviderImpl<SerialRuleWorkOrderAssociation> implements ISerialRuleWorkOrderAssociationProvider {
    private static Logger logger = LoggerFactory.getLogger(SerialRuleWorkOrderAssociationProviderImpl.class);

    @Autowired
    @Qualifier("serialRuleWorkOrderAssociationMapper")
    private SerialRuleWorkOrderAssociationMapper serialRuleWorkOrderAssociationMapper;

    @Override
    public SerialRuleWorkOrderAssociationMapper getBaseInterfaceMapper() {
        return serialRuleWorkOrderAssociationMapper;
    }
}
