package com.example.demo01ioc.dao;

import com.example.demo01ioc.Bean.Dog;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class UserDao {


//    Dog hah;
//
//    @Autowired
//    public void setDog(@Qualifier("dog01") Dog dog){
//        System.out.println("进入到set方法啦");
//        this.hah = dog;
//    }
}
