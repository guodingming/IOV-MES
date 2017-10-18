package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.SerialRule;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 开发平台-流水规则-规则
 * Created by xiuyou.xu on 2017/10/16.
 */
public interface SerialRuleMapper extends BaseInterfaceMapper<SerialRule> {

    SerialRule getByPdId(String pdId);

    SerialRule getByDate(@Param("start") Date start, @Param("end") Date end);
}
