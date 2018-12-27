package com.github.lihongjie.currency.book.ch4;

/**
 * 工作者线程要被打包成一个执行者(Executor)，用来替代每消息一线程版本的常用的实现方式（ThreadPerMessageHost）。
 */
public class PlainWorkerPool implements Executor {

    protected final Channel workQueue;

    /**
     * 在启动时创建所有的工作线程，并且在没有使用时，线程都无限制的存活下去。
     * @param channel
     * @param nworkers
     */
    public PlainWorkerPool(Channel channel, int nworkers) {
        workQueue = channel;
        for (int i = 0; i < nworkers; ++i) {
            activate();
        }
    }
    protected void activate() {
        Runnable runLoop = new Runnable() {
            @Override
            public void run() {
                try {
                    for (;;) {
                        Runnable r = workQueue.take();
                        r.run();
                    }
                }catch (Exception e) {
                    // ignore
                }
            }
        };
        new Thread(runLoop).start();
    }

    @Override
    public void execute(Runnable r) {

        try {
            workQueue.put(r);
        } catch (Exception e) {
            Thread.currentThread().interrupted();
        }
    }
}
