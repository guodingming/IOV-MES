package com.mes.agent.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by xiuyou.xu on 2017/8/18.
 */
public class ServerTester {
    /**
     * 检测给定的服务端是否可连接
     *
     * @param host
     * @param port
     * @return
     */
    public static boolean test(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(test("127.0.0.1", 5067));
    }
}
