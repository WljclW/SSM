package com.example.apringmvcbestpractice.controller;

import com.example.apringmvcbestpractice.common.R;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 测试声明式异常处理
 * @author: Zhou
 * @date: 2025/5/11 12:12
 */
@RestController
public class HelloController {

    /**
     * 编程式异常处理
     * @author: Zhou
     * @date: 2025/5/11 12:20
     * 编程式异常处理。如果多个controller方法会出现异常，则每一次进行try-catch进行处
     * 理————不推荐
     */
    @GetMapping("/hello")
    public R hello(){
        try{
            int i = 10/0;
            return R.ok(i);
        }catch (Exception e){
            return R.error(100,"执行异常");
        }
    }


    /**
     * 1、如果Controller本类出现异常，会自动在本类中找有没有@ExceptionHandler标注的方法，
     *    如果有，执行这个方法，它的返回值，就是客户端收到的结果
     *  如果发生异常，多个都能处理，就精确优先
     * @author: Zhou
     * @date: 2025/5/11 12:28
     */
    @GetMapping("/helloo")
    public R helloo(@RequestParam(value = "i",defaultValue = "0")Integer integer) throws FileNotFoundException {
        int j = 10/integer;
//        FileInputStream inputStream = new FileInputStream("D:\\123.txt");
        return R.ok(j);
    }


    /*1. 针对数学运算异常的处理。
    * 2. 注解必须添加参数，指明针对什么类型的异常。。如果不指明，则什么异常也不会处理————即
    *    spring不知道这个异常针对哪种类型，因此任何异常都匹配不上这个异常处理*/
    @ExceptionHandler(ArithmeticException.class)
    public R myHandler(){
        System.out.println("【本类】 - ArithmeticException 异常处理");
        return R.error(100,"计算异常");
    }


    /*捕获文件找不到的异常*/
    @ExceptionHandler(FileNotFoundException.class)
    public R myHandler(FileNotFoundException ex){
        System.out.println("【本类】 - FileNotFoundException 异常处理");
        return R.error(300,"文件未找到异常：" + ex.getMessage());
    }


    /**
     * @author: Zhou
     * @date: 2025/5/11 12:33
     * 有可能会发生其他没有被捕获的异常，因此这里写一个通用的异常处理器，捕获Throwable类型即基类型.
     * 其他未能被捕获的异常，都会被这个异常所捕获
     */
    @ExceptionHandler(Throwable.class)
    public R myHandler(Throwable ex){
        System.out.println("【本类】 - Throwable 异常处理");
        return R.error(500,"其他异常：" + ex.getMessage());
    }
}
