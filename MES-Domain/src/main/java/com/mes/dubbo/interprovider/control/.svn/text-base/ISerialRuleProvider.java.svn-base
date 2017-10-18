package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.SerialRule;

import java.util.Date;

/**
* 开发平台-流水规则-规则
* Created by xiuyou.xu on 2017/10/16.
*/
public interface ISerialRuleProvider extends DubboBaseInterface<SerialRule> {
    /**
     * 根据工单号获取并更新流水号
     * @param workOrderNum
     * @return
     * @throws DubboProviderException
     */
    String updateSerial(String workOrderNum) throws DubboProviderException;

    /**
     * 根据vin号查询已开工单的流水
     * @param vin
     * @return
     * @throws DubboProviderException
     */
    SerialRule getByVin(String vin) throws DubboProviderException;

    /**
     * 根据产品id查询已开工单的流水
     * @param pdId
     * @return
     * @throws DubboProviderException
     */
    SerialRule getByPdId(String pdId) throws DubboProviderException;

    /**
     * 根据开单日期选择已开工单的流水
     * @param date
     * @return
     * @throws DubboProviderException
     */
    SerialRule getByDate(Date date) throws DubboProviderException;
}
