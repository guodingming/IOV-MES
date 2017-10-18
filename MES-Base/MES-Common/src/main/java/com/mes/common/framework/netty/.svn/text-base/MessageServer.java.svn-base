package com.mes.common.framework.netty;

import com.google.common.collect.Maps;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消息服务端
 * Created by xiuyou.xu on 2017/6/28.
 */
public class MessageServer {
    private static Logger logger = LoggerFactory.getLogger(MessageServer.class);
    private int port;
    /**
     * 不同类型消息处理器map，用于处理不同类型的消息
     */
    private Map<Message.Type, IMessageHandler> messageHandlerMap;
    private IExceptionHandler exceptionHandler;

    private EventLoopGroup boss = new NioEventLoopGroup(1);
    private EventLoopGroup worker = new NioEventLoopGroup();

    private ExecutorService pool = null;

    private ChannelGroup channels = new DefaultChannelGroup("groups", GlobalEventExecutor.INSTANCE);
    /**
     * ip和channelId对应关系，用于server通过ip主动向多个client发送消息
     */
    private Map<String, ChannelId> channelIdMap = Maps.newHashMap();

    boolean addChannel(Channel ch) {
        channelIdMap.put(((InetSocketAddress) ch.remoteAddress()).getAddress().getHostAddress(), ch.id());
        return channels.add(ch);
    }

    boolean removeChannel(Channel ch) {
        channelIdMap.remove(((InetSocketAddress) ch.remoteAddress()).getAddress().getHostAddress());
        return channels.remove(ch);
    }

    public MessageServer(int port, Map<Message.Type, IMessageHandler> messageHandlerMap, IExceptionHandler exceptionHandler, int threadpoolSize) {
        this.port = port;
        this.messageHandlerMap = messageHandlerMap;
        this.exceptionHandler = exceptionHandler;
        this.pool = Executors.newFixedThreadPool(threadpoolSize);
    }

    /**
     * 启动server，即新建一个ServerBootstrap，并监听给定的端口
     */
    public void start() {
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .childHandler(new ServerChannelInitializer(this, messageHandlerMap, exceptionHandler));

            bootstrap.bind(port).sync();
            logger.debug("server started...");
        } catch (InterruptedException e) {
            logger.error("failed to start server", e);
        }
    }

    /**
     * 关闭server
     */
    public void stop() {
        logger.info("stopping message server...");
        boss.shutdownGracefully();
        worker.shutdownGracefully();
        pool.shutdown();

        if (channels != null) {
            channels.close();
        }
        logger.info("message server stopped...");
    }

    /**
     * 向多个ip发送消息
     *
     * @param message 消息对象
     * @param ips     ip列表
     */
    public void send(Message message, String... ips) {
        for (String ip : ips) {
            if (channelIdMap.containsKey(ip) && channelIdMap.get(ip) != null) {
                channels.find(channelIdMap.get(ip)).writeAndFlush(message);
            }
        }
    }

    /**
     * 向所有客户端发送消息
     *
     * @param message 消息对象
     */
    public void sendToAll(Message message) {
        channels.writeAndFlush(message);
    }

    /**
     * 发送文件
     *
     * @param file 文件路径
     * @param ips  ip列表
     */
    public void sendFile(String file, String... ips) {
        String messageId = UUID.randomUUID().toString();
        for (String ip : ips) {
            if (channelIdMap.containsKey(ip) && channelIdMap.get(ip) != null) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        File f = new File(file);
                        try (InputStream is = new FileInputStream(f)) {
                            byte[] buf = new byte[1024 * 1024];
                            int len = -1;
                            long read = 0;
                            while ((len = is.read(buf)) != -1) {
                                read += len;

                                Message message = new Message();
                                message.setType(Message.Type.MES2AGENT_FILE);
                                message.setMessageId(messageId);
                                message.setFileName(f.getName());
                                message.setFileData(Arrays.copyOfRange(buf, 0, len));
                                message.setLast(read == f.length());

                                channels.find(channelIdMap.get(ip)).writeAndFlush(message);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}
