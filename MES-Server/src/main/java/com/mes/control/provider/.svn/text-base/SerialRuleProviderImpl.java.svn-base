package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdWorkOrderMapper;
import com.mes.control.mapper.SerialRuleDetailMapper;
import com.mes.control.mapper.SerialRuleMapper;
import com.mes.control.mapper.SerialRuleWorkOrderAssociationMapper;
import com.mes.dubbo.interprovider.control.ISerialRuleProvider;
import com.mes.entity.control.SerialRule;
import com.mes.entity.control.SerialRuleDetail;
import com.mes.entity.control.SerialRuleWorkOrderAssociation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Calendar;
import java.util.Date;

/**
 * 开发平台-流水规则-规则
 * Created by xiuyou.xu on 2017/10/16.
 */
public class SerialRuleProviderImpl extends BaseProviderImpl<SerialRule> implements ISerialRuleProvider {
    private static Logger logger = LoggerFactory.getLogger(SerialRuleProviderImpl.class);

    @Autowired
    @Qualifier("serialRuleMapper")
    private SerialRuleMapper serialRuleMapper;

    @Autowired
    @Qualifier("serialRuleDetailMapper")
    private SerialRuleDetailMapper serialRuleDetailMapper;

    @Autowired
    @Qualifier("serialRuleWorkOrderAssociationMapper")
    private SerialRuleWorkOrderAssociationMapper serialRuleWorkOrderAssociationMapper;

    @Autowired
    @Qualifier("pdWorkOrderMapper")
    private PdWorkOrderMapper pdWorkOrderMapper;

    @Override
    public SerialRuleMapper getBaseInterfaceMapper() {
        return serialRuleMapper;
    }

    @Override
    public String updateSerial(String workOrderNum) throws DubboProviderException {
        try {
            SerialRuleWorkOrderAssociation association = serialRuleWorkOrderAssociationMapper.findByWorkOrderNum(workOrderNum);
            if (association != null) {
                String detailId = association.getRuleDetailId();
                SerialRuleDetail serialRuleDetail = serialRuleDetailMapper.findById(detailId);
                if (serialRuleDetail != null) {
                    Long currentValue = serialRuleDetail.getCurrentValue();
                    // 更新成功，i为1
                    int i = serialRuleDetailMapper.updateDetail(serialRuleDetail);
                    while (i == 0) {
                        serialRuleDetail = serialRuleDetailMapper.findById(detailId);
                        currentValue = serialRuleDetail.getCurrentValue();
                        serialRuleDetail.setCurrentValue(currentValue + 1);
                        i = serialRuleDetailMapper.updateDetail(serialRuleDetail);
                    }
                    return currentValue + "";
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }

    @Override
    public SerialRule getByVin(String vin) throws DubboProviderException {
        try {
            // 目前无vin信息
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }

    @Override
    public SerialRule getByPdId(String pdId) throws DubboProviderException {
        try {
            return serialRuleMapper.getByPdId(pdId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }

    @Override
    public SerialRule getByDate(Date date) throws DubboProviderException {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            Date start = c.getTime();
            c.add(Calendar.DATE, 1);
            Date end = c.getTime();
            return serialRuleMapper.getByDate(start, end);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }
}
