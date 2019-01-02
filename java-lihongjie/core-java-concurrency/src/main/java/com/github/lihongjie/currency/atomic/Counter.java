package com.github.lihongjie.currency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private AtomicInteger value = new AtomicInteger();
    public int next() {
        return value.incrementAndGet();
    }
}
