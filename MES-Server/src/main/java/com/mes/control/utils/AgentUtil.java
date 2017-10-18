package com.mes.control.utils;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.dubbo.interprovider.control.IAgentProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * agent心跳状态保存
 * <p>
 * Created by xiuyou.xu on 2017/8/18.
 */
public class AgentUtil {
    private static Logger logger = LoggerFactory.getLogger(AgentUtil.class);

    private static IAgentProvider agentProvider = (IAgentProvider) ServiceBeanContext.getInstance().getBean("agentProvider");
    private static ConcurrentHashMap<String, AgentStatus> heartbeatMap = new ConcurrentHashMap<>();
    private static ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);

    /**
     * 更新agent对应的心跳时间
     *
     * @param ip
     * @param time
     */
    public static void heartbeat(String ip, Long time) {
        logger.debug("更新agent {} 最近心跳时间：{}", ip, time);
        AgentStatus status = heartbeatMap.get(ip);
        if (status != null) {
            status.setHeartbeatTime(time);
            if (AgentStatus.STATUS_OFFLINE.equals(status.getStatus())) {
                try {
                    agentProvider.updateStatusByIp(ip, AgentStatus.STATUS_ONLINE);
                } catch (DubboProviderException e) {
                    e.printStackTrace();
                }
            }
        } else {
            status = new AgentStatus();
            status.setHeartbeatTime(time);
            status.setStatus(AgentStatus.STATUS_ONLINE);
            heartbeatMap.put(ip, status);

            try {
                agentProvider.updateStatusByIp(ip, AgentStatus.STATUS_ONLINE);
            } catch (DubboProviderException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 启动agent状态监控，根据最后一次心跳时间更新状态
     *
     * @param maxDelay 最大延迟心跳时间
     */
    public static void startAgentMonitor(long maxDelay) {
        service.scheduleAtFixedRate(new Thread() {
            public void run() {
                long now = System.currentTimeMillis();
                heartbeatMap.keySet().forEach(ip -> {
                    // 已超过最大延迟心跳时间
                    if (heartbeatMap.get(ip).getHeartbeatTime() + maxDelay < now) {
                        try {
                            agentProvider.updateStatusByIp(ip, AgentStatus.STATUS_OFFLINE);
                        } catch (DubboProviderException e) {
                            e.printStackTrace();
                        }
                        heartbeatMap.remove(ip);
                    }
                });
            }
        }, 0, Long.parseLong(ConfigHelper.getValue("agent.monitor.check.period")), TimeUnit.MILLISECONDS);
    }

    /**
     * agent心跳状态
     */
    private static class AgentStatus {
        public static final String STATUS_OFFLINE = "0";
        public static final String STATUS_ONLINE = "1";

        private Long heartbeatTime;
        private String status;

        public Long getHeartbeatTime() {
            return heartbeatTime;
        }

        public void setHeartbeatTime(Long heartbeatTime) {
            this.heartbeatTime = heartbeatTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
