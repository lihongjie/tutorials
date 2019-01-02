package com.github.lihongjie.currency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example of using an explicit ReentrantLock instance
 */
public class Counter {

    private final Lock lock = new ReentrantLock();
    private int value = 0;

    public int increment() {
        lock.lock();
        try {
            return ++value;
        } finally {
            lock.unlock();
        }
    }
}
