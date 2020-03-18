package com.github.lihongjie.function;

import java.util.function.IntConsumer;

public class IntConsumerTest {

    public static void main(String args[]) {

        // Create a IntConsumer Instance
        IntConsumer display = a -> System.out.println(a * 10);

        // using accept() method
        display.accept(3); // 30
    }
}
