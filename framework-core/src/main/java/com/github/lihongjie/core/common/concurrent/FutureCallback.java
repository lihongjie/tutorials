package com.github.lihongjie.core.common.concurrent;

public interface FutureCallback<T> {

    void completed(T result);

    void failed(Exception ex);

    void cancelled();
}
