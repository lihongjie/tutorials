package com.github.lihongjie.function;

import java.util.function.ToDoubleFunction;

public class ToDoubleFunctionTest {

    public static void main(String args[]) {

        ToDoubleFunction<Integer> ob = a -> a / 2;

        // using applyAsDouble()
        System.out.println(ob.applyAsDouble(3)); // 1.0
    }
}
