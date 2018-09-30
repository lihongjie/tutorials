package com.github.lihongjie.core.base.io.impl;

import com.github.lihongjie.core.base.io.TransportMetrics;

public class TransportMetricsImpl implements TransportMetrics{

    private long bytesTransferred = 0;

    @Override
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(final long count) {
        this.bytesTransferred = count;
    }

    public void incrementBytesTransferred(final long count) {
        this.bytesTransferred += count;
    }
    @Override
    public void reset() {
        this.bytesTransferred = 0;
    }
}
