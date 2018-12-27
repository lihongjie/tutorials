package com.github.lihongjie.currency.book.ch4;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单向消息的服务器
 */
public class WebService implements Runnable {

    static final int PORT = 1040;

    Handler handler = new Handler();

    @Override
    public void run() {
        try {
            ServerSocket socket = new ServerSocket(PORT);
            for (;;) {
                final Socket connection = socket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.process(connection);
                    }
                }).start();
            }
        } catch (Exception e) {
            // ignore
        }
    }
}
