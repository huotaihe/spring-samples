package com.github.huotaihe.springboot.learn.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionTestController {

    @GetMapping("/setAtt")
    public String test(HttpSession session){
        session.setAttribute("age", "1");

        return "1";
    }

    @GetMapping("/getAtt")
    public String test2(HttpSession session) {
        String age = (String) session.getAttribute("age");

        return age;
    }
}
