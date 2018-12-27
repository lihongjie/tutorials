package com.github.lihongjie.currency.practice;

public class ShutdownHookThread extends Thread {

    @Override
    public void run() {
        System.out.println("shut down hook task completed..");
    }


}
