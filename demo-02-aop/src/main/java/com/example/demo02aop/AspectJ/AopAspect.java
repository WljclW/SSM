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
    public void declareJoinPointerExpression(){ /*方法名随机指定就行，代表@Pointcut指定的切入点*/
    }

    /**
     * JoinPoint是封装了代理方法信息的对象，如果不需要使用到相关的信息，可以不写；
     * 在通知方法中，通常通过将 JoinPoint.getSignature() 的返回值强制转换为 MethodSignature 来获取更多关于方法的信息
     * */
    @Before("declareJoinPointerExpression()")
    public void before(JoinPoint jp){
        System.out.println("@Before注解 的前置通知");
        System.out.println("目标方法名为："+jp.getSignature().getName()); /*getSignature()获得方法的全签名*/
        System.out.println("目标方法所属类的简单类名"+jp.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名"+jp.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:"+ Modifier.toString(jp.getSignature().getModifiers()));
        Object[] args = jp.getArgs(); //拿到方法的所有参数
        for (int i=0;i<args.length; i ++){
            System.out.println("参数"+(i+1)+":"+args[i]);
        }
//        args[0] = "122";  //在这里修改参数不会影响到原始方法的参数

        /*getTarget()和getThis()方法的返回值看着是一样的，但是"=="返回的是false*/
        System.out.println("被代理的对象:"+ jp.getTarget());
        System.out.println("代理对象自己:"+ jp.getThis());
        System.out.println("两个类一样吗"+(jp.getTarget()== jp.getThis()));  //这里判断是不相等的，但是上面打印的结果表面看起来是一样的


        System.out.println("被代理对象的类："+jp.getTarget().getClass());
        System.out.println("代理对象的类："+jp.getThis().getClass());
        System.out.println("被代理对象的类加载器"+jp.getTarget().getClass().getClassLoader());
        System.out.println("代理对象的类加载器"+jp.getThis().getClass().getClassLoader());
        System.out.println("两个类的类加载器一样吗？"+(jp.getTarget().getClass().getClassLoader()==jp.getThis().getClass().getClassLoader()));
    }


    /**
     * 环绕通知的运行是在最外层的。。。
     * 1. @Around注解的方法，可以多一个ProceedingJoinPoint参数...这个参数的作用包括但不局限于：
     *        ①可以获取被代理方法的参数列表，并可以进行修改
     *        ②可以调用proceed方法来执行被代理的方法，并且必须调用否则被代理的方法不会被执行
     *          【这个方法有重载方法：可以不传参数(表示使用方法原本的参数)，也可以传去全部的参数】
     * 2. @Around标注的方法中，被代理方法的返回值就已经被该方法所取代了，如果 @Around标注的方法
     *   没有返回值，则就拿不到被代理方法的执行结果了。
     * 3.  @Around标注的方法可以有返回值，也可以没有返回值。。但是基于2可知，如果没有返回值就没有意义了，
     *   没有返回值意味着该方法外部无法拿到被代理方法的执行结果
     * */
    @Around("declareJoinPointerExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        try {
            System.out.println("@Around环绕通知-前置通知");
            /**【注意】如果不调用proceed()则原始方法不会被执行。。该方法可以不带参数，也可以带参数*/
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

    /**
     * @AfterReturning：在"被代理方法"正常返回后执行
     *      与其他注解不一样的是这个注解多一个returning属性，这个属性可以获取到被代理方法返回的结果，
     * 使用的注意：
     *    1.如果是两个参数，则顺序必须是JoinPoint在前面
     *    2.形参变量中代表原始方法返回值的ret必须和注解中returning对应的值一致
     *    3.如果是一个参数，则可以是JoinPoint类型，也可以是被代理方法的返回值
     * */
    @AfterReturning(value = "declareJoinPointerExpression()",returning = "ret") //被代理方法的执行结果将用变量ret接收，需要在方法的形参写上这个变量并注意形参类型和返回值类型一致
    public void afterReturningMethod(JoinPoint jp,Object ret){
        System.out.println("@AfterReturning注解 的返回通知");
        System.out.println("@AfterReturning注解 拿到的结果"+ret);
        System.out.println("目标方法名为："+jp.getSignature().getName());
        System.out.println("目标方法所属类的简单类名"+jp.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名"+jp.getSignature().getDeclaringTypeName());
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
    /*@AfterThrowing和@AfterReturing是类似的。可以有一个参数也可以有两个参数。
    *     一个参数的时候，可以是Exception，也可以是JoinPoint;
    *     两个参数的时候，必须是JoinPoint参数在第一个*/
    @AfterThrowing(value = "declareJoinPointerExpression()",
                throwing = "e")
    public void afterThrowingMethod(Exception e){
        System.out.println("@AfterThrowing注解 的异常通知,且异常的原因是："+e.getMessage());
    }

}
