package com.mes.control.utils;

import com.google.common.collect.Maps;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.netty.IExceptionHandler;
import com.mes.common.framework.netty.IMessageHandler;
import com.mes.common.framework.netty.Message;
import com.mes.common.framework.netty.MessageServer;

import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/3.
 */
public class NettyServer {
    private static NettyServer instance;
    private static MessageServer server;

    private NettyServer() {
    }

    public static NettyServer getInstance() {
        if (instance == null) {
            synchronized (NettyServer.class) {
                if (instance == null) {
                    instance = new NettyServer();
                }
            }
        }
        return instance;
    }

    public void init() {
        Map<Message.Type, IMessageHandler> messageHandlerMap = Maps.newHashMap();
        // 处理AGENT2MES_DATA消息
        IMessageHandler heartbeatHandler = (IMessageHandler<Message>) (ctx, message) -> {
//            System.out.println("received heartbeat message: " + message);
            AgentUtil.heartbeat(message.getSenderIp(), System.currentTimeMillis());
        };
        messageHandlerMap.put(Message.Type.HEARTBEAT, heartbeatHandler);
        // 处理AGENT2MES_DATA消息
        IMessageHandler dataHandler = (IMessageHandler<Message>) (ctx, message) -> {
//            System.out.println("received " + message.getType() + " message: " + message);
        };
        /**
         * 发生异常后重新初始化客户端
         */
        IExceptionHandler exceptionHandler = (ctx, cause) -> {
//            NettyServer.getInstance().stop();
//            NettyServer.getInstance().init();
        };
        messageHandlerMap.put(Message.Type.AGENT2MES_DATA, dataHandler);
        // 处理AGENT2MES_FILE消息
        IMessageHandler fileHandler = (IMessageHandler<Message>) (ctx, message) -> {
            System.out.println("received " + message.getType() + " message: " + message);
        };
        messageHandlerMap.put(Message.Type.AGENT2MES_FILE, fileHandler);
        server = new MessageServer(Integer.parseInt(ConfigHelper.getValue("netty.server.port")), messageHandlerMap, exceptionHandler, Integer.parseInt(ConfigHelper.getValue("netty.server.threadpool.size")));
        if (server == null) {
            throw new IllegalStateException("server is null and can not be successfully created");
        }
    }

    public void start() {
        if (server == null) {
            init();
        }
        server.start();
    }

    public void stop() {
        server.stop();
    }

    public MessageServer getServer() {
        return server;
    }
}
