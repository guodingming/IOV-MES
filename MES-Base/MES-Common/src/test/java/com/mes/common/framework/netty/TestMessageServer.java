package com.mes.common.framework.netty;

import com.google.common.collect.Maps;
import io.netty.channel.ChannelHandlerContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiuyou.xu on 2017/6/28.
 */
public class TestMessageServer {
    private MessageServer server;
    private ScheduledExecutorService scheduledExecutorService;

    @Before
    public void beforeServer() {
        Map<Message.Type, IMessageHandler> messageHandlerMap = Maps.newHashMap();
        IMessageHandler heartbeatHandler = new IMessageHandler<Message>() {
            @Override
            public void handle(ChannelHandlerContext ctx, Message message) throws Exception {
                System.out.println("received " + message.getType() + " message: " + message.getSenderIp() + ", " + message.getMessageId());
            }
        };
        IMessageHandler textHandler = new IMessageHandler<Message>() {
            @Override
            public void handle(ChannelHandlerContext ctx, Message message) throws Exception {
                System.out.println("received " + message.getType() + " message: " + message.getSenderIp() + ", " + message.getBody());
            }
        };
        IMessageHandler fileHandler = new IMessageHandler<Message>() {
            @Override
            public void handle(ChannelHandlerContext ctx, Message message) throws Exception {
                System.out.println("received " + message.getType() + " message: " + message.getSenderIp() + ", " + message.getFileName());
            }
        };
        /**
         * 发生异常后重新初始化客户端
         */
        IExceptionHandler exceptionHandler = (IExceptionHandler) (ctx, cause) -> {
        } ;
        messageHandlerMap.put(Message.Type.HEARTBEAT, heartbeatHandler);
        messageHandlerMap.put(Message.Type.AGENT2MES_DATA, textHandler);
        messageHandlerMap.put(Message.Type.AGENT2MES_FILE, fileHandler);

        server = new MessageServer(8000, messageHandlerMap, exceptionHandler, 20);
        server.start();

        scheduledExecutorService = Executors.newScheduledThreadPool(2);
    }

    @After
    public void afterServer() {
        if (server != null) {
            server.stop();
        }
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    @Test
    public void testServerSendText() {
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.setMessageId(UUID.randomUUID().toString());
                message.setBody("mes2agent text: " + Math.random());
                message.setType(Message.Type.MES2AGENT_DATA);
                server.sendToAll(message);
            }
        }, 0, 5L, TimeUnit.SECONDS);
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testServerSendFile() {

    }
}
