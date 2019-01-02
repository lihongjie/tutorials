package com.github.lihongjie.currency.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock
 * ReentrantReadWriteLock
 */
public class Statistic {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int value;

    public void increment() {
        lock.writeLock().lock();
        try {
            value++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int current() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

}
