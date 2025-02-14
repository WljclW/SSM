package com.example.demo02aop;

import com.example.demo02aop.calculator.impl.MyCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {  //aspect包的测试，这个包下的程序实现对"MathCalculator接口中所有方法"的切入逻辑
    @Autowired
    MyCalculator mathCalculator;

    @Test
    public void testAop(){
        System.out.println(mathCalculator);
        mathCalculator.add(1,2);
//        myCalculator.dev(10,0);
    }
}
