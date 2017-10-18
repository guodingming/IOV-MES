package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.UserGroup;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface UserGroupMapper extends BaseInterfaceMapper<UserGroup> {

    public UserGroup findByUserId(String userId);
}
