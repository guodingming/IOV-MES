package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.UserGroupMapper;
import com.mes.dubbo.interprovider.control.IUserGroupProvider;
import com.mes.entity.control.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public class UserGroupProviderImpl extends BaseProviderImpl<UserGroup> implements IUserGroupProvider {

    @Autowired
    @Qualifier("userGroupMapper")
    private UserGroupMapper userGroupMapper;

    @Override
    public UserGroupMapper getBaseInterfaceMapper() {
        return userGroupMapper;
    }

    public UserGroup findByUserId(String userId)throws DubboProviderException{
        UserGroup userGroup = userGroupMapper.findByUserId(userId);
       return null;
    }
}
