package com.github.lihongjie.currency.playground;

/**
 * 测试gc后的可用内存
 */
public class TestRuntimeMemory {

    public static void main(String args[]) throws Exception {
        Runtime r = Runtime.getRuntime();
        System.out.println("Total Memory: " + r.totalMemory());
        System.out.println("Free Memory: " + r.freeMemory());

        for (int i = 0; i < 10000; i++) {
            new TestRuntimeMemory();
        }
        System.out.println("After creating 10000 instance, Free Memory: " + r.freeMemory());
        System.gc();
        System.out.println("After gc(), Free Memory: " + r.freeMemory());
    }
}
