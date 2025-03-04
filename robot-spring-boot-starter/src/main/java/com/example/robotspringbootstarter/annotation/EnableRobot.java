package com.example.robotspringbootstarter.annotation;

import com.example.robotspringbootstarter.RobotAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 【作用】模仿其他的注解，为当前的自定义starter创建一个注解
 * 【特征】在自定义注解上"@Import(RobotAutoConfiguration.class)"————即让这个注解去完成import自动配置类的操作
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RobotAutoConfiguration.class) //在注解上继承此，导入自动配置类
public @interface EnableRobot {

}
