package com.example.springstartdemo;

import com.example.robotspringbootstarter.RobotAutoConfiguration;
import com.example.robotspringbootstarter.annotation.EnableRobot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author: Zhou
 * @date: 2025/1/22 1:19
 *
 */
//@Import(RobotAutoConfiguration.class)     //第一档：引入自定义starter的 自动配置类
//@EnableRobot    //第二档：引入自定义starter的 注解(底层其实是注解做了“@Import(RobotAutoConfiguration.class)”的事)
    //第三档：什么都不用做，只用在pom中添加依赖即可。原理：在当前项目的文件\resources\META-INF\spring\org.springframework.boot.autoconfigure.AutoConfiguration.imports中写上自动配置类的全路径。
@SpringBootApplication
public class SpringStartDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStartDemoApplication.class, args);
    }

}
