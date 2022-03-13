package com.huotaihe.sample.spring.boot;

import lombok.Getter;

/**
 * @author 寒溪
 * @date 2021/06/02
 */
public enum MemberLevelEnum {

    GOLD(0, "黄金会员"), PLATINUM(40, "铂金会员"), DIAMOND(80, "钻石会员");

    @Getter
    private final Integer code;

    @Getter
    private final String name;

    MemberLevelEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
