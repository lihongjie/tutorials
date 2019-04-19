package com.github.lihongjie.currency.playground;

import java.util.Random;

/**
 * 线程协作 join
 */
public class JoinExample implements Runnable {
    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        //simulate some CPU expensive task
        for(int i = 0; i < 100000000; i++) {
            random.nextInt();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new JoinExample(), "joinThread-" + i);
            threads[i].start();
//            threads[i].join(); // 这种方式会让Thread-0执行完了再执行下个线程。
        }
        // 具体某个线程先执行完，由CPU决定
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] All threads have finished.");
    }

}
