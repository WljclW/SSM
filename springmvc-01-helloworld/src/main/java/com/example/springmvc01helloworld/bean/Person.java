package com.example.springmvc01helloworld.bean;

import lombok.Data;

//对应的请求信息：http://localhost:8080/handle06?username=zhoudezi&password=1234&cellphone=098765&address.province=%E5%B1%B1%E8%A5%BF%E7%9C%81&address.city=%E8%A5%BF%E5%AE%89&address.area=%E8%8E%B2%E6%B9%96%E5%8C%BA&sex=%E7%94%B7&hobby=%E8%B6%B3%E7%90%83&hobby=%E4%B9%92%E4%B9%93%E7%90%83&grade=%E4%B8%89%E5%B9%B4%E7%BA%A7&agreement=on
/**
 * @description: 测试级联封装的person类
 * @param null:
 * @return
 * @author: Zhou
 * @date: 2024/12/21 17:07
 */
@Data
public class Person {
    private String username;
    private String password;
    private String cellphone;
    private boolean agreement;
    private Adress adress;
    private String[] hobby;
}


@Data
class Adress{
    private String province;
    private String city;
    private String area;
}
