package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.UserProcessMapper;
import com.mes.dubbo.interprovider.control.IUserProcessProvider;
import com.mes.entity.control.UserProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户管理-人员技能
 */
public class UserProcessProviderImpl extends BaseProviderImpl<UserProcess> implements IUserProcessProvider {
    @Autowired
    @Qualifier("userProcessMapper")
    private UserProcessMapper userProcessMapper;

    @Override
    public UserProcessMapper getBaseInterfaceMapper() {
        return userProcessMapper;
    }

    @Override
    public String save(UserProcess entity) throws DubboProviderException {
        String result = "";
        try {
            Map<String, Object> query = Maps.newHashMap();
            query.put("userId", entity.getUserId());
            query.put("processId", entity.getProcessId());
            List<UserProcess> userProcesses = userProcessMapper.findByMap(query);
            if (null != userProcesses && userProcesses.size() > 0) {
                result = "exists";
            } else {
                result = super.save(entity);
            }
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl save ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<UserProcess> findProcessByUserAndProject(UserProcess userProcess) throws DubboProviderException {
        List<UserProcess> userProcesses = Lists.newArrayList();
        try {
            Map<String, Object> query = Maps.newHashMap();
            query.put("userId", userProcess.getUserId());
            query.put("projectId", userProcess.getProjectId());
            userProcesses = this.userProcessMapper.findByUserAndProject(query);
        } catch (Exception e) {
            log.error("UserProcessProviderImpl findProcessByUserAndProject");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return userProcesses;
    }

    @Override
    public boolean updateStatus(String processStatus, String id) throws DubboProviderException {
        boolean flag = false;
        try {
            UserProcess userProcess = this.findById(id);
            userProcess.setProcessStatus(processStatus);
            flag = super.update(userProcess);
            if (processStatus.equals("1")) {
                this.updateAuthTime(userProcess);
            }
        } catch (Exception e) {
            log.error("切换用户技能状态失败");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean updateAuthTime(UserProcess userProcess) throws DubboProviderException {
        boolean flag = false;
        try {
            Date date = new Date();
            userProcess.setStartTime(date);
            Calendar now = Calendar.getInstance();
            now.setTime(date);
            now.set(Calendar.DATE, now.get(Calendar.DATE) + Integer.parseInt(ConfigHelper.getValue("user.process.auth.time")));
            userProcess.setEndTime(now.getTime());
            flag = super.update(userProcess);
        } catch (Exception e) {
            log.error("更新授权时间");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean configProcess(UserProcess userProcess) throws DubboProviderException {
        boolean flag = false;
        try {
            List<String> processIds = userProcess.getProcessIds();
            if (!processIds.isEmpty()) {
                Map<String, Object> query = Maps.newHashMap();
                query.put("userId", userProcess.getUserId());
                List<UserProcess> userProcessList = this.userProcessMapper.findByMap(query);
                for (UserProcess process : userProcessList) {
                    this.userProcessMapper.deleteById(process.getId());
                }
                for (String processId : processIds) {
                    userProcess.setProcessId(processId);
                    userProcess.setProcessStatus("0");
                    userProcess.setId(IDGenerator.getID());
                    super.save(userProcess);
                }
            }
            flag = true;
        } catch (Exception e) {
            log.error("用户配置业务失败");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }
}
