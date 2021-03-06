package com.github.lihongjie.currency.playground;

/**
 * 测试 System.gc()方法
 */
public class TestGarbage1 {


    @Override
    public void finalize() {
        System.out.println("object is garbage collected");
    }

    public static void main(String args[]) {
        TestGarbage1 s1 = new TestGarbage1();
        TestGarbage1 s2 = new TestGarbage1();
        s1 = null;
        s2 = null;
        System.gc();
    }


}
