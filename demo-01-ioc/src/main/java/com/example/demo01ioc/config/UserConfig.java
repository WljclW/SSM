package com.example.demo01ioc.config;

import com.example.demo01ioc.Bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    /**
     * 在bean注解中指定初始化方法、销毁方法。。。效果等同于在xml文件中配置时的方式
     * */
    @Bean(initMethod = "initUser",destroyMethod = "destoryUser")
    public User user(){
        return new User();
    }
}
