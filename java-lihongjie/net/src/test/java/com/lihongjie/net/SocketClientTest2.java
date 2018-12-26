package com.lihongjie.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketClientTest2 {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8050;

    private Socket socket;

    public static void main(String[] args) {
        new SocketClientTest2().launch();
    }

    public void launch() {
        connect();
    }

    public void connect() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);

            //使用DataInputStream封装输入流
            InputStream os = new DataInputStream(socket.getInputStream());

            String xml = "123456<?xml http://><header></header></xml>";
            byte [] b = xml.getBytes();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.write(b); // 发送给客户端
            dos.flush();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
