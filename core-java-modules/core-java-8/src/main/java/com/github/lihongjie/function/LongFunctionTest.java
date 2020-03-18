package com.github.lihongjie.function;

import java.util.function.LongFunction;

public class LongFunctionTest {

    public static void main(String args[]) {

        LongFunction<Double> ob = a -> a / 2.0;

        // Using apply()
        System.out.println(ob.apply(3)); // 1.5
    }
}
