package com.example.demo02aop.AspectJ;/**
 * @author luck-jay
 * @date 2025/2/6 14:50
 */

import org.springframework.stereotype.Component;

/**
 * @author mini-zch
 * @date 2025/2/6 14:50
 */
@Component
public class TargetClass {

    public String targetMethod(String str1,String str2){
        System.out.println("被代理对象的方法-----------targetClass.targetMethod");
        System.out.println(str1+str2);
//        int i = 10/0;
        return str1+str2;
    }
}
