package com.example.demo02aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(100)
@Component      //必须加这个注解，spring才会将这个类纳入ioc容器，自己管理
@Aspect     //必须加这个注解，告诉spring这是一个切面
public class LogAspect {
    /**
     * 1.需要在自己的类中来实现不同的切面逻辑；然后告诉spring何时何地去执行这些方法
     * 2.何时？
     *      @Before:方法执行之前执行该注解的方法
     *      @AfterReturning:方法正常执行 并且 返回之后 执行
     *      @AfterThrowing:方法执行时抛出异常时 执行此注解注解的方法
     *      @After:方法执行结束(正常结束和异常结束)都执行此注解的方法
     * 3.何地？
     *      结果表达式。
     *      excute(方法的全签名)
     *          全签名的全写法比如：
     *          public int com.example.demo02aop.calculator.MathCalculator.add(int i,int j) throw 异常名
     * 4.通知方法的执行顺序
     *    1)正常情况下：前置通知(@Before)——方法执行——返回通知(@AfterReturning)——方法结束通知(@After)
     *    2)出现异常时：前置通知(@Before)——方法执行——返回通知(@AfterThrowing——方法结束通知(@After)
     *
     * JoinPoint joinPoint:连接点中包含方法的信息
     * */

    //参数带什么就切
    @Before("args(int,int)")
    public void haha(){
        System.out.println("【切面 - 日志】开始执行......方法执行前,hahah");
    }

    @Before("execution(int *(int,int))")
    public void logStart(JoinPoint joinPoint){
        /**
         * JoinPoint参数包装了目标方法的详细信息
         * */
        String name = joinPoint.getSignature().getName();
        System.out.println("方法名称"+name);
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("【切面 - 日志】开始执行......方法执行前");
    }

    @After("execution(int add(int,int))")
    public void logEnd(){
        System.out.println("【切面 - 日志】开始执行........方法结束");
    }

    @AfterReturning("args(int,int)")    //只要参数是两个int类型的方法，方法return之后就会执行
    public void logReturn(){
        System.out.println("【切面 - 日志】开始执行........方法正常返回");
    }

    @AfterThrowing("args(int,int)")
    public void logThrowing(){
        System.out.println("【切面 - 日志】开始执行........方法抛出异常");
    }
}
