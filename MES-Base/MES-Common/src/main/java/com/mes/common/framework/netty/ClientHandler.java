package com.mes.common.framework.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 客户端处理器
 * Created by xiuyou.xu on 2017/6/28.
 */
public class ClientHandler extends SimpleChannelInboundHandler<Message> {
    private static Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    private Map<Message.Type, IMessageHandler> messageHandlerMap;
    private IExceptionHandler exceptionHandler;

    public ClientHandler(Map<Message.Type, IMessageHandler> messageHandlerMap, IExceptionHandler exceptionHandler) {
        this.messageHandlerMap = messageHandlerMap;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
//        logger.info("client handler read thread: " + Thread.currentThread().getName());
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
