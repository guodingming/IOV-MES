package com.mes.common.function;

import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Map;

/**
 * 基础
 */
public abstract class BaseCall implements java.io.Serializable {

    private static Logger log = Logger.getLogger(BaseCall.class);


    /**
     * 执行
     *
     * @param functionParameter
     */
    public abstract FunctionParameter actionCall(FunctionParameter functionParameter) throws Exception;


    /**
     * 设置插件日志
     *
     * @param workFlowParameter
     * @param logMapLis
     */
    public void setLog(FunctionParameter workFlowParameter, Collection<Map> logMapLis) {
        Map<String, Object> response = workFlowParameter.getResponseMap();
    }


    /**
     * 执行前回调方法
     */
    public void berforeRun(FunctionParameter workFlowParameter) throws Exception {
    }

    /**
     * 执行后回调方法
     */
    public void afterRun(FunctionParameter workFlowParameter) throws Exception {
    }

}
