package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.User;
import com.mes.entity.control.UserLogin;
import com.mes.entity.control.UserProcess;

import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface IUserProvider extends DubboBaseInterface<User> {
    /**
     * 根据部门分页查询用户列表
     *
     * @param page
     * @return
     * @throws DubboProviderException
     */
    Page getPageByDeptId(Page page) throws DubboProviderException;

    /**
     * 根据用户组分页查询用户列表
     *
     * @param page
     * @return
     * @throws DubboProviderException
     */
    Page getPageByUserGroupId(Page page) throws DubboProviderException;

    /**
     * 批量添加指定用户组下的用户--dengyun.le
     *
     * @param groupId
     * @param userIds
     * @throws DubboProviderException
     */
    void saveGroupAuthBatch(String groupId, List<String> userIds) throws DubboProviderException;

    /**
     * 批量删除指定用户组下的用户--dengyun.le
     *
     * @param groupId
     * @param userIds
     * @throws DubboProviderException
     */
    public void deleteByGroupIdAndUserIds(String groupId, List<String> userIds) throws DubboProviderException;

    /**
     * 查询指定部门下不属于指定用户组的所有用户
     *
     * @param user
     * @return
     */
    List<User> getAssignableUsers(User user) throws DubboProviderException;

    public boolean updateDelete(String id,String isDelete)throws DubboProviderException;

    /**
     * 用户登录验证
     *
     * @param userLogin
     * @return
     */
    Map<String, Object> login(UserLogin userLogin) throws DubboProviderException;

    /**
     * validate并更新缓存数据
     * @param userLogin
     * @return
     * @throws DubboProviderException
     */
    Map<String, Object> validate(UserLogin userLogin) throws DubboProviderException;

    /**
     * 工作站用户登录鉴权
     *
     * @param userProcess
     * @return
     */
    JsonViewObject auth(UserProcess userProcess) throws DubboProviderException;

    /**
     * 设备登录验证
     *
     * @param userProcess
     * @return
     */
    JsonViewObject authDevice(UserProcess userProcess);

    /**
     * 工作站validate并更新缓存数据
     * @param userProcess
     * @return
     * @throws DubboProviderException
     */
    JsonViewObject stationValidate(UserProcess userProcess) throws DubboProviderException;

    /**
     * 工作站validate并更新缓存数据
     *
     * @return
     * @throws DubboProviderException
     */
    JsonViewObject switchStation(UserProcess userProcess) throws DubboProviderException;

    /**
     * 删除所有数据
     */
    void deleteAll();

    /**
     * 删除所有用户部门关联数据
     */
    void deleteAllUserDept();


    /**
     * 获取工单信息
     * @param workOrderId
     * @param produceProcessId
     * @return
     * @throws DubboProviderException
     */
    public Map<String, Object> getOrderInfo(String workOrderId, String produceProcessId, String processName) throws DubboProviderException;
}
