package com.mes.control.activiti.impl;

import com.mes.common.framework.Exception.WorkFlowException;
import com.mes.control.activiti.IWorkFlowAdapter;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by huwanshan on 2017/6/15.
 */
public class WorkFlowAdapterImpl extends ActivitiBean implements IWorkFlowAdapter {
    private static Logger log = Logger.getLogger(WorkFlowAdapterImpl.class);
    private final String ACTIVITI_PREFIX = ".bpmn20.xml";

    /**
     * 流程部署
     *
     * @param wfXml  流程xml
     * @param wfName 流程名称
     * @param wfCode
     * @return
     * @throws WorkFlowException
     */
    @Override
    public String deploymentWorkFlow(String wfXml, String wfName, String wfCode) throws WorkFlowException {
        String deployId = "";
        try {
            Deployment deployment = ActivitiBean.getProcessEngine().getRepositoryService()//与流程定义和部署对象相关的Service
                    .createDeployment()//创建一个部署对象
                    .addString(wfCode + ACTIVITI_PREFIX, wfXml)
                    .name(wfName)//添加部署的名称
                    .deploy();//完成部署
            deployId = deployment.getId();
            log.info("流程名称：【" + wfName + "】 流程Key：【" + wfCode + "】部署成功！");
        } catch (Exception e) {
            throw new WorkFlowException("流程名称：【" + wfName + "】 流程Key：【" + wfCode + "】部署失败！", e);
        }
        return deployId;
    }

    @Override
    public ProcessInstance startWorkFlow(String key) {
        return null;
    }

    @Override
    public ProcessInstance startWorkFlow(String key, Map<String, Object> variables) {
        //流程定义的key
        String processDefinitionKey = key;
        ProcessInstance pi = this.getProcessEngine().getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
        return pi;
    }

    @Override
    public boolean deleteWorkFlow(String deploymentId) {
        boolean flag = false;
        try {
            this.getProcessEngine().getRepositoryService().deleteDeployment(deploymentId, true);
            flag = true;
        } catch (Exception e) {
            log.error("删除流程失败！", e);
        }
        return flag;
    }

    @Override
    public boolean deleteWorkFlowForKey(String key) {
        boolean flag = false;
        try {
            //流程定义的key
            String processDefinitionKey = key;
            //先使用流程定义的key查询流程定义，查询出所有的版本
            List<ProcessDefinition> list = this.getProcessEngine().getRepositoryService()//
                    .createProcessDefinitionQuery()//
                    .processDefinitionKey(processDefinitionKey)//使用流程定义的key查询
                    .list();
            //遍历，获取每个流程定义的部署ID
            if (list != null && list.size() > 0) {
                for (ProcessDefinition pd : list) {
                    //获取部署ID
                    String deploymentId = pd.getDeploymentId();
                    this.getProcessEngine().getRepositoryService()//
                            .deleteDeployment(deploymentId, true);
                }
            }
            flag = true;
        } catch (Exception e) {
            log.error("删除流程失败！", e);
        }
        return flag;
    }

    @Override
    public List<ProcessDefinition> getWorkFlowList() {
        return null;
    }

    @Override
    public ProcessDefinition lastVersionWorkFlow(String key) {
        return null;
    }

    @Override
    public void getWorkFlowStatus(String processInstanceId) {

    }

    @Override
    public boolean isEnd(String processDefinitionKey) {
        boolean flag = true;


        String deploymentId = "";
        ProcessDefinition ProcessDefinition = this.getProcessEngine().getRepositoryService().
                createProcessDefinitionQuery()//
                .deploymentId(deploymentId).singleResult();
        processDefinitionKey = ProcessDefinition.getKey();

        String aa = "";

//

//        String processDefinitionKey = "helloworld";
//        ProcessInstance pi = this.getProcessEngine().getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
//                .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
//        System.out.println("流程实例ID:"+pi.getId());//流程实例ID    101
//
//
//
//
//        ProcessInstance pi = this.getProcessEngine().getRuntimeService()//表示正在执行的流程实例和执行对象
//                .createProcessInstanceQuery()//创建流程实例查询
//                .processInstanceId(processInstanceId)//使用流程实例ID查询
//                .singleResult();
//        if(pi!=null){
//            //流程没有结束
//            flag = false;
//        }
        //流程定义的key
        ProcessInstance pi = this.getProcessEngine().getRuntimeService()
                .startProcessInstanceByKey(processDefinitionKey);
        log.info("流程实例ID:" + pi.getId());//流程实例ID    101
        log.info("流程定义ID:" + pi.getProcessDefinitionId());

        /**判断流程是否结束，查询正在执行的执行对象表*/
        ProcessInstance rpi = this.getProcessEngine().getRuntimeService()//
                .createProcessInstanceQuery()
                .processInstanceId(pi.getId())
                .singleResult();
        //说明流程实例结束了
        if (rpi == null) {
            /**查询历史，获取流程的相关信息*/
            HistoricProcessInstance hpi = this.getProcessEngine().getHistoryService()//
                    .createHistoricProcessInstanceQuery()//
                    .processInstanceId(pi.getId())//使用流程实例ID查询
                    .singleResult();
            log.info(hpi.getId() + "    " + hpi.getStartTime() + "   " + hpi.getEndTime() + "   " + hpi.getDurationInMillis());
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public Map<String, Object> getVariables(String taskId) {
        TaskService taskService =  this.getProcessEngine().getTaskService();
        //任务ID
        Map<String,Object> map = (Map<String, Object>) taskService.getVariable(taskId, "variables");
        return map;
    }

    @Override
    public void setVariables(String taskId, Map<String, Object> variables) {
//        RuntimeService runtimeService = this.getProcessEngine().getRuntimeService();
//        runtimeService.setVariables(executionId, variables);//表示使用执行对象ID，和Map集合设置流程变量，map集合的key就是流程变量的名称，map集合的value就是流程变量的值（一次设置多个值）

        /**与任务（正在执行）*/
        TaskService taskService =  this.getProcessEngine().getTaskService();
        taskService.setVariables(taskId, variables);//表示使用任务ID，和Map集合设置流程变量，map集合的key就是流程变量的名称，map集合的value就是流程变量的值（一次设置多个值）

    }
}
