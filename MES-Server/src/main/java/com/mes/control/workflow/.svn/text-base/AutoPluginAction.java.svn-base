package com.mes.control.workflow;

import com.mes.common.function.FunctionParameter;
import org.activiti.engine.delegate.DelegateExecution;
import org.apache.log4j.Logger;

/**

 * Created by huwanshan
 */
public class AutoPluginAction extends PluginActionHandler {
    private static Logger log = Logger.getLogger(PluginActionHandler.class);

    @Override
    public void nodeRunBefore(FunctionParameter message, DelegateExecution context) throws Exception {
        log.info("nodeRunBefore---------------AutoPluginAction--------------------");
        System.out.println("nodeRunBefore---------------AutoPluginAction--------------------");

    }

    @Override
    public void nodeRunAfter(FunctionParameter message, DelegateExecution context) throws Exception {
        log.info("nodeRunAfter-----------------AutoPluginAction------------------");
        System.out.println("nodeRunAfter---------------nodeRunAfter--------------------");
    }
}
