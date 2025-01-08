package com.example.demo01ioc.Bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:cat.properties")
@Data
@Component
public class Cat {
    @Value("${catnamemmmm:Tom}")
    private String name;
    @Value("${catageAge}")
    private int age;
}
