package com.github.lihongjie.currency.book.ch4;

public class HostWithExecutor {

    protected long localState;
    protected final Helper helper = new Helper();
    protected final Executor executor;

    public HostWithExecutor(Executor e) {
        executor = e;
    }

    protected synchronized void updateState() {
        // localSate = ...
    }

    public void req() {
        updateState();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                helper.handle();
            }
        });
    }









}
