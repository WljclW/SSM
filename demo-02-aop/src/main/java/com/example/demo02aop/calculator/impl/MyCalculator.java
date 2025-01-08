package com.example.demo02aop.calculator.impl;

import com.example.demo02aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

@Component
public class MyCalculator implements MathCalculator {
    /**
     * 实现日志：
     *      1. 硬编码：
     *      2。静态代理：定义一个代理操作，包装这个组件。业务的执行从代理开始。
     *          【特点】在编译期间就知道了明确的代理关系；
     *      3.动态代理：运行期间才决定好代理关系(拦截器，拦截所有)
     *          目标对象在执行期间会被拦截，插入指定逻辑
     *          优点：可以代理世间万物
     *          缺点：
     * */

    @Override
    public int add(int i, int j) {
        int res = i+j;
        System.out.println("原始的方法中执行，执行结果是"+res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i-j;
        return res;
    }

    @Override
    public int mutil(int i, int j) {
        int res = i*j;
        return res;
    }

    @Override
    public int dev(int i, int j) {
        int res = i/j;
        return res;
    }
}
