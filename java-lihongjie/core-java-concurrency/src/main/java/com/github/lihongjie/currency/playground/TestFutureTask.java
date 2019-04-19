package com.github.lihongjie.currency.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 利用FutureTask执行多任务计算
 */
public class TestFutureTask {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //存储执行的任务数
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int index = i;
            FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("开始计算...");
                    int result = 10 * 10 + 1; // 计算任务
                    Thread.sleep(2000);
                    System.out.println("子线程: " + index + " 执行完成, 子线程计算结果为: " + result);
                    return result;
                }
            });
            // 添加任务，方便后面任务阻塞
            futureTasks.add(task);
            System.out.println("开始执行任务...");
            executorService.submit(task);
        }

        System.out.println("子线程提交完成...");
        int result = 0;
        for (FutureTask<Integer> task : futureTasks) {
            try {
                // 阻塞子线程执行计算，等待所有子线程执行完成后，解除阻塞Future对象
                result += task.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("多任务计算结果为： " + result);

    }
}
