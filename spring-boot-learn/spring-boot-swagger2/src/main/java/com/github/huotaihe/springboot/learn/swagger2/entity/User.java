package com.github.huotaihe.springboot.learn.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel
@Data
@AllArgsConstructor
public class User implements Serializable {

  private static final long serialVersionUID = 8655851615465363473L;

  private Long id;
  @ApiModelProperty("用户名")
  private String username;
  @ApiModelProperty("密码")
  private String password;
}