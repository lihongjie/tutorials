package com.github.lihongjie.core.base.io.impl;

import com.github.lihongjie.core.base.io.BufferInfo;
import com.github.lihongjie.core.base.io.CharArrayBuffer;
import com.github.lihongjie.core.base.io.InputBuffer;
import com.github.lihongjie.core.base.io.TransportMetrics;

public class InputBufferImpl implements InputBuffer,BufferInfo {

    @Override
    public int length() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public int available() {
        return 0;
    }

    @Override
    public int read(byte[] b, int off, int len) {
        return 0;
    }

    @Override
    public int read(byte[] b) {
        return 0;
    }

    @Override
    public int read() {
        return 0;
    }

    @Override
    public int readLine(CharArrayBuffer buffer) {
        return 0;
    }

    @Override
    public String readLine() {
        return null;
    }

    @Override
    public TransportMetrics getMetrics() {
        return null;
    }
}
