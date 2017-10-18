package com.mes.control.activiti;

import com.mes.common.framework.Exception.WorkFlowException;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;
import java.util.Map;

/**
 * Created by huwanshan on 2017/6/15.
 */
public interface IWorkFlowAdapter {

    /**
     * 部署流程
     * @param wfXml   流程xml
     * @param wfName   流程名称
     * @return
     */
    public String deploymentWorkFlow(String wfXml,String wfName,String wfCode) throws WorkFlowException;

    /**
     * 启动流程
     * @param key
     * @return
     */
    public ProcessInstance startWorkFlow(String key);

    /**
     * 启动流程
     * @param key   流程key
     * @param variables  流程启动参数
     */
    public ProcessInstance startWorkFlow(String key, Map<String, Object> variables);


    /**
     * 部署ID删除已经部署的流程
     * @param deploymentId
     * @return
     */
    public boolean deleteWorkFlow(String deploymentId);


    /**
     * 根据流程的key删除所有版本的流程
     * @param key
     * @return
     */
    public boolean deleteWorkFlowForKey(String key);


    /**
     * 获取所有的流程
     */
    public List<ProcessDefinition> getWorkFlowList();


    /**
     * 获取最新版本的流程
     */
    public ProcessDefinition lastVersionWorkFlow(String key);


    /**
     * 获取流程状态
     * @param processInstanceId   流程实例
     */
    public void getWorkFlowStatus(String processInstanceId);


    /**
     * 判断流程是否运行结束
     * @param processDefinitionKey   流程key
     * @return
     */
    public boolean isEnd(String processDefinitionKey);

    /**
     * 获取任务办理参数
     * @param taskId
     * @return
     */
    public Map<String,Object> getVariables(String taskId);


    /**
     * 流程参数设置
     * @param taskId
     * @param variables
     */
    public void setVariables(String taskId,Map<String,Object> variables);


}
