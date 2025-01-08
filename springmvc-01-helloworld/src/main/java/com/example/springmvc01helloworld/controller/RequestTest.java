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
     * @RequestParam: 取出某个参数的值，默认一定要携带(因此默认情况下如果没有这个键就报错)。
     *      required = false：非必须携带；
     *      defaultValue = "123456"：默认值，参数可以不带。
     *
     * 无论请求参数带到了 请求体中还是 url? 后面，他们都是请求参数。都可以直接用@RequestParam或者同一个变量名获取到
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
     *      2、如果请求参数没带，封装为null 或者 零值；
     * 默认：
     *      1.每一种属性默认都是非必须的
     *      2.pojo中实体类的属性名要和浏览器请求时携带的参数键值对的键名一样
     */
    //请求体：username=zhangsan&password=111111&cellphone=222222&agreement=on
    @RequestMapping("/handle03")
    public String handle03(Person1 person){
        System.out.println(person);
        return "ok";
    }

    @RequestMapping("/handle04")
    public String handle04(@RequestHeader("host") String host,
                           @RequestHeader(value = "user-agent") String ua){
        System.out.println(ua);
        return "ok";
    }

    /**
     * @CookieValue：获取cookie值.
     * 如果制定了cookie获取不到400错
     * @param haha
     * @return
     */
    @RequestMapping("/handle05")
    public String handle05(@CookieValue("haha1") String haha){
        return "ok：cookie是：" + haha;
    }


    @RequestMapping("/handle06")
    public String handle06(Person person){
        System.out.println(person);
        return "ok";
    }

    //========================================================================================
    //上面的所有获取数据，本质上都是获取“key=value”这样的数据。。下面的是其他的类型

    /**
     * @RequestBody: 获取请求体json数据，自动转为person对象
     * 测试接受json数据
     * 1、发出：请求体中是json字符串，不是k=v
     * 2、接受：@RequestBody Person person
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
        return "ok";
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
        return "ok!!!";
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
        return "ok";
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
        response.getWriter().write("ok!!!"+username);
    }

}
