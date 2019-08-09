package com.github.lihongjie.function;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {


    public static void main(String[] args) {

        BinaryOperator<Integer> test = (a,b) -> a * b;

        System.out.println(test.apply(2, 3)); // 6

    }
}
