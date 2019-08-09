package com.github.lihongjie.function;

import java.util.function.LongToDoubleFunction;

public class LongToDoubleFunctionTest {

    public static void main(String args[]) {

        LongToDoubleFunction ob = a -> a / 2;

        // Using applyAsDouble() method
        System.out.println(ob.applyAsDouble(3)); // 1.0
    }
}
