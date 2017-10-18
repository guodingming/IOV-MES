package com.mes.control.workflow;


import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.log4j.Logger;

/**
 * com.mes.control.function.TaskListenerImpl
 * Created by huwanshan on 2017/6/14.
 */
public class TaskListenerImpl implements TaskListener {
    private static Logger log = Logger.getLogger(TaskListenerImpl.class);

    /**
     * 用来指定任务的办理人
     */
    @Override
    public void notify(DelegateTask delegateTask) {

        /**
         * 1、可以在这个监听中执行脚本，业务逻辑
         * 2、参数传递
         */
        log.info("TaskListener-----------------TaskListenerImpl------------------");
        System.out.println("TaskListener-----------------TaskListenerImpl------------------");

    }
}
