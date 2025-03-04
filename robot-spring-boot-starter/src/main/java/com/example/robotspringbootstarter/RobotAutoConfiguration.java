package com.example.robotspringbootstarter;

import com.example.robotspringbootstarter.controller.RobotController;
import com.example.robotspringbootstarter.properties.RobotProperties;
import com.example.robotspringbootstarter.services.RobotService;
import com.example.robotspringbootstarter.services.impl.RobotServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 【总述】这个配置类的作用就是将当前starter所需要的组件注入。。。
 * 最终目的：在引入此场景的工程中，@import这个自动配置类，则当前的starter的功能就能调用了
 * */
@Configuration
public class RobotAutoConfiguration {

    @Bean
    public RobotService robotService(){
        return new RobotServiceImpl();
    }

    @Bean
    public RobotProperties robotProperties(){
        return new RobotProperties();
    }

    @Bean
    public RobotController robotController(){
        return new RobotController();
    }
}
