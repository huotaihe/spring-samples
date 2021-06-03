package com.huotaihe.sample.spring.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 寒溪
 * @date 2021/06/02
 */
@RestController
public class MemberLevelController {

    @GetMapping("/member/level")
    public MemberLevelEnum getLevel() {
        return MemberLevelEnum.DIAMOND;
    }

    @GetMapping("/member/level2")
    public MemberLevelEnum setLevel(@RequestBody RequestVO request) {

        return request.getLevel();
    }

    @GetMapping("/member/level3")
    public MemberLevelEnum setLevel(MemberLevelEnum level) {

        return level;
    }

}
