package io.github.lihongjie.thread.demo1;

/**
 * 运行后将会关机
 */
public class TestRuntime2 {

    public static void main(String args[]) throws Exception {
        
        Runtime.getRuntime().exec("shutdown -s -t 0");
    }
}
