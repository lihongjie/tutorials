package com.github.lihongjie.core.base.io.impl;

import com.github.lihongjie.core.base.io.BufferInfo;
import com.github.lihongjie.core.base.io.CharArrayBuffer;
import com.github.lihongjie.core.base.io.OutputBuffer;
import com.github.lihongjie.core.base.io.TransportMetrics;

public class OutputBufferImpl implements OutputBuffer,BufferInfo {
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
    public void write(byte[] b, int off, int len) {

    }

    @Override
    public void write(byte[] b) {

    }

    @Override
    public void write(int b) {

    }

    @Override
    public void writeLine(String s) {

    }

    @Override
    public void writeLine(CharArrayBuffer buffer) {

    }

    @Override
    public void flush() {

    }

    @Override
    public TransportMetrics getMetrics() {
        return null;
    }
}
