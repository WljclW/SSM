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

    /**
     * 静态代理：朴素理解就是一种内部持有的关系。
     * 这种思想在rocketmq的源码中常见，比如：DefaultProducerImpl类，里面持有DefaultMQProducer对象。。。
     * */
    private MathCalculator target; //目标对象。用接口来声明字段

    public MyCalculatorStaticProxy(MathCalculator mc){
        this.target = mc;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("静态代理方法执行前的开始操作........");
        int res = target.add(i,j);  //会调用被代理对象的同名方法
        System.out.println("静态代码在方法执行后的操作.........");
        return  res;
    }
    /*
    * 像add方法一样，下面的sub、mutil、dev方法也一样.可以在调用被代理类的方法前和后执行一些额外的操作
    * */

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
