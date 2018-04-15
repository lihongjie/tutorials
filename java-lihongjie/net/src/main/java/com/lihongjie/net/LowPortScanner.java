package com.lihongjie.net;

import java.net.Socket;

/**
 * 《Java网络编程》 287页
 *  查看指定主机上前1024端口中哪些可以提供TCP服务
 */
public class LowPortScanner {

    public static void main(String[] args) {
        String host = "192.168.31.23";
        if (args.length > 0) {
            host = args[0];
        }
        for (int i = 1; i < 1024; i++) {
            try {
                Socket socket = new Socket(host, i);
                System.out.println("There is a server on port " + i +" of" + host);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            } finally {

            }

        }
    }
}
