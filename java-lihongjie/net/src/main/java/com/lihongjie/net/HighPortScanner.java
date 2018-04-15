package com.lihongjie.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Java 网络编程 289页
 * 使用InetAddress对象指定主机,而不是用主机名.如果无法连接，它会抛出IOException 异常，而不是UnknownHostException异常.
 */
public class HighPortScanner {

    public static void main(String[] args) {

        String host = "localhost";

        if (args.length > 0) {
            host = args[0];
        }
        try {
            InetAddress theAddress = InetAddress.getByName(host);
            for (int i = 1024; i < 65536; i++) {
                Socket socket = new Socket(theAddress, i);
                System.out.println("There is a server on port " + i + " of" + host);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
