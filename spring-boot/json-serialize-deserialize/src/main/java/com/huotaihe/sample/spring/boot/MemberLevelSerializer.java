package com.huotaihe.sample.spring.boot;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;

/**
 * @author 寒溪
 * @date 2021/06/02
 */
@JsonComponent
public class MemberLevelSerializer extends StdSerializer<MemberLevelEnum> {
    protected MemberLevelSerializer() {
        super(MemberLevelEnum.class);
    }

    @Override
    public void serialize(MemberLevelEnum memberLevelEnum, JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(memberLevelEnum.getName());
    }
}
