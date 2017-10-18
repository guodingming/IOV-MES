package com.mes.agent.transport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Maps;
import com.mes.agent.utils.PrintUtil;
import com.mes.agent.utils.ServerTester;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.netty.*;

import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/3.
 */
public class NettyClient {
    private static NettyClient instance;
    private static MessageClient client;
    private FileMessageHandler fileHandler = new FileMessageHandler();

    private NettyClient() {
    }

    public static NettyClient getInstance() {
        if (instance == null) {
            synchronized (NettyClient.class) {
                if (instance == null) {
                    instance = new NettyClient();
                }
            }
        }
        return instance;
    }

    public void init() {
        Map<Message.BizType, IBizHandler> bizHandlerMap = Maps.newHashMap();
        IBizHandler labelPrintHandler = map -> {
            String cmd = (String) map.get("cmd");
            String printerPort = (String) map.get("printerPort");
            if ("usb".equalsIgnoreCase(printerPort)) {
                PrintUtil.usbPrint(cmd);
            }
            if ("serial".equalsIgnoreCase(printerPort)) {
                PrintUtil.serialPrint(cmd);
            }
            if ("tcp".equalsIgnoreCase(printerPort)) {
                PrintUtil.tcpPrint((String) map.get("ip"), (Integer) map.get("port"), cmd);
            }
        };
        bizHandlerMap.put(Message.BizType.LABEL_PRINT, labelPrintHandler);

        Map<Message.Type, IMessageHandler> messageHandlerMap = Maps.newHashMap();
        // 处理MES2AGENT_DATA消息
        IMessageHandler dataHandler = (IMessageHandler<Message>) (ctx, message) -> {
//            System.out.println("received " + message.getType() + " message: " + message);
            String body = message.getBody();
            Map<String, Object> map = JSON.parseObject(body, new TypeReference<Map<String, Object>>() {
            });
            Message.BizType type = Message.BizType.valueOf( map.get("type").toString());
            if (bizHandlerMap.containsKey(type)) {
                bizHandlerMap.get(type).handle(map);
            }
        };
        messageHandlerMap.put(Message.Type.MES2AGENT_DATA, dataHandler);
        // 处理MES2AGENT_FILE消息
//            IMessageHandler fileHandler = (IMessageHandler<Message>) (ctx, message) -> {
//                System.out.println("received " + message.getType() + " message: " + message);
//            };
        messageHandlerMap.put(Message.Type.MES2AGENT_FILE, fileHandler);

        /**
         * 发生异常后重新初始化客户端
         */
        IExceptionHandler exceptionHandler = (ctx, cause) -> {
            NettyClient.getInstance().stop();
            NettyClient.getInstance().init();
        };

        String serverStr = ConfigHelper.getValue("mes.servers");
        if (serverStr != null && !serverStr.isEmpty()) {
            String[] servers = serverStr.split(",");
            for (String server : servers) {
                String[] a = server.split(":");
                // 判断server是否可连接
                if (ServerTester.test(a[0], Integer.parseInt(a[1]))) {
                    client = new MessageClient(a[0], Integer.parseInt(a[1]), messageHandlerMap, exceptionHandler);
                    break;
                }
            }
        }
        if (client == null) {
            throw new IllegalStateException("client is null and can not be successfully created, there is no available server to connect to.");
        }
    }

    public void start() {
        if (client == null) {
            init();
        }
        client.start();
    }

    public void stop() {
        client.stop();
        fileHandler.close();
    }

    public MessageClient getClient() {
        return client;
    }
}
