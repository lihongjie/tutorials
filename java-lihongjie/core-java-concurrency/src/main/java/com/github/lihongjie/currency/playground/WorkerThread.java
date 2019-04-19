package com.github.lihongjie.currency.playground;

/**
 * 线程池的例子
 * 工作线程的使用
 */
public class WorkerThread implements Runnable {

    private String message;

    public WorkerThread(String s) {
        this.message = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "(Start)message=" + message);
        processmessage(); // call processmessage method that sleeps the thread for 2 seconds
        System.out.println(Thread.currentThread().getName() + "(End)"); // prints thread name

    }

    private void processmessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
