package com.example.springmvc01helloworld.controller;

import com.example.springmvc01helloworld.bean.Person;
import com.example.springmvc01helloworld.bean.Person1;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 【总述】主要用于请求时，请求参数的获取 和 约束 等相关的测试...（建议使用postman测试）
 * 【注意】
 *      1. url中只有域名是不区分大小写的！！具体如下：
 *          域名部分：URL 的域名（即 http://example.com 中的 example.com）不区分大小写。也就是
 *                  说，example.com、EXAMPLE.COM 和 ExAmPlE.cOm 都是等价的。
 *          路径部分：URL 中的路径（即 http://example.com/Path/To/File 中的 /Path/To/File）是区分大小写的。
 *                  例如，http://example.com/Page 与 http://example.com/page 是两个不同的 URL。
 *          查询参数部分：URL 的查询参数（即 http://example.com?name=John 中的 name=John）通常也是区分大小写
 *                  的。即 name=John 和 Name=John 是两个不同的查询参数。
 *          [比如，在下面的实验中，拿POJO的封装时，如果参数 和 实体Bean 中的字段值字母大小不完全一致时，就会导致封装属性出错，导致属性被封装为null]
 *      2. 接收参数时常见的注解————即可以在形参前面使用的注解！！
 *          ① @RequestParam：取出某个参数的值，默认一定要携带(因此默认情况下如果没有请求中这个键就报错)。。
 *              可以指定required，defaultvalue
 *          ② @RequestBody：从请求体中取出json数据，自动封装为对象..常用于构建复杂对象，接收json或者xml数据
 *          ③ @RequestHeader：取出某个请求头的值。。比如：User-Agent：浏览器信息、Accept-Language：浏览器支持的语言等。
 *          ④ @CookieValue：取出某个cookie的值。。
 * */
@RestController
public class RequestTest {

    /**
     * 比如：请求的url是——
     *      http://localhost:8080/handle01?userName=zhangsan&passWord=lisi&cellphone=1234&agreement=true
     *要求：变量名和参数名保持一致
     *      1、没有携带：包装类型自动封装为null，基本类型封装为默认值
     *      2、携带：自动封装
     * 【注意】虽然html不区分大小写，但是？后面携带的键值对是区分大小写的
     * 如果浏览器请求时没有携带对应的数据————对于对象则接受的参数是null，对于基本数据类型接收到的参数就是默认值
     * */
    @RequestMapping("/handle01")
    public String handle01(String userName,
                           String paSsWord,
                           String cellphone,
                           boolean agreement){
        System.out.println(userName);
        System.out.println(paSsWord);
        System.out.println(cellphone);
        System.out.println(agreement);
        return "ok";
    }


