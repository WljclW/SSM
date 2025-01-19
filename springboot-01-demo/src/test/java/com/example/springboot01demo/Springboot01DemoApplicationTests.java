package com.example.springboot01demo;

import com.example.springboot01demo.bean.Person;
import com.example.springboot01demo.properties.DogProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01DemoApplicationTests {

    @Autowired
    DogProperties dogProperties;
    @Test
    void contextLoads() {
        System.out.println(dogProperties);
    }

    @Autowired
    Person person;
    @Test
    void testYaml(){
        System.out.println(person);
    }

}
