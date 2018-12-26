package io.github.lihongjie.thread.demo1;


public class TestReentrantExample {

    public static void main(String[] args) {

        final Reentrant re = new Reentrant();

        Thread t1 = new Thread() {

            @Override
            public void run() {
                re.m();//calling method of Reentrant class
            }
        };
        t1.start();
    }
}


