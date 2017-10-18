package com.mes.control.utils;

import com.google.common.collect.Maps;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * 获取流程参数
 */
public class InitWfPara {
    private static Logger log4j = Logger.getLogger(InitWfPara.class);
    public static InitWfPara initWfPara;

    public synchronized static InitWfPara getInitWfPara() {

        if (initWfPara == null) {
            initWfPara = new InitWfPara();
        }
        return initWfPara;
    }

    public Map<String, Object> getPara(Map<String, Object> map) throws Exception {
        Map<String, Object> mapPara = Maps.newHashMap();
        try {

        } catch (Exception e) {
            log4j.error("获取流程参数失败！", e);
            throw new RuntimeException("获取流程参数失败！");
        }

        return mapPara;
    }


}
