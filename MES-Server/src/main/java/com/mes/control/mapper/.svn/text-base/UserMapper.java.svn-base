package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.User;
import com.mes.entity.control.UserLogin;

import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface UserMapper extends BaseInterfaceMapper<User> {
    /**
     * 关联用户到部门
     *
     * @param map
     */
    void saveDeptAuth(Map<String, Object> map);

    /**
     * 关联用户到用户组
     *
     * @param map
     */
    void saveGroupAuth(Map<String, Object> map);

    /**
     * 查询某部门下用户总数
     *
     * @param params
     * @return
     */
    int getCountByDeptId(Map<String, Object> params);

    /**
     * 分页查询某部门下用户列表
     *
     * @param params
     * @return
     */
    List findPageByDeptId(Map<String, Object> params);

    /**
     * 查询某用户组下用户总数
     *
     * @param params
     * @return
     */
    int getCountByUserGroupId(Map<String, Object> params);

    /**
     * 分页查询某用户组下用户列表
     *
     * @param params
     * @return
     */
    List findPageByUserGroupId(Map<String, Object> params);

    /**
     * 删除用户关联的部门列表
     *
     * @param id
     */
    void deleteDeptAuth(String id);

    /**
     * 根据用户组和用户id删除关联信息
     *
     * @param map
     */
    void deleteByGroupIdAndUserIds(Map<String, Object> map);

    /**
     * 查询指定部门下不属于指定用户组的所有用户
     *
     * @param user
     * @return
     */
    List<User> getAssignableUsers(User user);

    /**
     * 删除用户关联的用户组列表
     *
     * @param id
     */
    void deleteUserGroupAuth(String id);

    /**
     * 根据用户名和密码验证并获取用户信息
     *
     * @param userLogin
     * @return
     */
    User getLoginInfo(UserLogin userLogin);

    /**
     * 根据工单id查询对应的人员列表
     *
     * @param workOrderId
     * @return
     */
    List<User> getUsersByWorkOrder(String workOrderId);

    /**
     * 删除所有数据
     */
    void deleteAll();

    /**
     * 删除所有用户部门关联数据
     */
    void deleteAllUserDept();

    /**
     * 验证用户名密码是否有效
     * @param query
     * @return 如果有效返回用户信息
     */
    User validateUserInfo(Map<String, Object> query);
}
