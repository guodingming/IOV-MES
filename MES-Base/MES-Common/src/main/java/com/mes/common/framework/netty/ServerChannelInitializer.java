package com.mes.common.framework.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;

/**
 * 服务端channel初始化器
 * Created by xiuyou.xu on 2017/6/28.
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    private MessageServer server;
    private Map<Message.Type, IMessageHandler> messageHandlerMap;
    private IExceptionHandler exceptionHandler;

    public ServerChannelInitializer(MessageServer server, Map<Message.Type, IMessageHandler> messageHandlerMap, IExceptionHandler exceptionHandler) {
        this.server = server;
        this.messageHandlerMap = messageHandlerMap;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(
                new MessageDecoder(),
                new MessageEncoder(),
                new ServerHandler(server, messageHandlerMap, exceptionHandler));
    }
}
