package com.github.lihongjie.currency.book.ch4;

/**
 * 对ThreadPerMessageHost的增强，它直接依赖于Thread类，以及代码风格问题，
 * 这种用法下，很难调整线程的初始化参数以及应用中用到的线程相关的数据。
 *
 * 这里是轻量级可执行框架，是对ThreadPerMessage的增强
 */
public class PlainThreadExecutor implements Executor {

    @Override
    public void execute(Runnable r) {
        new Thread(r).start();
    }
}
