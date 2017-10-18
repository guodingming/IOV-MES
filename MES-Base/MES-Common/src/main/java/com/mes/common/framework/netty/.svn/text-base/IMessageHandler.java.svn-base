package com.mes.common.framework.netty;

import io.netty.channel.ChannelHandlerContext;

/**
 * Created by xiuyou.xu on 2017/6/28.
 */
public interface IMessageHandler<T> {
    /**
     * 根据消息传输类别处理消息
     *
     * @param ctx
     * @param message
     * @throws Exception
     */
    void handle(ChannelHandlerContext ctx, T message) throws Exception;
}
