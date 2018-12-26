package io.github.lihongjie.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class WorkerRunnable implements Runnable {

    private final CountDownLatch doneSignal;
    private final int i;

    public WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            doWork(i);
            doneSignal.countDown();

        } catch (Exception ex) {
            // return
        }
    }

    void doWork(int i) {
        System.out.println(i);
    }
}
