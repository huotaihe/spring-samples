package com.github.huotaihe.springboot.learn.prsl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BookController
 * @Author huotaihe
 * @Date 2018/9/12 10:52
 * @Version 1.0
 **/
@RestController
@RequestMapping("/books")
public class BookController {

  @LocalLock(key = "book:arg[0]")
  @GetMapping
  public String query(@RequestParam String token) {
    return "success - " + token;
  }
}
