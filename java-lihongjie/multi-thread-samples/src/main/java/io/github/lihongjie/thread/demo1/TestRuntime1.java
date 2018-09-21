package io.github.lihongjie.thread.demo1;

/**
 * Runtime exec() method
 */
public class TestRuntime1 {

    public static void main(String args[]) throws Exception {
        Runtime.getRuntime().exec("notepad");//will open a new notepad
    }
}
