package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.Agent;
/**
 * 平台管理-工作站Agent管理
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface AgentMapper extends BaseInterfaceMapper<Agent> {

    /**
     * 根据ip更新状态
     * @param agent
     */
    void updateStatusByIp(Agent agent);
}
