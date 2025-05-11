package com.example.springmvc01helloworld.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @RequestMapping指定映射路径时，路径匹配符的实验
 * */
@Controller
public class HelloController {

    @ResponseBody   //此注解的语义：将控制器方法的返回值直接写入 HTTP 响应体中，而不是将其作为视图名称进行视图解析。
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello被访问到了");
        return "hello springmvc(来自于hello)，你好";
    }


    /**
     *     如果有多个方法处理相同的映射，启动项目时会报错———— Ambiguous mapping.
     * 比如：下面注释的方法和hello方法处理 相同的路径映射，不注释的话启动报错
     * */
//    @ResponseBody   //将返回信息作为响应体 传回去
//    @RequestMapping("/hello")
//    public String hello_copy(){
//        System.out.println("hello被访问到了");
//        return "hello springmvc，你好";
//    }


    @ResponseBody   //将返回信息作为响应体 传回去
    @RequestMapping("/hello*")  //*代表 任意多个字符。比如hello88、hello8t都会走此方法。不能匹配多个路径
    public String hello02(){
        System.out.println("hello02被访问到了");
        return "hello springmvc(来自于hello*)，你好";
    }


    /**
     * 如果请求路径的hello后面只有一个字符，则优先选择这个方法而不是hello02，因为这个方法更精确
     * */
    @ResponseBody   //将返回信息作为响应体 传回去
    @RequestMapping("/hello?")  //？代表 必须有 且 仅有一个字符。比如hello8、hellot都会走此方法，但是hello88报404
    public String hello01(){
        System.out.println("hello01被访问到了");
        return "hello springmvc(来自于hello?)，你好";
    }




    //**匹配的时候只能放在末尾，不能匹配中间的任意多层路径。【注意】放在中间的时候项目启动时报错
    @ResponseBody   //将返回信息作为响应体 传回去
    @RequestMapping("/hello/**")  //**代表 任意多级路径。比如:hello/a/b/a等都会走此路径，但是hello3/s/c就会报错，因为开始必须是hello这个根
    public String hello03(){
        System.out.println("hello02被访问到了");
        return "hello springmvc(来自于hello/**)，你好";
    }
}
