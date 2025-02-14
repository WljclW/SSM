package com.example.demo02aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(100) //指定此切面的优先级。（1）数字越小优先级越高；（2）有此注解的切面类优先级高于 没有此注解标注的切面类
@Component      //必须加这个注解，spring才会将这个类纳入ioc容器，自己管理
@Aspect     //必须加这个注解，告诉spring这是一个切面
public class LogAspect {
    /**
     * 1.需要在自己的类中通过方法来实现不同的切面逻辑；然后告诉spring何时何地去执行这些方法。。且要求切面类：
     *      （1）类上注解@Aspect表明是切面类
     *      （2）类上标注@Component让spring管理
     * 2.何时 执行切面方法？通过以下注解指明
     *      @Before:方法执行之前执行该注解的方法
     *      @AfterReturning:方法正常执行 并且 返回之后 执行
     *      @AfterThrowing:方法执行时抛出异常时 执行此注解注解的方法
     *      @After:方法执行结束(正常结束和异常结束)都执行此注解的方法
     * 3.何地 执行切面方法？通过写切入点表达式
     *      结果表达式。
     *      excute(方法的全签名)
     *          全签名的全写法比如：
     *          public int com.example.demo02aop.calculator.MathCalculator.add(int i,int j) throw 异常名
     * 4.通知方法的执行顺序
     *    1)正常情况下：前置通知(@Before)——方法执行——返回通知(@AfterReturning)——方法结束通知(@After)
     *    2)出现异常时：前置通知(@Before)——方法执行——返回通知(@AfterThrowing——方法结束通知(@After)
     * 5.切面类中方法的说明：@Before、@After、@AfterReturning、@AfterThrowing这四个注解标注方法时，做以下说明————
     *      （1）方法的修饰符无所谓————因为反射都可以访问;
     *      （2）方法的返回值无所谓;
     *      （3）可以拿到切入点的信息(形参添加参数JointPoint);
     *      （4）@AfterReturning注解的方法还可以通过在注解中添加returning="ret"，通过这个属性可以拿到
     *          目标方法(即被代理方法)的返回值，然后在方法的形参中使用变量ret接收返回值
     *      （5）@AfterThrowing注解的方法还可以通过在注解中添加throwing="e"，通过这个属性可以拿到被代理
     *          方法的异常，然后在方法的形参中使用变量e接收异常
     * 6.JoinPoint joinPoint:连接点中包含方法的信息。。写在方法的形参中，方法就可以拿到切入点(被代理方法)的
     *      相关信息了
     * 7.多切面的执行顺序：
     *      （1）不同的切面类按照"类名的字母序"排序，越小的越先执行
     *      （2）有@Order注解的切面类的方法逻辑 会先于 没有被@order注解的切面类的方法逻辑 执行
     *      （3）同一个切面类中的多个方法执行顺序：按照方法名的字母序排序，越小的越先执行
     * */

    //参数带什么就切
    @Before("args(int,int)")    //args这种对应的方法 在 execution对应的方法 之前就会执行
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
        System.out.println("【切面 - 日志】开始执行........After方法结束");
    }

    @AfterReturning("args(int,int)")    //只要参数是两个int类型的方法，方法return之后就会执行
    public void logReturn(){
        System.out.println("【切面 - 日志】开始执行........AfterReturning方法正常返回");
    }

    @AfterThrowing("args(int,int)")
    public void logThrowing(){
        System.out.println("【切面 - 日志】开始执行........AfterThrowing方法抛出异常");
    }
}
