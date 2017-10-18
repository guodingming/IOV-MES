package com.mes.agent.main;

import com.mes.agent.transport.NettyClient;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.netty.Message;
import com.mes.common.utils.DateUtil;

/**
 * Created by xiuyou.xu on 2017/6/30.
 */
public class StartAgent {
    public static void main(String[] args) {
        try {
            System.out.println("===========================================================");
            System.out.println("[" + DateUtil.getDateTime() + "] " + "MES-Agent is starting......");
            NettyClient.getInstance().start();
            send();
            System.out.println("[" + DateUtil.getDateTime() + "] " + "MES-Agent has been started.");
            System.out.println("[" + DateUtil.getDateTime() + "] " + "MES-Agent Start successfully.");
            System.out.println("===========================================================");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 添加shutdown hook，当进程被关闭时，进行清理工作
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    NettyClient.getInstance().stop();
                }
            });
        }
    }

    /**
     * 模拟发送测试报文
     */
    private static void send() {
        // 发送心跳
        new Thread(){
            public void run() {
                while (true){
                    Message message=new Message();
                    message.setType(Message.Type.HEARTBEAT);
                    message.setMessageId(ConfigHelper.getValue("agent.ip"));
                    message.setSenderIp(ConfigHelper.getValue("agent.ip"));

                    NettyClient.getInstance().getClient().send(message);

                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        // 发送普通文本
//        new Thread(){
//            public void run() {
//                while (true) {
//                    Message message = new Message();
//                    message.setType(Message.Type.AGENT2MES_DATA);
//                    message.setBody(UUID.randomUUID().toString());
//                    message.setMessageId(UUID.randomUUID().toString());
//                    message.setSenderIp(ConfigHelper.getValue("agent.ip"));
//                    NettyClient.getInstance().getClient().send(message);
//
//                    try {
//                        Thread.sleep(5000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();

        // 发送文件
//        new Thread() {
//            public void run() {
//                while (true){
//                    NettyClient.getInstance().getClient().sendFile("d:/.m2.zip");
//
//                    try {
//                        Thread.sleep(60000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
    }
}
