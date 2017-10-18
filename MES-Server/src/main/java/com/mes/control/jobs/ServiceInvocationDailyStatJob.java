package com.mes.control.jobs;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.control.utils.LogUtil;
import com.mes.dubbo.interprovider.control.IDpServiceMonitorProvider;
import com.mes.dubbo.interprovider.control.IDpServiceProvider;
import com.mes.entity.control.DpService;
import com.mes.entity.control.DpServiceMonitor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 统计当天服务调用情况
 * <p>
 * Created by xiuyou.xu on 2017/8/21.
 */
public class ServiceInvocationDailyStatJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取当天开始时刻
        Calendar start = Calendar.getInstance();
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        Calendar end = Calendar.getInstance();

        try {
            IDpServiceProvider dpServiceProvider = (IDpServiceProvider) ServiceBeanContext.getInstance().getBean("dpServiceProvider");
            List<DpService> services = dpServiceProvider.findAll();
            if (services != null && !services.isEmpty()) {
                IDpServiceMonitorProvider dpServiceMonitorProvider = (IDpServiceMonitorProvider) ServiceBeanContext.getInstance().getBean("dpServiceMonitorProvider");
                services.forEach(service -> {
                    Map<String, Object> params = Maps.newHashMap();
                    params.put("serviceId", service.getId());
                    params.put("periodStart", start.getTime());
                    params.put("periodType", "d");
                    try {
                        List<DpServiceMonitor> monitors = dpServiceMonitorProvider.findByMap(params);
                        if (monitors == null || monitors.isEmpty()) {
                            // 更新前一天的
                            start.add(Calendar.DATE, -1);
                            Date lastStart = start.getTime();
                            start.add(Calendar.DATE, 1);
                            Date lastEnd = start.getTime();
                            long lastSuccess = LogUtil.queryServiceInvocationStat(service.getCode(), lastStart, lastEnd, "success");
                            Map<String, Object> map = Maps.newHashMap();
                            map.put("serviceId", service.getId());
                            map.put("periodStart", lastStart);
                            map.put("periodType", "d");
                            map.put("status", 1);
                            List<DpServiceMonitor> lastSuccesses = dpServiceMonitorProvider.findByMap(map);
                            if (lastSuccesses != null && !lastSuccesses.isEmpty()) {
                                DpServiceMonitor lastSuccessMonitor = lastSuccesses.get(0);
                                lastSuccessMonitor.setCount(lastSuccess);
                                dpServiceMonitorProvider.update(lastSuccessMonitor);
                            }

                            long lastFail = LogUtil.queryServiceInvocationStat(service.getCode(), lastStart, lastEnd, "fail");
                            map.put("status", 0);
                            List<DpServiceMonitor> lastFails = dpServiceMonitorProvider.findByMap(map);
                            if (lastFails != null && !lastFails.isEmpty()) {
                                DpServiceMonitor lastFailMonitor = lastFails.get(0);
                                lastFailMonitor.setCount(lastFail);
                                dpServiceMonitorProvider.update(lastFailMonitor);
                            }

                            // 保存当天的
                            long success = LogUtil.queryServiceInvocationStat(service.getCode(), start.getTime(), end.getTime(), "success");
                            DpServiceMonitor successMonitor = new DpServiceMonitor();
                            successMonitor.setCount(success);
                            successMonitor.setServiceId(service.getId());
                            successMonitor.setPeriodStart(start.getTime());
                            successMonitor.setPeriodType("d");
                            successMonitor.setStatus(1);
                            dpServiceMonitorProvider.save(successMonitor);

                            long fail = LogUtil.queryServiceInvocationStat(service.getCode(), start.getTime(), end.getTime(), "fail");
                            DpServiceMonitor failMonitor = new DpServiceMonitor();
                            failMonitor.setCount(fail);
                            failMonitor.setServiceId(service.getId());
                            failMonitor.setPeriodStart(start.getTime());
                            failMonitor.setPeriodType("d");
                            failMonitor.setStatus(0);
                            dpServiceMonitorProvider.save(failMonitor);
                        } else {
                            // 更新当天的
                            long success = LogUtil.queryServiceInvocationStat(service.getCode(), start.getTime(), end.getTime(), "success");
                            Map<String, Object> map = Maps.newHashMap();
                            map.put("serviceId", service.getId());
                            map.put("periodStart", start.getTime());
                            map.put("periodType", "d");
                            map.put("status", 1);
                            List<DpServiceMonitor> successes = dpServiceMonitorProvider.findByMap(map);
                            if (successes != null && !successes.isEmpty()) {
                                DpServiceMonitor successMonitor = successes.get(0);
                                successMonitor.setCount(success);
                                dpServiceMonitorProvider.update(successMonitor);
                            }

                            long fail = LogUtil.queryServiceInvocationStat(service.getCode(), start.getTime(), end.getTime(), "fail");
                            map.put("status", 0);
                            List<DpServiceMonitor> fails = dpServiceMonitorProvider.findByMap(map);
                            if (fails != null && !fails.isEmpty()) {
                                DpServiceMonitor failMonitor = fails.get(0);
                                failMonitor.setCount(fail);
                                dpServiceMonitorProvider.update(failMonitor);
                            }
                        }
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (DubboProviderException e) {
            e.printStackTrace();
        }
    }
}
