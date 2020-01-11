package com.github.huotaihe.springboot.learn.geh;

import lombok.Data;

/**
 * @ClassName ErrorResponseEntity
 * @Author huotaihe
 * @Date 2018/9/11 18:22
 * @Version 1.0
 **/
@Data
public class ErrorResponseEntity {

  private int code;
  private String message;

  public ErrorResponseEntity(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
