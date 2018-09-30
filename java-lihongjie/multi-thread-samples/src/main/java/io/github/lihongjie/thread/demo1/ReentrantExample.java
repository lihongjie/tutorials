package io.github.lihongjie.thread.demo1;


public class ReentrantExample {

    public static void main(String args[]) {
        final Reentrant re = new Reentrant();

        Thread t1 = new Thread() {
            public void run() {
                re.m();//calling method of Reentrant class
            }
        };
        t1.start();
    }
}


