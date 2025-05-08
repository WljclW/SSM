package com.example.springmvc01helloworld.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试请求限定，即在请求映射中添加一些额外的参数来实现————即在@RequestMapping注解中添加一些参数！！
 *
 * 请求方式：
 *      GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
 */
@RestController /*ResponseBody和RequestMapping两个注解的合体，表示这个类中所有控制器方法的返回都绑定到响应体中，而不是寻找视图*/
public class RequestMappingLimit {
    /**test01映射下，携带参数的请求也会进入这个控制器方法及逆行处理。并且由于注解没有对请求参数限制，因此只要路径是op01且
     * 请求的方法合法都会进入test01处理*/
    @RequestMapping(value = "test01",method = RequestMethod.POST)
    public String test01(){
        return "只能用post方法请求";
    }

    @RequestMapping(value = "test02",params = {"key1","key2","!key3"})
    public String test02(){
        return "要求：必须传键为key1，key2的参数，但是不能有键为key3的参数";
    }

    /**
     * 请求参数：params = {"username","age"}
     * 1）、key1：  表示请求必须包含key1参数
     * 2）、key2=18：   表示请求参数中必须包含key2=18的参数
     * 3）、gender!=1：  表示请求参数中不能包含gender=1的参数.。如果不传此参数也是可以。
     *              就是如果有gender这样的键，它的值不能等于1；但是没有此键也可以.
     *                  【注意】不等于的！必须是英文字符，否则运行不会报错。但是会把“gender！=1”当成字符串
     *              看是不是有一个参数就是这个串。
     */
    @RequestMapping(value = "test02",params = {"key1","key2=18","gender!=1"})
    public String test03(){
        return "要求：必须传键为key1，key2=18的参数,并且gender参数的值不能是1(不传gender参数也是合法的)";
    }


    /**
     * 请求头：headers = {"haha"}
     * 1）、haha：  表示请求中必须包含名为haha的请求头
     * 2）、hehe!=1：  表示请求头中 的 hehe 不能是1；（hehe=0是可以的，不带hehe也是可以的）
     */
    @RequestMapping(value = "/test04",headers = {"haha","hehe!=1"})
    public String test04(){
        return "要求：请求头中的键值对必须带有haha这个键,并且hehe的值不能是1";
    }


    /**
     * 请求内容类型：consumes = {"application/json"}; 消费什么数据；
     * Media Type：媒体类型
     * 1）、application/json：  表示浏览器必须携带 json 格式的数据。
     */
    //consumes指定服务端消费的数据类型。。也就是说请求段请求的数据类型是什么，才能被服务端所理解
    @RequestMapping(value = "/test05",consumes = "application/json")
    public String test05(){
        return "要求：请求的数据类型必须是json";
    }


    /**
     * 对比一下下面的test06 和 test07，体现了produces的作用。。同样的数据浏览器展示的结果是不一样的：
     *      test06中因为指定的produces是"text/plain"，因此会把字符串原样展示出来；
     *      test07中因为指定的produces是"text/html"，因此会把字符串解析成html代码，浏览器展示的是解析html代码后的网页。
     * */
    /*要求服务端给浏览器返回的是纯文本信息*/
    @RequestMapping(value = "/test06",produces = "text/pain")
    public String test06(){
        return "<h1>你好，我是服务端返回的数据</h1>";
    }

    /**
     * 响应内容类型：produces = {"text/plain;charset=utf-8"}; 生产什么数据；
     */
    //返回的数据以html来进行解析
    @RequestMapping(value = "/test07",produces = "text/html")
    public String test07(){
        return "<h1>你好，我是服务端返回的数据</h1>";    /*表示返回的是一段html代码，因此浏览器收到后就会按照html的规范来解析*/
    }
}
