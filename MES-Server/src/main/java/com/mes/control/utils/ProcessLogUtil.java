package com.mes.control.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.dubbo.interprovider.control.*;
import com.mes.entity.control.*;
import org.apache.log4j.lf5.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 工序日志工具类
 * <p>
 * Created by xiuyou.xu on 2017/9/24.
 */
public class ProcessLogUtil {
    private static Logger logger = LoggerFactory.getLogger(ProcessLogUtil.class);

    private static IPdWorkOrderProvider pdWorkOrderProvider = (IPdWorkOrderProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderProvider");
    private static IDpProduceProcessProvider dpProduceProcessProvider = (IDpProduceProcessProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessProvider");
    private static IPdLineProvider pdLineProvider = (IPdLineProvider) ServiceBeanContext.getInstance().getBean("pdLineProvider");
    private static IPdProvider pdProvider = (IPdProvider) ServiceBeanContext.getInstance().getBean("pdProvider");
    private static IFtyProcessProvider ftyProcessProvider = (IFtyProcessProvider) ServiceBeanContext.getInstance().getBean("ftyProcessProvider");

    public static void log(LogLevel logLevel, String barCode, String workOrderNum, String produceProcessId, String content) {
        ProcessLog processLog = new ProcessLog();
        if (logLevel == LogLevel.DEBUG) {
            processLog.setLevel("debug");
        }
        if (logLevel == LogLevel.INFO) {
            processLog.setLevel("info");
        }
        if (logLevel == LogLevel.WARN) {
            processLog.setLevel("warn");
        }
        if (logLevel == LogLevel.ERROR) {
            processLog.setLevel("error");
        }
        processLog.setBarCode(barCode);

        try {
            if (workOrderNum != null && !workOrderNum.isEmpty()) {
                Map<String, Object> map = Maps.newHashMap();
                map.put("workOrderNum", workOrderNum);
                List<PdWorkOrder> pdWorkOrders = pdWorkOrderProvider.findByMap(map);
                if (pdWorkOrders != null && !pdWorkOrders.isEmpty()) {
                    PdWorkOrder pdWorkOrder = pdWorkOrders.get(0);
                    DpProduceProcess dpProduceProcess = dpProduceProcessProvider.findById(produceProcessId);
                    PdLine pdLine = pdLineProvider.findById(dpProduceProcess.getPdLineId());
                    Pd pd = pdProvider.findById(dpProduceProcess.getPdId());
                    FtyProcess ftyProcess = ftyProcessProvider.findById(dpProduceProcess.getProcessId());

                    processLog.setContent(content);
                    processLog.setPdLineId(pdLine.getId());
                    processLog.setPdLineName(pdLine.getName());
                    processLog.setPdId(pd.getId());
                    processLog.setPdName(pd.getName());
                    processLog.setProcessId(ftyProcess.getId());
                    processLog.setProcessName(ftyProcess.getName());
                    processLog.setProcessId(ftyProcess.getId());
                    processLog.setWorkOrderNum(pdWorkOrder.getWorkOrderNum());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    processLog.setTime(sdf.format(new Date()));
                }
            }
        } catch (DubboProviderException e) {
            e.printStackTrace();
        }
        String log = JSON.toJSONString(processLog);

        logger.info(log);
    }
}
