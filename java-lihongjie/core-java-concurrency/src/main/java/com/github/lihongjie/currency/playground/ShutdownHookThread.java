package com.github.lihongjie.currency.playground;

public class ShutdownHookThread extends Thread {

    @Override
    public void run() {
        System.out.println("shut down hook task completed..");
    }


}
