package com.example.demo02aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class Demo02AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo02AopApplication.class, args);
    }

}
