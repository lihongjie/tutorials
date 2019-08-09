package com.github.lihongjie.function;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest f = new FunctionTest();
//        f.apply();
//        f.identity();
//        f.andThen();
    }


    private void apply() {

        Function<Integer, Integer> function1 = x -> x * 2;

        System.out.println(function1.apply(4));// 8

        Function<Integer, String> function2 = x -> x * 2 + "dd";
        System.out.println(function2.apply(4));//8dd

        Function<String, String> strFunction1 = (str) -> new String(str);
        System.out.println(strFunction1.apply("aa"));//aa

        Function<String, String> strFunction2 = String::new;
        System.out.println(strFunction2.apply("bb"));//bb

    }

    // 原函数,返回与参数一致的函数,即可以理解为 y = x.
    private void identity() {

        Function<Object, Object> function = Function.identity();
        System.out.println(function.apply(100));
        System.out.println(Function.identity().apply(100111));
        FunctionTest test = new FunctionTest();
        System.out.println(test == Function.identity().apply(test));
    }

    // 我们现在用Function.andThen()来实现一个函数:y = 10x + 10;
    // 组合函数,在调用当前function之后执行
    private void andThen() {

        Function<Integer,Integer> function = x -> x * 10;
        function = function.andThen(x -> x+10);
        System.out.println(function.apply(8));
    }


    //我们现在用Function.compose()来实现一个函数:y = 10 (10+x) + 10;
    //组合函数,在调用当前function之前执行
    private void compose() {

        Function<Integer,Integer> function = (x -> x * 10);
        function = function.compose(x -> x+10);
        function = function.andThen(x -> x+10);
        System.out.println(function.apply(8));
    }
}
