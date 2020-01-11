package com.github.huotaihe.springboot.learn.web;

/**
 * HelloDomain
 *
 * @author: huotaihe
 * @Date: 10:26 2019-12-05
 **/
public class HelloDomain {
    private String name;

    private int age;

    public HelloDomain(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
