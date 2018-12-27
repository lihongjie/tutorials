package com.github.lihongjie.currency.book.ch4;

public class OpenCallHost {

    protected long localState;
    protected final Helper helper = new Helper();

    protected synchronized void updateState() {
        // localState = ...;
    }

    public void req() {
        updateState();
        // 即使 helper.handle方法的调用是比较耗时的，主体对象仍然能够从运行不同线程里的客户那里接收到新的请求。
        // 但是没有解决并发下的问题
        helper.handle();
    }
}
