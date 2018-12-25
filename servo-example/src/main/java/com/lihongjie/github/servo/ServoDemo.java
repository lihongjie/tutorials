package com.lihongjie.github.servo;

import com.netflix.servo.monitor.Counter;
import com.netflix.servo.monitor.MonitorConfig;
import com.netflix.servo.monitor.Monitors;
import com.netflix.servo.monitor.PeakRateCounter;

public class ServoDemo {

    public static void main(String[] args){
        Calculator p = new Calculator();
        Monitors.registerObject("calculatorStats", p);
        new Thread(p).start();
    }
}



class Calculator implements Runnable {
    private final Counter count = Monitors.newCounter("count");
    private final PeakRateCounter peakRateCounter =    new PeakRateCounter(MonitorConfig.builder("peakrate").build());

    @Override
    public void run() {

        int totalTime = 60 * 100000; // in millis;
        long startTime = System.currentTimeMillis();
        boolean finished = false;
        long prime = 1;

        while (!finished) {

            if (isPrime(prime)) {
                System.out.println(prime);
                count.increment();
                peakRateCounter.increment();
            }
            finished = (System.currentTimeMillis() - startTime) >= totalTime;
            prime ++;
        }
        System.out.println("done");
    }


    private boolean isPrime(long n) {
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }


}