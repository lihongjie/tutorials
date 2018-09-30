package com.github.lihongjie.core.base.io;

public interface TransportMetrics {

    long getBytesTransferred();

    void reset();
}
