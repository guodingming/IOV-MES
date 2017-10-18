package com.mes.agent.transport;

import com.mes.common.framework.netty.IMessageHandler;
import com.mes.common.framework.netty.Message;
import io.netty.channel.ChannelHandlerContext;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiuyou.xu on 2017/7/7.
 */
public class FileMessageHandler implements IMessageHandler<Message> {
    private static Map<String, OutputStream> outputStreamMap = new ConcurrentHashMap<>();

    public void close() {
        if (outputStreamMap != null) {
            outputStreamMap.keySet().stream().forEach(key -> {
                if (outputStreamMap.get(key) != null) {
                    try {
                        outputStreamMap.get(key).close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void handle(ChannelHandlerContext ctx, Message message) throws Exception {
        File dir = new File(FileMessageHandler.class.getClassLoader().getResource("configs").getPath() + "/received");
        dir.mkdirs();
        File file = new File(dir, message.getFileName());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        // 以追加的形式保存文件数据
        append(file, message);
    }

    protected void append(File file, Message msg) {
//        if (msg == null || msg.getMessageId() == null) {
//            System.out.println("msg: " + (msg == null) + ", messageId: " + (msg == null ? true : (msg.getMessageId() == null)));
//        }
        OutputStream os = outputStreamMap.get(msg.getMessageId());
        if (os == null) {
            try {
                os = new FileOutputStream(file, true);
                outputStreamMap.put(msg.getMessageId(), os);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (os != null) {
            try {
                if (msg.getType() == Message.Type.MES2AGENT_FILE) {
                    os.write(msg.getFileData());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (msg.isLast()) {
                try {
                    os.close();
                    outputStreamMap.remove(msg.getMessageId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
