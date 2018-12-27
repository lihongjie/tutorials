package com.github.lihongjie.currency.book.ch4;

public class ThreadPerMessageHost {

    protected long localState;
    protected final Helper helper = new Helper();

    protected synchronized void updateState() {
        // localState = ...;
    }

    public void req() {
        updateState();
        // 在多个并发任务能够比同样多的任务串行运行得更快时，这个每个请求一个线程能提高系统的吞吐量。
        // 由于创建线程远比直接方法调用开销多，所以每消息一线程的设计会增加请求的反应时间。但是，在任务的执行比线程构造更耗时，这种设计是值得的。
        // 有个性能问题就是，线程创建太多，消耗了与线程有关的系统资源。另外，随着线程数量的增加，线程调度和上下文切换会占用大量的处理时间。
        new Thread(new Runnable() {
            @Override
            public void run() {
                helper.handle();
            }
        }).start();
    }
}
