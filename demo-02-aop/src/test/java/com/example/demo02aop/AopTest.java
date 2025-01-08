package com.example.demo02aop;

import com.example.demo02aop.calculator.impl.MyCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {
    @Autowired
    MyCalculator mathCalculator;

    @Test
    public void testAop(){
        System.out.println(mathCalculator);
        mathCalculator.add(1,2);
//        myCalculator.dev(10,0);
    }
}
