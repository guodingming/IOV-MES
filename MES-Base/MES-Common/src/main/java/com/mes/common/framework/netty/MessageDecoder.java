package com.mes.common.framework.netty;

import com.alibaba.fastjson.JSON;
import com.mes.common.framework.rest.MyValidator;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

/**
 * 消息解码器，从传输报文中解码得到业务消息实体对象
 * Created by xiuyou.xu on 2017/6/23.
 */
public class MessageDecoder extends ByteToMessageDecoder {
    private static Logger logger = LoggerFactory.getLogger(MessageDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() >= 4) {
            byteBuf.markReaderIndex();
            int len = byteBuf.readInt();
            // 其他类型消息，丢弃
            if (len <= 0) {
                return;
            }
            if (byteBuf.readableBytes() < len) {
                byteBuf.resetReaderIndex();
            } else {
                byte[] b = new byte[len];
                byteBuf.readBytes(b);
                try {
                    // 反序列化，如果失败，则表示不是Message类型消息，需要过滤掉
                    Message message = JSON.parseObject(b, Message.class);
                    // 对业务消息进行验证，主要是进行bean validation
                    Set<ConstraintViolation<Message>> violations = MyValidator.validate(message);
                    if (violations == null || violations.isEmpty()) {
                        list.add(message);
                    } else {
                        logger.info("failed to validate received message: " + MyValidator.buildConstraintViolationMessage(violations));
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
