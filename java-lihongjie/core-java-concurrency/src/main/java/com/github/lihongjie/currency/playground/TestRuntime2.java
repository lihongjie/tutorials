package com.github.lihongjie.currency.playground;

/**
 * 运行后将会关机
 */
public class TestRuntime2 {

    public static void main(String args[]) throws Exception {
        
        Runtime.getRuntime().exec("shutdown -s -t 0");
    }
}
