package com.example.demo02aop.aspect;/**
 * @author luck-jay
 * @date 2025/2/6 14:27
 */

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author mini-zch
 * @date 2025/2/6 14:27
 */
@Component
@Aspect
public class AuthAspect {

    /**
     * 定义一个切入点表达式，表述哪些方法需要被切。
     * 在需要这些切入点的时候，引用这个方法名即可
     * */
    @Pointcut("execution(int com.example.demo02aop.calculator.MathCalculator.*(..))")
    public void pointcut(){

    }



    /**
     * 下面的切面方法就不会被执行
     * */
    @Before("pointcut()")
    public int auth(String username,String password){
        System.out.println("用户名："+username+"密码："+password);
        return 1;
    }



    /**
     * 有返回值的下面方法是会在方法前执行的，说明@Before注解的切面逻辑是可以有返回值的
     * */
    @Before("pointcut()")
    public int aut3h(){
        System.out.println("aut3h方法-----------前置");
        return 2;
    }

    /**
     * 相同时间的打印顺序是跟方法名相关的，方法名小的越先打印。。比如：“aut3h”<“aut4h”，"aut3h">”aut2h“
     * */
    @Before("pointcut()")
    public void aut4h(){       //方法的返回值是void也能正常执行
        System.out.println("aut4h方法-----------前置");
    }

    @After("pointcut()")
    public void aut4hAfter(){
        System.out.println("auth切面类-----------After后置");
    }

    @AfterReturning("pointcut()")
    public void aut4hAftr(){
        System.out.println("auth切面类-----------AfterReturning正常返回");
    }
}
