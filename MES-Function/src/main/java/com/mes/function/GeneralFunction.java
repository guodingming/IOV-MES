package com.mes.function;

import com.google.common.collect.Maps;
import com.mes.common.function.BaseCall;
import com.mes.common.function.FunctionParameter;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * com.mes.function.GeneralFunction
 *  通用函数
 */
public class GeneralFunction extends BaseCall {
    private static Logger log = Logger.getLogger(BaseCall.class);


    @Override
    public FunctionParameter actionCall(FunctionParameter functionParameter) throws Exception {
        /**
         * 1:成功；0失败
         */
        Map<String,Object> map = Maps.newHashMap();
        String status = functionParameter.getStatus();
        if ("1".equals(status)){
            map.put("message","Y");
        }else {
            map.put("message","N");
        }
        functionParameter.getResponseMap().putAll(map);
        return functionParameter;
    }


}
