package com.pn.entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//等价于<bean id="user" class="com.kuang.pojo.User"/>
public class User {
    //相当于  <property name="name" value="pn"/>
    //可注解在set方法上
    @Value("pn")
    public String name;
//    @Value("pn")
//    public void setName(String name) {
//        this.name = name;
//    }
}

