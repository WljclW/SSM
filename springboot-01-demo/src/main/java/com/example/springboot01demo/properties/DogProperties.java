package com.example.springboot01demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 演示：通过引入xxxProperties类，实现配置文件的属性的绑定
 * */
@ConfigurationProperties(prefix = "dog")    //指定配置文件中 属性设定的前缀
@Component
@Data
public class DogProperties {
    private String name;
    private Integer age;
    private String gender;
}
