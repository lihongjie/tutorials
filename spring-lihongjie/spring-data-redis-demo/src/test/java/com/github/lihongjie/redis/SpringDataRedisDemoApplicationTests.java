package com.github.lihongjie.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataRedisDemoApplicationTests {

	@Autowired
	private RedisService redisService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void get() {

	}

	@Test
	public void set() {
		redisService.test();
	}

}
