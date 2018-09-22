package com.lihongjie.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClientTest {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8050;

    Socket socket = null;
    DataOutputStream dos = null;
    DataInputStream dis = null;
    private boolean bConnected = false;


    private static String hostInfo = null;



    public static void main(String[] args) {
        new SocketClientTest().launch();
    }

    public void launch() {
        connect();
    }

    public void connect() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            bConnected = true;

            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress().toString();// 获得本机IP
            String address = addr.getHostName().toString();// 获得本机名称
            hostInfo = ip + "\t" + address + "\t connected.";
            System.out.println(hostInfo);
            dos.writeUTF(hostInfo);
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
