package com.github.lihongjie.currency.playground;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * 线程池的使用
 */
public class TestThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5); // creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // empty
        }
        System.out.println("Finished all threads");
    }
}
