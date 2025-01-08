package com.example.demo01ioc.Bean;

import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;


@PropertySource("application.properties")
@Data
@Component
public class Dog {
    public Dog(){
        System.out.println("Dog的构造器在执行。。。。。。。");
    }

    /**
     * 1.@Value("字面值")：直接赋值
     * 2.@Value("${}")：动态从配置文件获取值.
     *      如果配置文件中不存在动态的这个值，会报异常BeanCreationException：Injection
     *      of autowired dependencies failed..............然后还会出现类似信息：Could not
     *      resolve placeholder 'do.age' in value "${do.age}。。。。【说明：do.age就是那个
     *      出错的动态配置属性，配置文件中没有】
     * 3.@Value("#{SpEL}")：Spring Expression Language表达式语言
     *      解析表达式过程可能出现的异常：
     *      UnsatisfiedDependencyException：Unsatisfied dependency
     *      expressed through field 'msg': Expression parsing failed..........即解析表达式出错。
     *      再往后看，有更详细的信息(通常是在另一段中)： Method call: Method subString(java.lang.Integer,
     *      java.lang.Integer) cannot be found on type java.lang.String.......意思是说subString方法使用
     *      错了，没有在String类中找到。
     * */

    @Value("旺财")
    private String name;
    @Value("${dog.age}")
    private Integer age;
    @Value("#{10*20}")
    private String color;
    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String uuid;
    @Value("#{'Hello World!'.substring(0,5)}")
    private String msg;
    @Value("#{1>2?'hhaa':'hehhe'}")
    private String flag;

    /**
     * 程序中想要拿到uuid的话，需要执行语句：String uuid = UUID.randomUUID().toString();
     *
     * */

}
