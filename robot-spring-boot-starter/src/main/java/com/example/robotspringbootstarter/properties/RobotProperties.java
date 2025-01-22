package com.example.robotspringbootstarter.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  //
@ConfigurationProperties(prefix = "robot")  // 指定配置文件中的前缀，按照这些前缀来获取对应的属性值
@Data   // lombok注解，自动生成getter和setter方法。保证在配置文件中的属性值可以正确地映射到Java对象 以及 从Java对象获取对象
public class RobotProperties {
    private String name;
    private String model;
}
