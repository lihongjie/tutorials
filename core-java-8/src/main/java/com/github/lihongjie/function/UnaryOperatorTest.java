package com.github.lihongjie.function;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {


    public static void main(String[] args) {

        UnaryOperator<Integer> unaryOperator = x -> x * 2;

        System.out.println(unaryOperator.apply(3)); // 6

    }
}
