package com.huotaihe.sample.spring.boot;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

/**
 * @author 寒溪
 * @date 2021/06/02
 */
public enum MemberLevelEnum2 {

    GOLD(0, "黄金会员"), PLATINUM(40, "铂金会员"), DIAMOND(80, "钻石会员");

    @Getter
    private final Integer code;

    @Getter
    private final String name;

    MemberLevelEnum2(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @JsonCreator
    public static MemberLevelEnum2 getEnum(String code){

        for (MemberLevelEnum2 level : MemberLevelEnum2.values()) {
            if(level.getCode().equals(Integer.valueOf(code))){
                return level;
            }
        }

        return null;
    }
}
