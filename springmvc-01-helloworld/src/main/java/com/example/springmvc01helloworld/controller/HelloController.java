package com.example.springmvc01helloworld.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody   //将返回信息作为响应体 传回去
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello被访问到了");
        return "hello springmvc，你好";
    }


    /**
     * 如果有多个方法处理相同的映射，启动项目时会报错———— Ambiguous mapping.
     * */
//    @ResponseBody   //将返回信息作为响应体 传回去
//    @RequestMapping("/hello")
//    public String hello_copy(){
//        System.out.println("hello被访问到了");
//        return "hello springmvc，你好";
//    }


    @ResponseBody   //将返回信息作为响应体 传回去
    @RequestMapping("/hello?")  //？代表 必须有 且 仅有一个字符。比如hello8、hellot都会走此方法，但是hello88报404
    public String hello01(){
        System.out.println("hello01被访问到了");
        return "hello springmvc，你好";
    }


    @ResponseBody   //将返回信息作为响应体 传回去
    @RequestMapping("/hello*")  //*代表 任意索格字符。比如hello88、hello8t都会走此方法。不能匹配多个路径
    public String hello02(){
        System.out.println("hello02被访问到了");
        return "hello springmvc，你好";
    }


    //**匹配的时候只能放在末尾，不能匹配中间的任意多层路径
    @ResponseBody   //将返回信息作为响应体 传回去
    @RequestMapping("/hello/**")  //*代表 任意索格字符。比如hello88、hello8t都会走此方法。不能匹配多个路径
    public String hello03(){
        System.out.println("hello02被访问到了");
        return "hello springmvc，你好";
    }
}
