package com.example.demo01ioc.Bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * bean的外卦修改器：BeanPostProcessor接口，因为它的两个抽象方法都有返回值，其他这里提到的
 * 都是没有返回值的————顶多能叫回调感知，也就是说到哪一个阶段的时候能干一些事
 */
@Data
public class User implements InitializingBean, DisposableBean {

    private String username;

    private String password;

    private Car car;

    @Autowired  //set注入
    public void setCar(Car car){
        this.car = car;
        System.out.println("【标记User】User属性注入完成.........");
    }

    static {    //静态代码块
        System.out.println("【标记User】User的静态代码块执行中...........");
    }

    public User(){  //构造器执行
        System.out.println("【标记User】User的构造器在执行中..........");
    }

    public void initUser(){     //将来在bean的注解中添加的初始化方法
        System.out.println("【标记User】User的init方法执行中.............");
    }

    public void destoryUser(){  //将来在bean的注解中添加的销毁方法
        System.out.println("【标记User】User的destory方法执行中。。。。。。。");
    }

    @Override       //InitializingBean接口唯一的抽象方法
    public void afterPropertiesSet() throws Exception {
        //属性注入之后执行
        System.out.println("【标记User】InitializingBean接口的afterPropertiesSet方法.......");
    }


    @Override   //DisposableBean接口唯一的抽象方法
    public void destroy() throws Exception {
        System.out.println("【标记User】DisposableBean接口的destroy方法.........");
    }

    @PostConstruct  //注解
    public void PostConstruct(){
        System.out.println("【标记User】PostConstruct注解...........");
    }

    @PreDestroy     //注解
    public void PreDestroy(){
        System.out.println("【标记User】PreDestroy注解........");
    }
}
