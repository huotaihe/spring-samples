package com.github.huotaihe.springboot.learn.drl;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LimiterController
 * @Author huotaihe
 * @Date 2018/9/20 13:35
 * @Version 1.0
 **/
@RestController
public class LimiterController {

  private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

  @Limit(key = "test", period = 100, count = 10)
  @GetMapping("/test")
  public int testLimiter() {
    // 意味著 100S 内最多允許訪問10次
    return ATOMIC_INTEGER.incrementAndGet();
  }
}
