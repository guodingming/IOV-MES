package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.UserProcess;

import java.util.List;
import java.util.Map;

/**
 * 用户管理-人员技能
*/
public interface UserProcessMapper extends BaseInterfaceMapper<UserProcess> {

    /**
     * 根据用户和工程查询工序信息
     * @param query
     * @return
     */
    public List<UserProcess> findByUserAndProject(Map<String, Object> query);

    /**
     * 根据条件查询可以操作的工序
     * @param query
     * @return
     */
    public UserProcess findAuthProcess(Map<String, Object> query);
}
