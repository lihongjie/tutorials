package com.github.lihongjie.core.base.io;

public interface OutputBuffer {

    void write(byte[] b, int off, int len);

    void write(byte[] b);

    void write(int b);

    void writeLine(String s);

    void writeLine(CharArrayBuffer buffer);

    void flush();

    TransportMetrics getMetrics();
}
