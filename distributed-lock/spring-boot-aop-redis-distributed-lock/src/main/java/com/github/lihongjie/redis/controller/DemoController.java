package com.github.lihongjie.redis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {



    @GetMapping("/test")
    @cn.itweknow.sbaop.annotation.DistributeLock(key = "test_#{baseRequest.channel}", timeout = 10)
    public ResponseEntity test() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

}
