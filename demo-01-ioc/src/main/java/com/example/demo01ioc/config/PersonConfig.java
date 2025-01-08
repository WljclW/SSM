package com.example.demo01ioc.config;

import com.example.demo01ioc.Bean.Person;
import com.example.demo01ioc.Condition.WindowCondition;
import org.springframework.context.annotation.*;


/**
 * 说明：如果所有需要注入的bean都直接写在Demo01IocApplication，显的很乱。因此
 *      需要通过“配置”来实现，配置的方式很多，比如：使用maven需要配置文件、使用
 *      数据源时配置文件(指定地址端口密码等信息)。
 *      在spring中可以通过注解 @Configuration 来实现配置
 * */
@Configuration  //告诉Spring这是一个配置类
public class PersonConfig {
    //向容器内注册一个名字是 zhangsan 的bean。

    @Lazy
    @Bean("zhangsanName")
    public Person zhangsan(){
        Person person = new Person();
        person.setAge(17);
        person.setGender("nan");
        person.setName("zhangsan2");
        return person;
    }


    @Primary
   @Bean
    public Person haha(){
        Person person = new Person();
        person.setAge(99);
        person.setGender("nv");
        person.setName("我的名字是哈哈");
        return person;
    }

    /**
     * 判断是windows系统放入比尔盖茨，mac系统放入乔布斯
     * */
    @Conditional(WindowCondition.class)
    @Bean
    public Person bill(){
        Person person = new Person();
        person.setAge(17);
        person.setGender("nan");
        person.setName("billllll");
        return person;
    }

    @Conditional(WindowCondition.class)
    @Bean
    public Person qiaobusi(){
        Person person = new Person();
        person.setAge(17);
        person.setGender("nan");
        person.setName("qiaobusi");
        return person;
    }
}
