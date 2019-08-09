package com.github.lihongjie.redis.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class DemoController {

    @Autowired
    private Redisson redisson;

    @GetMapping("/redisson")
    public ResponseEntity test() throws InterruptedException {

        RLock lock = redisson.getLock("anyLock");

        //redisson 使用方式一

        // 加锁以后10秒钟自动解锁
        // 无需调用unlock方法手动解锁
//        lock.lock(10, TimeUnit.SECONDS);

        //redisson 使用方式二

        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (res) {
            try {

            } finally {
                lock.unlock();
            }
        }


        return ResponseEntity.ok().build();
    }

}
