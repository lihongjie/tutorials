package com.github.lihongjie.function;

import java.util.function.BiFunction;

public class BiFunctionTest {

    public static void main(String[] args) {

        BiFunctionTest test = new BiFunctionTest();
        test.apply();
    }


    private void apply() {

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        // Implement add using apply()
        System.out.println("Sum = " + add.apply(2, 3));

        // BiFunction to multiply 2 numbers
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

        // Implement add using apply()
        System.out.println("Product = " + multiply.apply(2, 3));

    }
}
