package com.github.huotaihe.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/demo")
public class DemoController {


    @GetMapping("/pojo")
    public UserVO pojo() {
        return new UserVO("huotaihe", 18);
    }

    @GetMapping("/pojo/wrap")
    public ResponseWrap<UserVO> pojoWrap() {
        return ResponseWrap.success(new UserVO("huotaihe", 18));
    }

}
