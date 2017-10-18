package com.mes.common.framework.netty;

import com.google.common.collect.Maps;
import io.netty.channel.ChannelHandlerContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;

/**
 * Created by xiuyou.xu on 2017/6/28.
 */
public class TestMessageClient {
    private MessageClient client;

    @Before
    public void beforeClient() {
        Map<Message.Type, IMessageHandler> messageHandlerMap = Maps.newHashMap();
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
        IExceptionHandler exceptionHandler = (IExceptionHandler) (ctx, cause) -> {
        };
        messageHandlerMap.put(Message.Type.MES2AGENT_DATA, textHandler);
        messageHandlerMap.put(Message.Type.MES2AGENT_FILE, fileHandler);

        client = new MessageClient("127.0.0.1", 8000, messageHandlerMap, exceptionHandler);
        client.start();
    }

    @After
    public void afterClient() {
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void testClientSendText() {
        for (int i = 0; i < 10000; i++) {
            Message message = new Message();
            message.setMessageId(UUID.randomUUID().toString());
            message.setBody("agent2mes text: " + i);
            message.setSenderIp("127.0.0.1");
            message.setType(Message.Type.AGENT2MES_DATA);
            client.send(message);

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testClientSendFile() {

    }
}
