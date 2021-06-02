package com.huotaihe.sample.spring.boot;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.boot.jackson.JsonComponent;

/**
 * @author 寒溪
 * @date 2021/06/02
 */
@JsonComponent
public class MemberLevelDeserializer extends StdDeserializer<MemberLevelEnum> {
    protected MemberLevelDeserializer() {
        super(MemberLevelEnum.class);
    }

    @Override
    public MemberLevelEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {
        for (MemberLevelEnum level : MemberLevelEnum.values()) {
            if(level.getCode().equals(jsonParser.getNumberValue())){
                return level;
            }
        }

        return null;
    }
}