    /**
     * username=zhangsan&password=123456&cellphone=1234&agreement=on
     * @RequestParam: 取出某个参数的值，默认一定要携带(因此默认情况下如果没有请求中这个键就报错)。
     *      value = "username"：指定参数名,就是请求中参数的键是什么
     *      required = false：非必须携带；
     *      defaultValue = "123456"：默认值，参数可以不带。
     *
     * ⚠⚠⚠无论请求参数带到了 请求体中还是 url? 后面，他们都是请求参数。都可以直接用@RequestParam或者同一个变量名获取到
     */
    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam(value = "password",defaultValue = "123456") String mima,
                           @RequestParam("cellphone") String phonenumber,
                           @RequestParam(value = "agreement",required = false) boolean agree){
        System.out.println(name);
        System.out.println(mima);
        System.out.println(phonenumber);
        System.out.println(agree);
        return "ok";
    }

    /**
     * 如果目标方法参数是一个 pojo；SpringMVC 会自动把请求参数 和 pojo 属性进行匹配；
     * 效果：
     *      1、pojo的所有属性值都是来自于请求参数
     *      2、如果请求参数没带，封装为null(引用类型封装为null) 或者 零值(基本数据类型封装为false、0等零值)；
     * 默认情况下：
     *      1.每一种属性默认都是非必须的
     *      2.pojo中实体类的属性名要和浏览器请求时携带的参数键值对的键名一样
     */
    //请求体：username=zhangsan&password=111111&cellphone=222222&agreement=on
    @RequestMapping("/handle03")
    public String handle03(Person1 person1){
        System.out.println(person1);
        return "handle03封装Person实体";
    }

    @RequestMapping("/handle04")
    public String handle04(@RequestHeader("host") String host,
                           @RequestHeader(value = "user-agent") String ua){
        System.out.println(ua);
        return "handle04";
    }

    /**
     * @CookieValue：获取cookie值.
     *      如果制定的cookie获取不到，报400错
     * @param haha
     * @return
     */
    @RequestMapping("/handle05")
    public String handle05(@CookieValue("haha1") String haha){ /*获取名为haha1的cookie值*/
        return "handle05处理结束，cookie是：" + haha;
    }


    /**
     * 【注意】handle06 和 handle07 的区别：
     *      参数带有@RequestBody，标识从请求体中拿出需要参数进行封装
     * */
    @RequestMapping("/handle06")
    public String handle06(Person person){
        System.out.println(person);
        return "handle06封装Person实体";
    }

    //========================================================================================//
    //上面的所有获取数据，本质上都是获取“key=value”这样的数据。。下面的是其他的类型

    /**
     * @RequestBody: 获取请求体json数据，自动转为person对象
     * 测试接受json数据
     * 1、发出：请求体中是json字符串，不是k=v
     * 2、接受：@RequestBody Person person
     * 3.此注解常常用于 请求体是 json或者xml 时参数的获取
     *
     * @RequestBody Person person
     *      1、拿到请求体中的json字符串
     *      2、把json字符串转为person对象
     *      上面的整个过程是框架自动帮我们做好了
     * @param person
     * @return
     */
    @RequestMapping("/handle07")    //json数据的例子，json数据通过RequestBody来进行封装
    public String handle07(@RequestBody Person person){
        System.out.println(person);
        return "handle07处理";
    }

    //下面的ahndle07可以将接收到的json直接拿到，但是没有意义，是需要我们自己做后续处理的
//    @RequestMapping("/handle07")
//    public String handle07(@RequestBody String json){
//        System.out.println(person);
//        return "ok";
//    }


    /**
     * 文件上传；
     * 1、@RequestParam 取出文件项，封装为MultipartFile，就可以拿到文件内容
     * 2，@RequestPart 取出文件项，封装为MultipartFile，就可以拿到文件内容
     * @param person
     * @return
     */
    @RequestMapping("/handle08")
    public String handle08(Person person,
                           @RequestParam("headerImg")MultipartFile headerImgFile,
                           @RequestPart("lifeImg") MultipartFile[] lifeImgFiles) throws IOException {
        //1、获取原始文件名
        String originalFilename = headerImgFile.getOriginalFilename();
        //2、文件大小
        long size = headerImgFile.getSize();
        //3、获取文件流
        InputStream inputStream = headerImgFile.getInputStream();
        System.out.println(originalFilename + " ==> " + size);
        //4、文件保存
        headerImgFile.transferTo(new File("D:\\img\\" + originalFilename));
        System.out.println("===============以上处理了头像=================");
        if (lifeImgFiles.length > 0) {
            for (MultipartFile imgFile : lifeImgFiles) {
                imgFile.transferTo(new File("D:\\img\\" + imgFile.getOriginalFilename()));
            }
            System.out.println("=======生活照保存结束==========");
        }
        System.out.println(person);
        return "handle08处理结束";
    }


    /**
     * HttpEntity：封装请求头、请求体； 把整个请求拿过来
     *    泛型：<T>：请求体类型； 可以自动转化
     *
     *
     * @return
     */
    @RequestMapping("/handle09")
    public String heandle09(HttpEntity<Person> entity){
        System.out.println("请求头"+entity.getHeaders());
        System.out.println("请求体"+entity.getBody());
        return "handle09";
    }


    /**
     * 接受原生 API
     * @param request
     * @param response
     */
    @RequestMapping("/handle10")
    public void handle10(HttpServletRequest request,
                         HttpServletResponse response,
                         HttpMethod method) throws IOException {
        System.out.println("请求方式："+method);
        String username = request.getParameter("username");
        System.out.println(username);
        response.getWriter().write("handle10处理结束，username为:"+username);
    }

}
