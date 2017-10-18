package com.mes.control.workflow;

import com.mes.common.function.FunctionParameter;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;


/**
 * 插件基类
 */
public abstract class PluginActionHandler implements JavaDelegate {
    private static Logger log = Logger.getLogger(PluginActionHandler.class);



    @Override
    public void execute(DelegateExecution context) throws Exception {
        FunctionParameter message = new FunctionParameter();
        try {
            //流程插件参数
            this.getPluginPara(message, context);
            //运行节点之前设置参数
            this.nodeRunBefore(message, context);
            //执行节点插件
            message = this.startPlugin(message);
            //执行后设置相关信息
            this.nodeRunAfter(message, context);
        } catch (Exception e) {
            log.error("WorkFlow Node Run error!", e);
            throw new Exception(e.getMessage(), e);
        } finally {
            //写插件运行日志
            this.sendLog(message);
        }
    }

    /**
     * 启动插件
     *
     * @param workFlowParameter
     * @return
     */
    public FunctionParameter startPlugin(FunctionParameter workFlowParameter) throws Exception {
        FunctionParameter rtnMsg = null;
        return rtnMsg;

    }


    /**
     * 获取流程节点参数
     *
     * @param context
     * @return
     */
    private void getPluginPara(FunctionParameter message, DelegateExecution context) throws Exception {
        String activityId = context.getCurrentActivityId();
    }


    /**
     * 记录日志
     */
    private void sendLog(FunctionParameter message) {
        try {

        } catch (Exception e) {
            log.error("send plugin log is error！", e);
            e.printStackTrace();
        }
    }


    /**
     * 抽象方法，每个插件必须实现,   node运行之前需要给节点设置参数
     *
     * @param context
     */
    public abstract void nodeRunBefore(FunctionParameter message, DelegateExecution context) throws Exception;

    /**
     * 抽象方法，每个插件必须实现    node运行之后  将节点返回值   给流程再进行处理
     *
     * @param context
     */
    public abstract void nodeRunAfter(FunctionParameter message, DelegateExecution context) throws Exception;

}
