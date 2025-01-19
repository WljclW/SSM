package com.example.springboot01demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 演示：如何在yaml文件中，指定bean的属性(重点是可以指定数组、列表、对象等属性)
 * */
//@Profile("dev") # 基于环境标识进行判断，如果当前处于什么环境就配置什么组件、或者开启什么配置
//@Profile("prod")
@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    private String name;
    private Integer age;
    private Date birthDay;
    private Boolean like;
    private Child child;    //内部引用类型的属性
    private List<Dog> dogs;     //列表属性：元素是Dog类型
    private Map<String, Cat> cats;      //集合属性：key是String，value是Cat类型
}

@Data
class Dog {
    private String name;
    private Integer age;
}

@Data
class Child {
    private String name;
    private Integer age;
    private Date birthDay;
    private List<String> text;
}

@Data
class Cat {
    private String name;
    private Integer age;
}
