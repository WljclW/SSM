package com.example.demo02aop.ProxyStatic;

import com.example.demo02aop.calculator.MathCalculator;
import com.example.demo02aop.calculator.impl.MyCalculator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyCalculatorStaticProxy implements MathCalculator {

//    @Autowired
//    private MyCalculator target;

    private MathCalculator target; //目标对象

    public MyCalculatorStaticProxy(MathCalculator mc){
        this.target = mc;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("静态代理方法执行前的开始操作........");
        int res = target.add(i,j);
        System.out.println("静态代码在方法执行后的操作.........");
        return  res;
    }

    @Override
    public int sub(int i, int j) {
        int res = target.sub(i,j);
        return res;
    }

    @Override
    public int mutil(int i, int j) {
        int res = target.mutil(i,j);
        return res;
    }

    @Override
    public int dev(int i, int j) {
        int res = target.dev(i,j);
        return  res;
    }
}
