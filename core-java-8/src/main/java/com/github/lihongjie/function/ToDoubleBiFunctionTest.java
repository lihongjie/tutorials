package com.github.lihongjie.function;

import java.util.function.ToDoubleBiFunction;

public class ToDoubleBiFunctionTest {


    public static void main(String[] args) {

        ToDoubleBiFunction<Integer,Long> i  = (x,y)-> Math.sin(x)+ Math.sin(y);

        System.out.println(i.applyAsDouble(Integer.MAX_VALUE, Long.MAX_VALUE));

        ToDoubleBiFunction<Integer, String>
                ob = (a, b) -> a + Integer.parseInt(b) * 3.2;

        // Using applyAsDouble()
        System.out.println(ob.applyAsDouble(3, "10")); // 35.0
    }
}
