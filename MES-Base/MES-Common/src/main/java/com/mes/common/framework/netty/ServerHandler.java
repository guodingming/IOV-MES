package com.mes.common.framework.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 服务端处理器
 * Created by xiuyou.xu on 2017/6/28.
 */
public class ServerHandler extends SimpleChannelInboundHandler<Message> {
    private static Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    private MessageServer server;
    private Map<Message.Type, IMessageHandler> messageHandlerMap;
    private IExceptionHandler exceptionHandler;

    public ServerHandler(MessageServer server, Map<Message.Type, IMessageHandler> messageHandlerMap, IExceptionHandler exceptionHandler) {
        this.server = server;
        this.messageHandlerMap = messageHandlerMap;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        server.addChannel(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        server.removeChannel(ctx.channel());
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
//        logger.info("server handler read thread: " + Thread.currentThread().getName());
        if (messageHandlerMap.containsKey(msg.getType())) {
            messageHandlerMap.get(msg.getType()).handle(ctx, msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        logger.error("exception occurred", cause);
        exceptionHandler.handle(ctx, cause);
        ctx.channel().close();
        ctx.close();
    }
}
