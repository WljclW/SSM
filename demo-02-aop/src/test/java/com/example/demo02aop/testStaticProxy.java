package com.example.demo02aop;

import com.example.demo02aop.ProxyStatic.MyCalculatorStaticProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testStaticProxy {
    @Autowired
    MyCalculatorStaticProxy myCalculatorStaticProxy; //直接用静态代理类去计算加法，而不是使用 被代理类对象

    @Test
    void testStaticProxy(){
        myCalculatorStaticProxy.add(1,2);
    }
}
