package com.pn.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;


public class People {
    @Autowired
    @Qualifier(value = "cat1")//若同类型的bean多，叠加buffer更易注入改为ByName类型
    private Cat cat;
    @Resource(name = "dog1")
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }
//
//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }

    public Dog getDog() {
        return dog;
    }

//    public void setDog(Dog dog) {
//        this.dog = dog;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
