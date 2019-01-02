package com.github.lihongjie.currency.volatileexample;

/**
 * An example of using volatile as signaling flag
 */
public class Processor implements Runnable {
    private volatile boolean stop;

    @Override
    public void run() {

        while (! stop) {
            // do processing
        }
    }

    public void stopProcessing() {
        stop = true;
    }

}
