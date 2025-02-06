package com.example.demo02aop;

import com.example.demo02aop.calculator.MathCalculator;
import com.example.demo02aop.calculator.impl.MyCalculator;
import com.example.demo02aop.dynamic.DynamicProxy;
import com.example.demo02aop.service.UserService;
import com.example.demo02aop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

@SpringBootTest
public class calculatorDamicProxy {

    @Autowired
    MyCalculator myCalculator;

    @Test
    void testDynamic(){
        UserServiceImpl userService = new UserServiceImpl();
        UserService o = (UserService) DynamicProxy.newProxyInstance(userService);
        o.saveUser();
        System.out.println("==============测试dev方法的执行=================");
        MathCalculator o1 = (MathCalculator)DynamicProxy.newProxyInstance(myCalculator);
        o1.dev(10,0);
    }



    @Test
    void test01(){
        //原生对象执行
//        myCalculator.add(1,2);

        /**
         * 动态代理参数：
         * 1.
         * 2.
         * 3.InvocationHandler：
         * */

        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * @description:
             * @param : proxy——代理对象，明星的经纪人；
             *          method——准备调用的目标对象的方法
             *          args————方法执行的参数
             * @return void
             * @author: Zhou
             * @date: 2024/12/14 13:29
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(myCalculator, args);
                return null;
            }
        };

        /**
         * 可以：
         *      在执行方法前修改方法的参数、甚至可以选择不执行方法
         * */
        //lamda表达式的写法
        InvocationHandler ihx = (proxy,method,args)->{
            System.out.println("修改前的参数："+ Arrays.asList(args));
            System.out.println("动态代理在执行中。。。。。。。。。");
            args[0] = 0;
            System.out.println("修改后的参数："+Arrays.asList(args));
            System.out.println("原始方法执行前打印日志..........");
            method.invoke(myCalculator,args);   //执行 被代理类的方法
            System.out.println("原始方法执行后打印日志..........");
            return 0;
        };


        MathCalculator o = (MathCalculator)Proxy.newProxyInstance(
                myCalculator.getClass().getClassLoader(),   //参数一：被代理类的类加载器
                myCalculator.getClass().getInterfaces(),    //参数二：被代理类实现的接口
                ihx                                          //参数三：代理对象对应的 InvocationHandler
        );
        System.out.println(o.add(1, 2));
    }
}
