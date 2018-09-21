package io.github.lihongjie.thread.demo1;

public class ShutdownHookThread extends Thread {

    @Override
    public void run() {
        System.out.println("shut down hook task completed..");
    }


}
