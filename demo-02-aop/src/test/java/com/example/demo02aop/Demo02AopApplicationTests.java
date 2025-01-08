package com.example.demo02aop;

import com.example.demo02aop.ProxyStatic.MyCalculatorStaticProxy;
import com.example.demo02aop.calculator.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo02AopApplicationTests {

    @Autowired
    MathCalculator mathCalculator;


    @Test
    void contextLoads() {
        System.out.println(mathCalculator.add(1, 2));
    }

}
