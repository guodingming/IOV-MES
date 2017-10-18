package com.mes.control.activiti.impl;



import com.mes.common.framework.spring.ServiceBeanContext;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by huwanshan on 2017/6/15.
 */
public class ActivitiBean {

    private static final Logger log = LoggerFactory.getLogger(ActivitiBean.class);

    /**
     * ProcessEngine
     * @return
     */
    public static ProcessEngine getProcessEngine(){
        ProcessEngine processEngine = null;
        try {
            processEngine =  (ProcessEngine) ServiceBeanContext.getInstance().getBean("processEngine");
        } catch (Exception e) {
            log.error("ProcessEngine初始化失败！",e);
        }
        return  processEngine;
    }

    /**
     * RepositoryService
     * @return
     */
    public  static RepositoryService getRepositoryService(){
        RepositoryService repositoryService = null;
        try {
            repositoryService =  (RepositoryService) ServiceBeanContext.getInstance().getBean("repositoryService");
        } catch (Exception e) {
            log.error("RepositoryService初始化失败！",e);
        }
        return  repositoryService;
    }

    /**
     * RuntimeService
     * @return
     */
    public static RuntimeService getRuntimeService(){
        RuntimeService runtimeService = null;
        try {
            runtimeService =  (RuntimeService) ServiceBeanContext.getInstance().getBean("runtimeService");
        } catch (Exception e) {
            log.error("RuntimeService初始化失败！",e);
        }
        return  runtimeService;
    }

//    /**
//     * function
//     * @return
//     */
//    public static IWorkFlow getWorkFlow(){
//        IWorkFlow workFlow = null;
//        try {
//            workFlow =  (WorkFlowImpl) ServiceBeanContext.getInstance().getBean("activitiWorkFlowService");
//        } catch (Exception e) {
//            log.error("IWorkFlow初始化失败！",e);
//        }
//        return  workFlow;
//    }

}
