package com.mes.control.utils;

import com.mes.common.framework.Exception.WorkFlowException;
import com.mes.control.activiti.ActivitiAbstractFactory;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * 工作流管理
 * Created by wanshan.hu on 2017/7/28.
 */
public class WorkFlowAdapter {
    private static Logger log = Logger.getLogger(WorkFlowAdapter.class);
    private static WorkFlowAdapter instance;

    private WorkFlowAdapter() {
    }

    public static WorkFlowAdapter getInstance() {
        if (instance == null) {
            synchronized (WorkFlowAdapter.class) {
                if (instance == null) {
                    instance = new WorkFlowAdapter();
                }
            }
        }
        return instance;
    }


    /**
     * 部署
     *
     * @param wfXml
     * @param wfName
     * @param wfCode
     * @return
     * @throws Exception
     */
    public String deployWorkFlow(String wfXml, String wfName, String wfCode) throws Exception {
        String deployId = null;
        try {
            deployId = ActivitiAbstractFactory.getInstance().getWorkFlowAdapter().deploymentWorkFlow(wfXml, wfName, wfCode);
        } catch (Exception e) {
            log.error("流程部署失败！", e);
        }

        return deployId;
    }

    /**
     * 取消部署
     *
     * @return
     * @throws Exception
     */
    public boolean unDeployWorkFlowByDeploymentId(String deploymentId) throws Exception {
        return ActivitiAbstractFactory.getInstance().getWorkFlowAdapter().deleteWorkFlow(deploymentId);
    }

    /**
     * 取消部署
     *
     * @return
     * @throws Exception
     */
    public boolean unDeployWorkFlowByCode(String key) throws Exception {
        return ActivitiAbstractFactory.getInstance().getWorkFlowAdapter().deleteWorkFlowForKey(key);
    }


    /**
     * 启动生产产品任务
     *
     * @param wfCode 工艺流程Code
     */
    public String startWorkFlow(String wfCode, Map<String, Object> map) throws Exception {
        String instanceId = null;
        try {
            ProcessInstance processInstance = ActivitiAbstractFactory.getInstance().getWorkFlowAdapter().startWorkFlow(wfCode, map);
            //流程实例ID
            instanceId = processInstance.getId();
        } catch (Exception e) {
            log.error("启动生产任务失败！", e);
        }
        return instanceId;

    }


    /**
     * 获取当前节点下需要待办的任务
     *
     * @throws Exception
     */
    public List<Task> getNodeTaskList(String processDefinitionId, String taskName, String taskDefinitionKey) throws Exception {
        List<Task> list = null;
        try {
            list = ActivitiAbstractFactory.getInstance().getTaskAdapter().findWorkFlowCurrentTaskList(processDefinitionId, taskName, taskDefinitionKey);
        } catch (Exception e) {
            log.error("获取当前节点下需要待办的任务失败！", e);
        }
        return list;
    }

    /**
     * 根据流程实例ID获取任务
     *
     * @param processInstanceId
     * @return
     * @throws WorkFlowException
     */
    public Task findWorkFlowTaskByProcessInstanceId(String processInstanceId) throws WorkFlowException {
        return ActivitiAbstractFactory.getInstance().getTaskAdapter().findWorkFlowTaskByProcessInstanceId(processInstanceId);
    }

    /**
     * 获取流程参数
     * @param taskId
     * @return
     * @throws WorkFlowException
     */
    public Map<String, Object> getVariables(String taskId) throws WorkFlowException {
        return ActivitiAbstractFactory.getInstance().getWorkFlowAdapter().getVariables(taskId);

    }

    /**
     * 获取流程参数
     * @param taskId
     * @throws WorkFlowException
     */
    public void setVariables(String taskId,Map<String,Object> variables) throws WorkFlowException {
        ActivitiAbstractFactory.getInstance().getWorkFlowAdapter().setVariables(taskId,variables);
    }

    /**
     * 任务办理
     *
     * @param processInstanceId 流程实例ID
     * @return
     * @throws WorkFlowException
     */
    public boolean completeTask(String processInstanceId,Map<String,Object> variables) throws WorkFlowException {
        boolean flag = false;
        try {
            Task task = this.findWorkFlowTaskByProcessInstanceId(processInstanceId);
            flag = ActivitiAbstractFactory.getInstance().getTaskAdapter().completeTask(task,variables);
        } catch (Exception e) {
            log.error("执行办理任务失败！", e);
        }
        return flag;
    }

    public boolean completeTaskByTaskId(Task task,Map<String,Object> variables) throws WorkFlowException {
        boolean flag = false;
        try {
            flag = ActivitiAbstractFactory.getInstance().getTaskAdapter().completeTask(task,variables);
        } catch (Exception e) {
            log.error("执行办理任务失败！", e);
        }
        return flag;
    }

    /**
     * 获取维修站出口工序信息
     *
     * @param processInstanceId
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> getRepairStationNextTaskInfo(String processInstanceId) throws Exception {
        List<Map<String, Object>> list = null;
        try {
            list = ActivitiAbstractFactory.getInstance().getTaskAdapter().getRepairStationNextTaskInfo(processInstanceId);
        } catch (Exception e) {
            log.error("获取维修站出口工序信息失败！", e);
        }
        return list;
    }


}
