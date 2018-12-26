package com.github.lihongjie.core.common;

import java.text.DecimalFormat;
import java.util.concurrent.locks.ReentrantLock;

public class IdGenerator {

    private int count = 1;

    private ReentrantLock lock = new ReentrantLock();

    private static DecimalFormat keyFmt = new DecimalFormat("000000");

    public String nexSeqId() {
        try {
            lock.lock();
            long timestamp = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("10").append(timestamp).append(format(count));
            count++;
            return sb.toString();

        } finally {
            lock.unlock();
        }
    }

    private String format(int count) {

       return keyFmt.format(count);
    }
}
