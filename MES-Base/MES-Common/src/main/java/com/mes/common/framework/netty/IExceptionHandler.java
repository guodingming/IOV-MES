package com.mes.common.framework.netty;

import io.netty.channel.ChannelHandlerContext;

/**
 * Created by xiuyou.xu on 2017/8/18.
 */
public interface IExceptionHandler {
    /**
     * 发生channel异常时的后续动作
     *
     * @param ctx
     * @param cause
     */
    void handle(ChannelHandlerContext ctx, Throwable cause);
}
