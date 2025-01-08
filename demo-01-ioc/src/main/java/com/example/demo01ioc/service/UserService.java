package com.example.demo01ioc.service;


import com.example.demo01ioc.Bean.Person;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {

    /**
     * 方法1：利用Qualifier注解
     * */
    @Qualifier("zhangsanName")
    @Autowired
    Person person;

    /**
     * 方法2：让本身变量名 就是 bean的name
     * */
    @Qualifier("bill")
    @Autowired
    Person bill;

   @Autowired
    Person person1;
}
