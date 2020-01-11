package com.github.huotaihe.springboot.learn.prsd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BookController
 * @Author huotaihe
 * @Date 2018/9/20 10:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/books")
public class BookController {

  @CacheLock(prefix = "books")
  @GetMapping
  public String query(@CacheParam(name = "token") @RequestParam String token) {
    return "success - " + token;
  }

}
