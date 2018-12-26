package com.github.lihongjie.core.common.concurrent;

public class ThreadLocalTimer {

    public static ThreadLocal<Long> timeThreadLocal = new ThreadLocal<>();

    public static long startTime() {
        return timeThreadLocal.get();
    }

    public static void setStartTime(long dateTime) {
        timeThreadLocal.set(dateTime);
    }

    public static void remove() {
        timeThreadLocal.remove();
    }
}
