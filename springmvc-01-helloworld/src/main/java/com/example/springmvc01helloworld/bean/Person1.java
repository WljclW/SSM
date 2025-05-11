package com.example.springmvc01helloworld.bean;

import lombok.Data;

@Data
public class Person1 {
    /*下面的两个地址，演示url中除了域名(也就是IP地址对应的)以外，其他的信息是区分大小写的。。其中userName和username是区分大小写的*/
    //http://localhost:8080/handle03?userName=zhangsan&passWord=lii&cellphone=1234&agreement=true
    //http://localhost:8080/handle03?username=zhangsan&password=lii&cellphone=1234&agreement=true
    /*   这个地址也是错误的，访问时报错400，因为agreement是布尔类型，但是ture写错了。
    http://localhost:8080/handle03?username=zhangsan&password=111111&cellphone=222222&agreement=ture
     */
    private String username;
    private String password;
    private String cellphone;
    private boolean agreement;
}
