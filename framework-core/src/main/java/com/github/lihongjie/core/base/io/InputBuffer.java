package com.github.lihongjie.core.base.io;

public interface InputBuffer {

    int read(byte[] b, int off, int len);

    int read(byte[] b);

    int read();

    int readLine(CharArrayBuffer buffer);

    String readLine();

    TransportMetrics getMetrics();
}
