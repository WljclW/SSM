package com.example.demo01ioc.Bean;

import lombok.Data;
import org.springframework.context.annotation.Scope;

@Data
public class Person {
    public Person(){
        System.out.println("调用了Person的构造器");
    }

    private String name;
    private int age;
    private String gender;
}
