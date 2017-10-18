package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpBox;
import kafka.controller.LeaderIsrAndControllerEpoch;

import java.util.List;

/**
 * 开发平台-包装箱管理
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface DpBoxMapper extends BaseInterfaceMapper<DpBox> {

    public DpBox findByPdId(String pdId,String boxKey);

    public DpBox findByBoxKey(String boxKey);

}
