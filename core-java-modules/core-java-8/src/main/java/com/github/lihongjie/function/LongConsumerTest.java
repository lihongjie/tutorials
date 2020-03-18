package com.github.lihongjie.function;

import java.util.function.LongConsumer;

public class LongConsumerTest {

    public static void main(String args[]) {

        // Create a LongConsimer Instance
        LongConsumer display = a -> System.out.println(a * 100);

        // Using accept() method
        display.accept(3); // 300
    }
}
