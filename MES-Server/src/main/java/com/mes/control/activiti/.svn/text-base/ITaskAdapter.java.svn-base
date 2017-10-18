package com.mes.control.activiti;

import com.mes.common.framework.Exception.WorkFlowException;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * 流程任务
 * task
 * Created by huwanshan on 2017/6/15.
 */
public interface ITaskAdapter {

    /**
     *  获取流程当前节点正在这行的任务
     * @param processDefinitionId 流程定义ID    helloworld:1:4
     * @param taskName           任务名称
     * @param taskDefinitionKey 任务KEY
     * @return
     * @throws WorkFlowException
     */
    public List<Task> findWorkFlowCurrentTaskList(String processDefinitionId, String taskName, String taskDefinitionKey) throws WorkFlowException;


    /**
     * 获取流程需要执行的所有节点的任务
     * @param processDefinitionId 流程定义ID
     * @return
     * @throws WorkFlowException
     */
    public List<Task> findWorkFlowTaskList(String processDefinitionId) throws WorkFlowException;


    /**
     * 根据流程实例ID查找task
     * @param processInstanceId 流程实例ID
     * @return
     * @throws WorkFlowException
     */
    public Task findWorkFlowTaskByProcessInstanceId(String processInstanceId) throws WorkFlowException;


    /**
     * 任务办理
     * @param task
     * @return
     * @throws WorkFlowException
     */
    public boolean completeTask(Task task,Map<String,Object> variables) throws WorkFlowException;

    /**
     * 获取维修站出口工序信息
     *
     * @param processInstanceId
     * @return
     * @throws WorkFlowException
     */
    public List<Map<String, Object>> getRepairStationNextTaskInfo(String processInstanceId) throws WorkFlowException;

}
