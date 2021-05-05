package com.pn.demo04;

import com.pn.demo02.UserServiceImpl;
import com.pn.demo02.UserService;



public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色：不存在
        proxy2 pih = new proxy2();

        //设置要代理的对象
        pih.setTarget(userService);
        //动态生成代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.add();

    }
}

