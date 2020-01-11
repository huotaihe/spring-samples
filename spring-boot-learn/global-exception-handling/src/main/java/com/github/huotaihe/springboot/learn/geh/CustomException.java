package com.github.huotaihe.springboot.learn.geh;

/**
 * 自定义异常
 *
 * @ClassName CustomException
 * @Author huotaihe
 * @Date 2018/9/11 18:21
 * @Version 1.0
 **/
public class CustomException  extends RuntimeException {

  private static final long serialVersionUID = 4564124491192825748L;

  private int code;

  public CustomException() {
    super();
  }

  public CustomException(int code, String message) {
    super(message);
    this.setCode(code);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
