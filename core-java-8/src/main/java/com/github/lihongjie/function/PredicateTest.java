package com.github.lihongjie.function;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        // (x) -> x == 3 输入一个参数x，进行比较操作，返回一个布尔值
        // 所以该lambda表达式可以实现Predicate接口

        Predicate<Integer> predicate = (x) -> x == 3;
        System.out.println(predicate.test(3));//true
        System.out.println(predicate.test(2));//false
    }
}
