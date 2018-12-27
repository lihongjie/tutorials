package com.github.lihongjie.currency.book.ch4;

public class Channel {

    void put(Runnable r) {

    }

    Runnable take() {

        return new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
