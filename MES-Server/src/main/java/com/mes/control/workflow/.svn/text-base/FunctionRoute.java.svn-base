package com.mes.control.workflow;

import com.mes.common.function.FunctionConstants;
import com.mes.common.function.FunctionParameter;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

/**
 * Created by hudaowan on 2015/4/22.
 * 流程插件的路由actor
 */
public class FunctionRoute {
    private static Logger log = Logger.getLogger(FunctionRoute.class);

    /**
     *
     * @param message
     * @param classLoader
     * @return
     */
    public static FunctionParameter onReceive(Object message, ClassLoader classLoader) throws Exception {
        FunctionParameter functionParameter = null;
        try {
            functionParameter = (FunctionParameter) message;
            doAction(functionParameter, classLoader);
        } catch (Exception e) {
            throw e;
        }
        return functionParameter;
    }


    public static FunctionParameter doAction(FunctionParameter functionParameter, ClassLoader classLoader) throws Exception {
        try {
            String functionClass = (String) functionParameter.getRequestMap().get(FunctionConstants.parameter.CLASS);
            if (functionClass != null) {
                //真正执行插件
                Class<?> classType = Class.forName(functionClass, false, classLoader);
                Object invokeIgnitePlugin = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
                //获取Plugin类的actionCall()方法
                Method actionCallMethod = classType.getMethod("actionCall", new Class[]{FunctionParameter.class});
                //调用Plugin对象上的actionCall()方法
                functionParameter = (FunctionParameter) actionCallMethod.invoke(invokeIgnitePlugin, new Object[]{functionParameter});
            }
        } catch (Exception e) {
            throw e;
        } finally {
            //将服务处理完成之后的结果信息返回给流程
            log.info("[Plugin-RUN] 将插件的返回结果发回给流程>>>");
        }
        return functionParameter;
    }


}
