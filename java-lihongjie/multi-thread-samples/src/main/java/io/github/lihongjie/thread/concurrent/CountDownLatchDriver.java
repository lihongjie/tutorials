package io.github.lihongjie.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Sample usage: Here is a pair of classes in which a group of worker threads use two countdown latches:
 *
 * The first is a start signal that prevents any worker from proceeding until the driver is ready for them to proceed;
 * The second is a completion signal that allows the driver to wait until all workers have completed.
 * 1.主线程发送信号,然后子线程同时开始执行(N个await(),1个countDown())
 2.子线程都结束任务后,主线程会收到信号(1个await(),N个countDown())
 *
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CountDownLatch.html
 */
public class CountDownLatchDriver {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(2);
        // create and start threads
        for (int i = 0; i < 2; i++) {
            new Thread(new CountDownLatchWorker(startSignal, doneSignal)).start();
            doSomethingElse(); // don't let run yet
            startSignal.countDown(); // let all threads proceed
            doSomethingElse();
            doneSignal.await(); // wait for all to finish
        }



    }

    static void doSomethingElse() {
        System.out.println("do something else");
    }
}
