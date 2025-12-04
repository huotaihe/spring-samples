package com.github.huotaihe.springboot;

import lombok.Data;

@Data
public class ResponseWrap<T> {
    private T data;
    private String errorMsg;

    public static <T> ResponseWrap<T> success(T data) {
        ResponseWrap<T> responseWrap = new ResponseWrap<>();
        responseWrap.setData(data);
        return responseWrap;
    }
}
