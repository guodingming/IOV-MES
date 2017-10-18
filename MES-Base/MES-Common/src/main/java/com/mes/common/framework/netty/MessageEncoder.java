package com.mes.common.framework.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 消息编码器，对业务消息实体Message进行编码，变成传输报文
 * Created by xiuyou.xu on 2017/6/23.
 */
public class MessageEncoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        if (message == null) {
            return;
        }
        byte[] b = JSON.toJSONBytes(message, SerializerFeature.DisableCircularReferenceDetect);
        // 传输报文头，为传输报文体的字节数
        byteBuf.writeInt(b.length);
        // 传输报文体，为业务消息序列化后的字节数组
        byteBuf.writeBytes(b);
    }
}
