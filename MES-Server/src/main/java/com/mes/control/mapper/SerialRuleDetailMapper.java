package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.SerialRuleDetail;
/**
 * 开发平台-流水规则-明细
 * Created by xiuyou.xu on 2017/10/16.
 */
public interface SerialRuleDetailMapper extends BaseInterfaceMapper<SerialRuleDetail> {

    /**
     * 乐观锁方式更新
     * @param serialRuleDetail
     * @return
     */
    int updateDetail(SerialRuleDetail serialRuleDetail);
}
