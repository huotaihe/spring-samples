package com.github.huotaihe.springboot;

import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice {
    @Override
    public @Nullable Map<String, Object> determineWriteHints(@Nullable Object body, MethodParameter returnType,
        MediaType selectedContentType, Class selectedConverterType) {
        return ResponseBodyAdvice.super.determineWriteHints(body, returnType, selectedContentType,
            selectedConverterType);
    }

    @Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType,
        MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request,
        ServerHttpResponse response) {
        if (body instanceof ResponseWrap) {
            return body;
        }
        return ResponseWrap.success(body);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getParameterType() != ResponseWrap.class;
    }
}
