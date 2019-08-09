package com.github.lihongjie.function;

import java.util.function.LongToIntFunction;

public class LongToIntFunctionTest {

    public static void main(String args[]) {

        // Instantiating LongToIntFunction
        LongToIntFunction ob = a -> (int) a * 100000;

        // Applying the above function
        // using applyAsInt()
        System.out.println(ob.applyAsInt(2));
    }
}
