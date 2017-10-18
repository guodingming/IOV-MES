package com.mes.control.init;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.Exception.JobException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.netty.Message;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.JobTool;
import com.mes.control.jobs.ServiceInvocationDailyStatJob;
import com.mes.control.jobs.ServiceInvocationMonthlyStatJob;
import com.mes.control.provider.MenuProviderImpl;
import com.mes.control.utils.*;
import com.mes.entity.control.Menu;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class InitReve {

    private static final Logger log = LogManager.getLogger(InitReve.class);
    public static Map<String, Object> actorMap = Maps.newHashMap();
    public static Map<String, String> taskRunState = Maps.newHashMap();

    /**
     * 初始化
     */
    public void init() {
        try {
            log.info("启动成功！");

            // 系统初始化
            initSystem();
        } catch (Exception e) {
            log.error("系统初始化失败！", e);
        }
    }

    private void initSystem() {
        /**
         * 加载menu.json内容到数据库
         */
//        loadMenuToDB();

        /**
         * 保存实体表信息
         */
        EntityTableUtil.persist();

        InitDataDictionaryUtil.saveDiction();

        /**
         * 启动netty服务端
         */
        startNettyServer();

        /**
         * 处理kafka中的用户操作日志（取出后索引到ES中）
         */
//        LogUtil.handleUserOpLog();
        /**
         * 处理kafka中的系统日志（取出后索引到ES中）
         */
//            LogUtil.handleSysLog();
        /**
         * 处理kafka中的服务调用结果（取出后索引到ES中）
         */
//            LogUtil.handleServiceInvocation();
        /**
         * 每个一段时间更新一下所有agent的心跳状态
         */
        AgentUtil.startAgentMonitor(Long.parseLong(ConfigHelper.getValue("agent.heartbeat.max.delay")));

        /**
         * 启动所有定时任务
         */
//            startJobs();

        /**
         * 导入COM组件调用接口需要的service及对应的function到相应表中
         */
        ComInterfacesUtil.persist();

        /**
         * 导入条码通配符替换函数
         */
        BarcodeWildcardFnUtil.persist();
    }

    private void startJobs() {
        // 服务调用结果统计
        startServiceInvocationStat();
        // 其他定时任务
        startLdapLoadData();
    }

    private void startLdapLoadData() {
        try {
            /**
             * 从ldap中导入系统中的部门和用户信息
             */
            JobTool.getInstance().addJob("load-ldap-data", ConfigHelper.getValue("ldap.load.data.quartz"), AdDomainUtil.class);
        } catch (JobException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务调用结果统计（按天、月）
     */
    private void startServiceInvocationStat() {
        try {
            // 统计当天的服务调用情况
            JobTool.getInstance().addJob("service-invocation-daily-stat", ConfigHelper.getValue("service.invocation.daily.stat"), ServiceInvocationDailyStatJob.class);
        } catch (JobException e) {
            e.printStackTrace();
        }
        try {
            // 统计当月的服务调用情况
            JobTool.getInstance().addJob("service-invocation-monthly-stat", ConfigHelper.getValue("service.invocation.monthly.stat"), ServiceInvocationMonthlyStatJob.class);
        } catch (JobException e) {
            e.printStackTrace();
        }
    }

    private void loadMenuToDB() {
        // 只有load.menu.to.db为true才加载
        if ("true".equalsIgnoreCase(ConfigHelper.getValue("load.menu.to.db"))) {
            InputStream is = InitReve.class.getClassLoader().getResourceAsStream("configs/menu.json");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[2048];
            int len = -1;
            try {
                while ((len = is.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                String json = baos.toString();
                List<Menu> menus = JSON.parseArray(json, Menu.class);
                MenuProviderImpl menuProvider = (MenuProviderImpl) ServiceBeanContext.getInstance().getBean("menuProvider");
                menuProvider.deleteAll();
                if (menus != null && !menus.isEmpty()) {
                    menus.stream().forEach(menu -> {
                        saveMenu(menu, menuProvider);
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 保存单个菜单及其所有子菜单
     *
     * @param menu
     * @param menuProvider
     */
    private void saveMenu(Menu menu, MenuProviderImpl menuProvider) {
        try {
            menuProvider.save(menu);
            List<Menu> subMenus = menu.getSubMenus();
            if (subMenus != null && !subMenus.isEmpty()) {
                subMenus.stream().forEach(subMenu -> {
                    saveMenu(subMenu, menuProvider);
                });
            }
        } catch (DubboProviderException e) {
            e.printStackTrace();
        }
    }

    private void startNettyServer() {
        NettyServer.getInstance().start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                NettyServer.getInstance().getServer().stop();
            }
        });
        // send();
    }

    /**
     * 模拟发送测试报文
     */
    private void send() {
        new Thread() {
            public void run() {
                while (true) {
                    Message message = new Message();
                    message.setType(Message.Type.MES2AGENT_DATA);
                    message.setBody(UUID.randomUUID().toString());
                    message.setMessageId(UUID.randomUUID().toString());
                    NettyServer.getInstance().getServer().sendToAll(message);

                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    NettyServer.getInstance().getServer().sendFile("d:/.m2.zip");

                    try {
                        Thread.sleep(60000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}
