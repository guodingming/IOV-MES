package com.mes.control.activiti;

import com.mes.control.activiti.impl.HistoricAdapterImpl;
import com.mes.control.activiti.impl.TaskAdapterImpl;
import com.mes.control.activiti.impl.VariablesAdapterImpl;
import com.mes.control.activiti.impl.WorkFlowAdapterImpl;

/**
 * Created by huwanshan on 2017/6/15.
 */
public class ActivitiAbstractFactory {


    private static ActivitiAbstractFactory instance;

    public synchronized static ActivitiAbstractFactory getInstance() {
        if (instance == null) {
            instance = new ActivitiAbstractFactory();
        }
        return instance;
    }

    /**
     * 流程管理
     * @return
     */
    public IWorkFlowAdapter getWorkFlowAdapter(){
        return new WorkFlowAdapterImpl();
    }


    /**
     * task 任务
     * @return
     */
    public ITaskAdapter getTaskAdapter(){
        return new TaskAdapterImpl();
    }

    /**
     * 流程参数
     * @return
     */
    public IVariablesAdapter getVariablesAdapter(){
        return new VariablesAdapterImpl();
    }


    /**
     * 流程历史数据查询
     * @return
     */
    public IHistoricAdapter getHistoricAdapter(){
        return new HistoricAdapterImpl();
    }


}
