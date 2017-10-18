package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.SerialRuleWorkOrderAssociation;
/**
 * 开发平台-流水规则-规则工单关联
 * Created by xiuyou.xu on 2017/10/16.
 */
public interface SerialRuleWorkOrderAssociationMapper extends BaseInterfaceMapper<SerialRuleWorkOrderAssociation> {

    /**
     * 根据工单号查询工单流水关联信息
     * @param workOrderNum
     * @return
     */
    SerialRuleWorkOrderAssociation findByWorkOrderNum(String workOrderNum);
}
