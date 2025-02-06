package com.example.demo02aop.AspectJ;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * @author mini-zch
 * @date 2025/2/6 14:51
 */
/**
 * 下面展示：一个没有实现接口的类，可以在spring中被动态代理。。并在方法执行的适合时机执行切面逻辑
 * */
@Component
@Aspect
public class AopAspect {

    @Pointcut("execution(* com.example.demo02aop.AspectJ.TargetClass.*(..))")   //指定切入点是TargetClass类的所有方法
    public void declareJoinPointerExpression(){}

    /**
     * JoinPoint是封装了代理方法信息的对象，如果不需要使用到相关的信息，可以不写；
     * 在通知方法中，通常通过将 JoinPoint.getSignature() 的返回值强制转换为 MethodSignature 来获取更多关于方法的信息
     * */
    @Before("declareJoinPointerExpression()")
    public void before(JoinPoint jp){
        System.out.println("@Before注解 的前置通知");
        System.out.println("目标方法名为："+jp.getSignature().getName());
        System.out.println("目标方法所属类的简单类名"+jp.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名"+jp.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:"+ Modifier.toString(jp.getSignature().getModifiers()));
        Object[] args = jp.getArgs();
        for (int i=0;i<args.length; i ++){
            System.out.println("参数"+(i+1)+":"+args[i]);
        }
        System.out.println("被代理的对象:"+ jp.getTarget());
        System.out.println("代理对象自己:"+ jp.getThis());
//        System.out.println(jp.getTarget()== jp.getThis());  //这里判断是不相等的，但是上面打印的结果表面看起来是一样的
    }


    /**
     * 环绕通知的运行是在最外层的。。。
     * @Around注解的方法，可以多一个ProceedingJoinPoint参数...这个参数的作用包括但不局限于：
     *        1.可以获取被代理方法的参数列表，并修改
     *        2.可以调用proceed方法来执行被代理的方法。
     *          【这个方法有重载方法：可以不传参数(表示使用方法原本的参数)，也可以传去全部的参数】
     * */
    @Around("declareJoinPointerExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        try {
            System.out.println("@Around环绕通知-前置通知");
            result = pjp.proceed(); //情况1：如果不带参数，则执行方法时所传的实参保持不变
//            result = pjp.proceed(new String[]{"修改后1","修改后2"});  //情况2.带了所有参数则将原来所有的参数更新
//            result = pjp.proceed(new Object[]{"修改后1"});  //情况3.带了部分参数，则会在调用方法时抛出异常——形参列表和实参列表长度不一致  IllegalArgumentException
//            result = pjp.proceed(new Object[]{1,2});  //情况3.带的参数和形参列表不一样，报异常——AopInvocationException
            System.out.println("@Around环绕通知——返回通知");
        }catch(Throwable e){    //上面调用proceed方法时参数不对是会报异常的，但是运行时没有报，是因为被这里catch了
            System.out.println("@Around环绕通知——异常通知");
            throw e;
        }finally {
            System.out.println("@Around环绕通知 - 后置通知");
        }
        System.out.println("adsssssssss");
//        return null;  //如果这一句不注释，就相当于在代理方法中直接将原始方法的返回值置为null了
        return result;
    }


    @After("declareJoinPointerExpression()")
    public void afterMethod(){
        System.out.println("@After注解 的后置通知");
    }

    /**
     * 【注意】下面的切面方法在运行时，发现不能捕获异常。。。但是运行时又不会报错，其实错误的原因在于：注解的value写错了，declareJointPointerExpression（×）
     *      应该是declareJoinPointerExpression（√），后面的少一个字母t
     * */
//    @AfterThrowing("declareJointPointerExpression()")
//    public void afterThrowingMethod(){
//        System.out.println("@AfterThrowing注解 的异常通知");
//    }

    @AfterThrowing("declareJoinPointerExpression()")
    public void afterThrowingMethod(){
        System.out.println("@AfterThrowing注解 的异常通知");
    }

}
