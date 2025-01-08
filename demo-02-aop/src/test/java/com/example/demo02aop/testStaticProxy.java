package com.example.demo02aop;

import com.example.demo02aop.ProxyStatic.MyCalculatorStaticProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testStaticProxy {
    @Autowired
    MyCalculatorStaticProxy myCalculatorStaticProxy;

    @Test
    void testStaticProxy(){
        myCalculatorStaticProxy.add(1,2);
    }
}
