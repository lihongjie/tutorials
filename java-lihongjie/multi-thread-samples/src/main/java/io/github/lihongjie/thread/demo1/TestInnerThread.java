package io.github.lihongjie.thread.demo1;

/**
 * Test wait(),notify(),notifyAll() method
 */
public class TestInnerThread {

    public static void main(String[] args) {

        final Customer c = new Customer();

        new Thread(){
            public void run() {
                c.withdraw(15000);
            }
        }.start();

        new Thread() {

            public void run() {
                c.deposit(10000);
            }
        }.start();
    }
}
