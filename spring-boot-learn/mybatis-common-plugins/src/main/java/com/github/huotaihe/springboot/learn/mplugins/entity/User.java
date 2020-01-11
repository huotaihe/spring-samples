package com.github.huotaihe.springboot.learn.mplugins.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "user")
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 8655851615465363473L;

  public User(String name, int age){
    this.name = name;
    this.age = age;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int age;
}
