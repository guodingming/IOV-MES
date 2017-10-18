package com.mes.control.activiti.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.WorkFlowException;
import com.mes.control.activiti.ITaskAdapter;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by huwanshan on 2017/6/15.
 */
public class TaskAdapterImpl implements ITaskAdapter {
    private static Logger log = Logger.getLogger(TaskAdapterImpl.class);

    /**
     * 获取流程当前节点需要的任务
     *
     * @param processDefinitionId 流程定义ID    helloworld:1:4
     * @param taskName            任务名称
     * @param taskDefinitionKey   任务KEY
     * @return
     * @throws WorkFlowException
     */
    @Override
    public List<Task> findWorkFlowCurrentTaskList(String processDefinitionId, String taskName, String taskDefinitionKey) throws WorkFlowException {
        List<Task> list = ActivitiBean.getProcessEngine().getTaskService()//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询对象
                .processDefinitionId(processDefinitionId)//使用流程定义ID查询
                .taskName(taskName)
                .taskDefinitionKey(taskDefinitionKey)
                /**排序*/
                .orderByTaskCreateTime().asc()//使用创建时间的升序排列
                .list();//返回列表
        if (list != null && list.size() > 0) {
            for (Task task : list) {
                log.debug("任务ID:" + task.getId());
                log.debug("任务名称:" + task.getName());
                log.debug("任务的创建时间:" + task.getCreateTime());
                log.debug("任务的办理人:" + task.getAssignee());
                log.debug("流程实例ID：" + task.getProcessInstanceId());
                log.debug("执行对象ID:" + task.getExecutionId());
                log.debug("流程定义ID:" + task.getProcessDefinitionId());
                log.debug("########################################################");
            }
        }
        return list;
    }

    /**
     * 获取流程需要执行的所有节点的任务
     *
     * @param processDefinitionId 流程定义ID
     * @return
     * @throws WorkFlowException
     */
    @Override
    public List<Task> findWorkFlowTaskList(String processDefinitionId) throws WorkFlowException {
        List<Task> list = ActivitiBean.getProcessEngine().getTaskService()//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询对象
                .processDefinitionId(processDefinitionId)//使用流程定义ID查询
                .orderByTaskCreateTime().asc()//使用创建时间的升序排列
                .list();//返回列表
        return list;
    }

    /**
     * 根据流程实例ID获取任务
     *
     * @param processInstanceId 流程实例ID
     * @return
     * @throws WorkFlowException
     */
    @Override
    public Task findWorkFlowTaskByProcessInstanceId(String processInstanceId) throws WorkFlowException {
        Task task = ActivitiBean.getProcessEngine().getTaskService()//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询对象
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .orderByTaskCreateTime().asc()//使用创建时间的升序排列
                .singleResult();//返回惟一结果集
        return task;
    }

    /**
     * 任务办理
     * @param task
     * @return
     * @throws WorkFlowException
     */
    @Override
    public boolean completeTask(Task task,Map<String,Object> variables) throws WorkFlowException {
        boolean flag = false;
        if (task != null) {
            ActivitiBean.getProcessEngine().getTaskService()//与正在执行的任务管理相关的Service
                    .complete(task.getId(),variables);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Map<String, Object>> getRepairStationNextTaskInfo(String processInstanceId) throws WorkFlowException {
        //根据流程实例ID获取流程定义ID，得到流程定义实例
        String definitionId = ActivitiBean.getProcessEngine().getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) ActivitiBean.getProcessEngine().getRepositoryService())
                .getDeployedProcessDefinition(definitionId);

        //根据流程实例ID获取当前正在执行信息,得到当前节点信息
        ExecutionEntity execution = (ExecutionEntity) ActivitiBean.getProcessEngine().getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        String activitiId = execution.getActivityId();

        //获取流程所有节点信息
        List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();
        List<PvmTransition> outTransitions = null;
        ActivityImpl repairStation = null;
        //遍历所有节点信息,获取当前节点信息(这里是维修站)
        for(ActivityImpl activityImpl : activitiList){
            if (activitiId.equals(activityImpl.getId())) {
                repairStation = activityImpl;
                break;
            }
        }
        //获取维修站下一个节点连线
        List<PvmTransition> repairStationOuts = null;
        for(ActivityImpl activityImpl : activitiList){
            if (repairStation.getId().equals(activityImpl.getId())) {
                repairStationOuts = activityImpl.getOutgoingTransitions();
            }
        }
        //如果维修站出口只有一个则获取出口网关的目标连线
        if (!repairStationOuts.isEmpty() && repairStationOuts.size() ==1){
            //获取网关节点
            PvmActivity exclusiveGateway = repairStationOuts.get(0).getDestination();
            //获取排他网关出口连线
            outTransitions = exclusiveGateway.getOutgoingTransitions();
        }

        List<Map<String, Object>> result = Lists.newArrayList();
        for (PvmTransition outTransition : outTransitions) {
            PvmActivity sourceNode = outTransition.getSource();
            PvmActivity destination = outTransition.getDestination();
            Map<String, Object> node = Maps.newHashMap();
            node.put("sourceNodeName", sourceNode.getProperty("name"));
            node.put("destinationNodeName", destination.getProperty("name"));
            node.put("condition", ((String) outTransition.getProperty("conditionText")).split("'")[1]);
            result.add(node);
        }
        return result;
    }
}
