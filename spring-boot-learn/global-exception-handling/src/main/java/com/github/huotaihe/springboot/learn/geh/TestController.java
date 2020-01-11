package com.github.huotaihe.springboot.learn.geh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
  * @Author huotaihe
  * @Date 2018/9/11 18:18
  * @Version 1.0
  **/
@RestController
public class TestController {

  @GetMapping("/test")
  public String test(){
    int i = 10/0;
    return "test";
  }

  @GetMapping("/test3")
  public String test3(Integer num) {
    if (num == null) {
      throw new CustomException(400, "num不能为空");
    }
    int i = 10 / num;
    return "result:" + i;
  }

}
