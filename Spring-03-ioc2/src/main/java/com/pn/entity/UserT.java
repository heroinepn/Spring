package com.pn.entity;

public class UserT {
    private String name;
    public UserT() {
        //默认无参构造
        System.out.println("无参构造默认存在");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("UserT"+"\t"+name);
    }
}
