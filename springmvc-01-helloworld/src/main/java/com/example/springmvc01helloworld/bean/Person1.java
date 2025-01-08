package com.example.springmvc01helloworld.bean;

import lombok.Data;

@Data
public class Person1 {
    //http://localhost:8080/handle01?userName=zhangsan&passWord=lisi&cellphone=1234&agreement=true
    private String username;
    private String password;
    private String cellphone;
    private boolean agreement;
}
