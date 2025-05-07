package com.example.demo02aop.Aspectj_review;

import org.springframework.stereotype.Component;

/**
 * @author mini-zch
 * @date 2025/5/7 9:43
 */
@Component
public class Target   {
    public String method01(String str1,String str2){
        System.out.println("被代理的方法正在执行中.......");
        System.out.println("Str1:"+str1);
        System.out.println("str2:"+str2);
//        int i = 10/0;
        System.out.println(str1+str2);
        return str1+str2;
    }
}
