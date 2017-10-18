package com.mes.common.framework.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * 消息客户端
 * Created by xiuyou.xu on 2017/6/28.
 */
public class MessageClient {
    private Logger logger = LoggerFactory.getLogger(MessageClient.class);

    private String host;
    private int port;
    private Map<Message.Type, IMessageHandler> messageHandlerMap;
    private IExceptionHandler exceptionHandler;
    private Channel ch;

    private EventLoopGroup group = new NioEventLoopGroup();

    public MessageClient(String host, int port, Map<Message.Type, IMessageHandler> messageHandlerMap,IExceptionHandler exceptionHandler) {
        this.host = host;
        this.port = port;
        this.messageHandlerMap = messageHandlerMap;
        this.exceptionHandler = exceptionHandler;
    }

    /**
     * 启动client，即连接server的指定端口
     */
    public void start() {
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(
                                    new MessageDecoder(),
                                    new MessageEncoder(),
                                    new ClientHandler(messageHandlerMap, exceptionHandler));
                        }
                    });

            ch = bootstrap.connect(host, port).sync().channel();
            logger.debug("client started...");
        } catch (InterruptedException e) {
            logger.error("failed to start client", e);
        }
    }

    /**
     * 关闭client
     */
    public void stop() {
        logger.info("stopping message client...");
        group.shutdownGracefully();
        if (ch != null) {
            ch.closeFuture().addListener(ChannelFutureListener.CLOSE);
        }
        logger.info("message client stopped...");
    }

    /**
     * 向server发送消息
     *
     * @param message 消息对象
     */
    public void send(Message message) {
        if (ch != null) {
            ch.writeAndFlush(message);
        }
    }

    /**
     * 发送文件
     *
     * @param file 文件路径
     */
    public void sendFile(String file) {
        String messageId = UUID.randomUUID().toString();
        File f = new File(file);
        try (InputStream is = new FileInputStream(f)) {
            byte[] buf = new byte[1024 * 1024];
            int len = -1;
            long read = 0;
            while ((len = is.read(buf)) != -1) {
                read += len;

                Message message = new Message();
                message.setType(Message.Type.AGENT2MES_FILE);
                message.setMessageId(messageId);
                message.setFileName(f.getName());
                message.setFileData(Arrays.copyOfRange(buf, 0, len));
                message.setLast(read == f.length());

                ch.writeAndFlush(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
