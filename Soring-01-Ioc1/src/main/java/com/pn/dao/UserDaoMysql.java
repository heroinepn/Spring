package com.pn.dao;

public class UserDaoMysql implements UserDao{
//开始推到ioc 增添实现
    public void getUser() {
        System.out.println("我是Mysql");
    }
}
