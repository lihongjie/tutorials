package io.github.lihongjie.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchWorker implements Runnable {

    private final CountDownLatch startSignal;

    private final CountDownLatch doneSignal;

    public CountDownLatchWorker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {
            // return
        }
    }

    void doWork() {
        System.out.println("work");
    }

}
