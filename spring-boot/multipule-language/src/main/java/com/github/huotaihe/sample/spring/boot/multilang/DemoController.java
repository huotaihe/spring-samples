package com.github.huotaihe.sample.spring.boot.multilang;

import java.sql.Array;
import java.util.Locale;

import javax.annotation.Resource;

import com.google.common.escape.ArrayBasedUnicodeEscaper;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 寒溪
 * @date 2022/06/17
 */
@RestController
public class DemoController {

    @Resource
    private MessageSource messageSource;

    @GetMapping("/demo")
    public String helloWorld(@RequestParam("name") String name) {
        return messageSource.getMessage("hello.world", new String[] {name}, Locale.CHINA);
    }

}
