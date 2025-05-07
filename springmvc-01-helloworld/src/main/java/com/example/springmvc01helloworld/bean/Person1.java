package com.example.springmvc01helloworld.bean;

import lombok.Data;

@Data
public class Person1 {
    /*下面的两个地址，演示url中除了域名(也就是IP地址对应的)以外，其他的信息是区分大小写的。。其中userName和username是区分大小写的*/
    //http://localhost:8080/handle01?userName=zhangsan&passWord=lii&cellphone=1234&agreement=true
    //http://localhost:8080/handle03?username=zhangsan&password=lii&cellphone=1234&agreement=true
    private String username;
    private String password;
    private String cellphone;
    private boolean agreement;
}
