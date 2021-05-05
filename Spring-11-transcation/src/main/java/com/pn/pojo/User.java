package com.pn.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String pwd;

    public User(int id, String name, String pwd) {
    }
}

