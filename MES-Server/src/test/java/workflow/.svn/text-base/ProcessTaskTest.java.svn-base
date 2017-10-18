package workflow;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.WorkFlowException;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.function.FunctionParameter;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.task.Task;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bo.zhou1 on 2017/9/20.
 */
public class ProcessTaskTest {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    public List<Map<String, Object>> getNextTaskInfo() throws WorkFlowException {

        String processInstanceId = "100033";
        //根据流程实例ID获取流程定义ID，得到流程定义实例
        String definitionId = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) processEngine.getRepositoryService())
                .getDeployedProcessDefinition(definitionId);

        //根据流程实例ID获取当前正在执行信息,得到当前节点信息
        ExecutionEntity execution = (ExecutionEntity) processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        String activitiId = execution.getActivityId();

        //获取流程所有节点信息
        List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();
        List<PvmTransition> outTransitions = null;
        ActivityImpl repairStation = null;
        //遍历所有节点信息,获取当前节点信息(这里是维修站)
        for (ActivityImpl activityImpl : activitiList) {
            if (activitiId.equals(activityImpl.getId())) {
                repairStation = activityImpl;
                break;
            }
        }
        //获取维修站下一个节点连线
        List<PvmTransition> repairStationOuts = null;
        for (ActivityImpl activityImpl : activitiList) {
            if (repairStation.getId().equals(activityImpl.getId())) {
                repairStationOuts = activityImpl.getOutgoingTransitions();
            }
        }
        //如果维修站出口只有一个则获取出口网关的目标连线
        if (!repairStationOuts.isEmpty() && repairStationOuts.size() == 1) {
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
            node.put("conditionText", ((String) outTransition.getProperty("conditionText")).split("'")[1]);
            result.add(node);
        }
        return result;
    }

    @Test
    public void completeTask() {
        String processInstanceId = "152987";
        Task task = processEngine.getTaskService()//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询对象
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .orderByTaskCreateTime().asc()//使用创建时间的升序排列
                .singleResult();//返回惟一结果集

        Map<String, Object> variables = Maps.newHashMap();
        variables.put("message", "Y");
        processEngine.getTaskService()//与正在执行的任务管理相关的Service
                .complete(task.getId(), variables);
    }

    @Test
    public void currentTask() {
        String processInstanceId = "153290";
        //根据流程实例ID获取流程定义ID，得到流程定义实例
        String definitionId = "";
        if (processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult() != null) {
            definitionId = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();
            ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) processEngine.getRepositoryService())
                    .getDeployedProcessDefinition(definitionId);

            //根据流程实例ID获取当前正在执行信息,得到当前节点信息
            ExecutionEntity execution = (ExecutionEntity) processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            String activitiId = execution.getActivityId();

            //获取流程所有节点信息
            List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();
            ActivityImpl currentTask = null;
            //遍历所有节点信息,获取当前节点信息(这里是维修站)
            for (ActivityImpl activityImpl : activitiList) {
                if (activitiId.equals(activityImpl.getId())) {
                    currentTask = activityImpl;
                    break;
                }
            }
            Map<String, Object> stringObjectMap = currentTask.getProperties();
            System.out.println("当前工序任务名称:" + stringObjectMap.get("name"));
        } else {
            System.out.println("产品任务完毕");
        }
    }

    @Test
    public void NextTest() throws WorkFlowException {
        List<Map<String, Object>> result = this.getNextTaskInfo();
        for (Map<String, Object> stringObjectMap : result) {
            Set<String> resultSet = stringObjectMap.keySet();
            System.out.println("=========================");
            for (String s : resultSet) {
                System.out.println(s + ":" + stringObjectMap.get(s));
            }
        }
    }

    @Test
    public void ExpressTest() throws ScriptException {
        Long spendTime = 10000000L;
        Long standard = 200000000000L;
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("groovy");
        String experession = spendTime + "<" + standard;
        boolean result;
        result = (Boolean) se.eval(experession);
        System.out.println(result);
    }

    @Test
    public void ScriptTest() throws ScriptException {
        String script = "return true;";
        FunctionParameter parameter = new FunctionParameter();
        parameter.setStatus("0");
        boolean result = (boolean) GroovyUtil.evalScript(script, parameter);
        String status = result + "";

    }
}
