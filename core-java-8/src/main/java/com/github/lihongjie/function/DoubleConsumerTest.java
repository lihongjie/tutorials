package com.github.lihongjie.function;

import java.util.function.DoubleConsumer;

public class DoubleConsumerTest {

    public static void main(String args[]) {

        // Create a DoubleConsimer Instance
        DoubleConsumer display = a -> System.out.println(a * 10);

        // using accept() method
        display.accept(3); // 30.0
    }
}
