package com.github.huotaihe.springboot.learn.cache.redis;

import com.github.huotaihe.springboot.learn.cache.redis.entity.User;
import com.github.huotaihe.springboot.learn.cache.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CacheRedisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserService userService;


	@Test
	public void get() {
		final User user = userService.saveOrUpdate(new User(5L, "u5", "p5"));
		log.info("[saveOrUpdate] - [{}]", user);
		final User user1 = userService.get(5L);
		log.info("[get] - [{}]", user1);
		userService.delete(5L);
	}

  @Test
  public void get2() throws InterruptedException {
	  User user1 = userService.get(1L);
    log.info("user1 {}", user1);
    User user2 = userService.get(1L);
    log.info("user2 {}", user2);
    Thread.sleep(10 * 1000);

    User user3 = userService.get(1L);
    log.info("user3 {}", user3);

  }

}
