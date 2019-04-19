package com.github.lihongjie.currency.playground;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallableFuture {

    public static void main(String[] args) {

        CallableDemo callableDemo = new CallableDemo();

        FutureTask<Integer> future = new FutureTask<>(callableDemo);

        System.out.println("starting ....");
        // 创建一个计算线程
        new Thread(future).start();

        try {
            // 在计算线程未完成时，一直阻塞Future对象.
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("end ....");

    }


    static class CallableDemo implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += i;
                System.out.println("sum is " + sum);
            }
            return sum;
        }
    }


/**
 没有调用future.get()方法时，执行输出 如下：
 starting ....
 end ....
 sum is 0
 sum is 1
 sum is 3

调用future.get()方法时，执行输出 如下：
 starting ....
 sum is 0
 sum is 1
 sum is 3
 end ....

 Future是底层基于协作的，更方便的，更结构化的封装，在调用get()方法时，会自动地阻塞，以便于启动的一个线程或多个线程在计算完成时解除阻塞Future对象。

 */
}
