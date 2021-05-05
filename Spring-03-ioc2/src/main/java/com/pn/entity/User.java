package com.pn.entity;

public class User {
    private String name;
/*
    public User() {
       //默认无参构造
        System.out.println("无参构造默认存在");
    }*/
    //使用有参构造下标为0
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("hello"+"\t"+name);
    }
}
