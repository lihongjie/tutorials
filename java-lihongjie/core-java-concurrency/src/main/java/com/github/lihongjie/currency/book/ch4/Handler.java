package com.github.lihongjie.currency.book.ch4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler {

    void process(Socket s) {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
            int request = in.readInt();
            int result = -request; // return negation to client
            out.writeInt(result);
        } catch (IOException e) {
            // ignore
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException ignore) {}
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ignore) {}
            try {
                s.close();
            }catch (IOException ignore){}
        }
    }
}
