package com.github.lihongjie.currency.playground;

/**
 * Runtime的shutdown的示例
 */
public class TestShutdown1 {

    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(new ShutdownHookThread());

        System.out.println("Now main sleeping... press ctrl+c to exit");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }


}
