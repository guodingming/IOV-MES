package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.UserProcess;
import com.sun.java.browser.dom.DOMUnsupportedException;

import java.util.List;

/**
 * 用户管理-人员技能
*/
public interface IUserProcessProvider extends DubboBaseInterface<UserProcess> {

    /**
     * 根据用户的工程查询工序
     *
     * @param userProcess
     * @return
     * @throws DubboProviderException
     */
    public List<UserProcess> findProcessByUserAndProject(UserProcess userProcess) throws DubboProviderException;

    /**
     * 更新用户技能授权状态
     *
     * @param processStatus
     * @param id
     * @return
     * @throws DubboProviderException
     */
    public boolean updateStatus(String processStatus, String id) throws DubboProviderException;

    /**
     * 更新用户技能授权时间
     * @param userProcess
     * @return
     * @throws DOMUnsupportedException
     */
    public boolean updateAuthTime(UserProcess userProcess) throws DubboProviderException;

    /**
     * 配置用户业务
     *
     * @param userProcess
     * @return
     * @throws DubboProviderException
     */
    public boolean configProcess(UserProcess userProcess) throws DubboProviderException;
}
