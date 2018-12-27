package com.github.lihongjie.currency.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 另一种典型的用方法是讲一个任务分成N个子任务,每个任务接收后调用countDown(),当所有子任务接受时,主线程通过等待(1个await(),N个countDown())
 */
public class CountDownLatchDriver2 {

    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        CountDownLatch doneSignal = new CountDownLatch(n);
        Executor e = Executors.newFixedThreadPool(2);
        for (int i = 0; i < n; i++) {
            e.execute(new WorkerRunnable(doneSignal, i));

            doneSignal.await(); // wait for all to finish
        }
    }
}
