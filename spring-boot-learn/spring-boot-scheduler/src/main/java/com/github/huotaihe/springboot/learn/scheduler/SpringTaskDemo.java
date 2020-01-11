package com.github.huotaihe.springboot.learn.scheduler;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringTaskDemo
 * @Author huotaihe
 * @Date 2019-03-25 17:45
 * @Version 1.0
 **/
@Component
public class SpringTaskDemo {

  private static final Logger log = LoggerFactory.getLogger(SpringTaskDemo.class);

//  @Async
  @Scheduled(cron = "0/1 * * * * *")
  public void scheduled1() throws InterruptedException {
    long id = Thread.currentThread().getId();
    log.info("id {} init", id);
    Thread.sleep(3000);
    log.info("scheduled1 每1秒执行一次：{}", LocalDateTime.now());
    log.info("id {} exit", id);
  }

//  @Scheduled(fixedRate = 1000)
//  public void scheduled2() throws InterruptedException {
//    long id = Thread.currentThread().getId();
//    log.info("id {} init", id);
//    Thread.sleep(3000);
//    log.info("scheduled2 每1秒执行一次：{}", LocalDateTime.now());
//    log.info("id {} exit", id);
//  }
//
//  @Scheduled(fixedDelay = 3000)
//  public void scheduled3() throws InterruptedException {
//    Thread.sleep(5000);
//    log.info("scheduled3 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
//  }

}
