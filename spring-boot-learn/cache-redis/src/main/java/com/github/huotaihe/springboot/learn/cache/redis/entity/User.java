package com.github.huotaihe.springboot.learn.cache.redis.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User implements Serializable {

  private static final long serialVersionUID = 8655851615465363473L;
  private Long id;
  private String username;
  private String password;
}
