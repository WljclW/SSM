package com.example.demo02aop.dynamic;

import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;

//@Component
/**
 * 这个类用来实现创建一个万能的代理类。。。唯一的静态方法会根据传进去的target对象创建它的动态代理类。
 * 动态代理类：要求被代理类必须实现接口，因为代理的也只是接口中的方法
 * */
public class DynamicProxy {
    public static Object newProxyInstance(Object target) {  //只需要传参数：被代理对象(即哪一个对象想被代理)
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //参数一：被代理类的类加载器
                target.getClass().getInterfaces(),  //参数二：被代理类实现的接口
                (proxy, method, args) -> {  //参数三：代理对象对应的 InvocationHandler
                    Object result = null;
                    System.out.println("日志"+method.getName()+"开始，参数是："+ Arrays.toString(args));
                    try {
                        result = method.invoke(target, args);   //调用被代理类的方法
                        System.out.println("方法正常返回"+method.getName()+"结果是："+result);
                    }catch (Exception e){
                        System.out.println("方法执行出现异常"+method.getName()+"出现异常"+e.getCause());
                    }
                    return result;
                });
    }
}

/**
 * Arrays.asList(args),如果args是null,会报空指针异常NullPointerException
 * 要改成Arrays.toString(args)
 * */