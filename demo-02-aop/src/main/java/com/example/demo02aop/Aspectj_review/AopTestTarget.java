package com.example.demo02aop.Aspectj_review;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author mini-zch
 * @date 2025/5/7 9:45
 */

@Component
@Aspect
public class AopTestTarget {
    @Pointcut("execution(* com.example.demo02aop.Aspectj_review.Target.*(..))")
    public void flag(){
    }
//
//    @Before("flag()")
//    public void before_logic(){
//        System.out.println("【before_logic】aspectj的前置逻辑");
//    }
//
//
//    @Before("flag()")
//    public void before_logic01(JoinPoint jp,String str){
//        System.out.println("【before_logic01】aspectj的前置逻辑");
//
//        System.out.println(jp.getSignature().getClass());
//        System.out.println(jp.getArgs());
//        Object[] args = jp.getArgs();
//        for (Object i:args){
//            System.out.println(i);
//        }
//        args[0] = "890";
//        System.out.println(jp.getKind());
//        System.out.println(jp.getStaticPart());
//        System.out.println(jp.getClass());
//        System.out.println(jp.getTarget().getClass());
//        System.out.println(jp.getThis().getClass());
//        System.out.println(jp.getTarget());
//        System.out.println(jp.getThis());
//        System.out.println(jp.getTarget()==jp.getThis());
//    }
//
//
//
//    /*不会执行。形参变量名不匹配*/
//    @AfterReturning(value = "flag()",returning = "res")
//    public String afterReturn01(Object re){ /*错误，形参变量必须是@AfterReturning参数returning对应的res*/
//        System.out.println("【afterReturn01】的逻辑.......");
//        System.out.println("【afterReturn01】拿到的结果"+re);
//        return "";
//    }
//    /*执行*/
//    @AfterReturning(value = "flag()",returning = "res")
//    public String afterReturn02(Object res){
//        System.out.println("【afterReturn02】的逻辑.......");
//        System.out.println("【afterReturn02】拿到的结果"+res);
//        return "";
//    }
//    /*由于被代理方法的返回值是String，因此这里形参res的类型写成String也符合*/
//    @AfterReturning(value = "flag()",returning = "res")
//    public String afterReturn03(String res){
//        System.out.println("【afterReturn03】的逻辑.......");
//        System.out.println("【afterReturn03】拿到的结果"+res);
//        return "";
//    }
//    /*执行*/
//    @AfterReturning(value = "flag()",returning = "res")
//    public String afterReturn04(JoinPoint jp,String res){
//        System.out.println("【afterReturn04】的逻辑.......");
//        System.out.println("【afterReturn04】拿到的结果"+res);
//        return "";
//    }
//    /*不会被执行，两个参数的顺序错误*/
//    @AfterReturning(value = "flag()",returning = "res")
//    public String afterReturn05(Object res,JoinPoint jp){
//        System.out.println("【afterReturn05】的逻辑.......");
//        System.out.println("【afterReturn05】拿到的结果"+res);
//        return "";
//    }
//
//
//    /*没有参数可以执行*/
//    @AfterThrowing(value = "flag()",throwing = "e")
//    public void afterThrow00(){
//        System.out.println("【afterThrow00】的逻辑....");
//    }
//
//    /*有一个参数是，可以是JoinPoint或者Thowable的一种*/
//    @AfterThrowing(value = "flag()",throwing = "e")
//    public void afterThrow01(JoinPoint jp){
//        System.out.println("【afterThrow01】的逻辑....");
//        System.out.println("【afterThrow01】的逻辑"+jp.getSignature());
//    }
//    @AfterThrowing(value = "flag()",throwing = "e")
//    public void afterThrow03(Throwable e){
//        System.out.println("【afterThrow03】的逻辑....");
//        System.out.println("【afterThrow03】的异常"+e);
//        System.out.println("【afterThrow03】的异常信息"+e.getMessage());
//    }
//
//    /*两个参数时，必须注意顺序*/
//    @AfterThrowing(value = "flag()",throwing = "e")
//    public void afterThrow02(JoinPoint jp,Throwable e){
//        System.out.println("【afterThrow02】的逻辑....");
//        System.out.println("【afterThrow02】的异常"+e);
//        System.out.println("【afterThrow02】的异常信息"+e.getMessage());
//    }

    /*不会被执行，两个参数时必须满足形参中JoinPoint参数在前面*/
//    @AfterThrowing(value = "flag()",throwing = "e")
//    public void afterThrow02(Throwable e,JoinPoint jp){
//        System.out.println("【】的逻辑....");
//        System.out.println("【】的异常"+e);
//        System.out.println("【】的异常信息"+e.getMessage());
//    }


    @Around("flag()")
    public void aroundtest(ProceedingJoinPoint proceedingJoinPoint){
//        Object proceed = null;
        System.out.println("【aroundtest】执行方法之前.......");
        try {
//            Object[] args = proceedingJoinPoint.getArgs();
//            args[0] = "ppp";
//            proceed = proceedingJoinPoint.proceed(args);
            proceedingJoinPoint.proceed();
            System.out.println("【aroundtest】方法执行之后.......");
        } catch (Throwable e) {
            System.out.println("【aroundtest】方法出现异常。。。。。");
            throw new RuntimeException(e);
        }finally {
//            return proceed;
            System.out.println("【aroundtest】方法执行完成。。。。。。。");
        }
    }
}
