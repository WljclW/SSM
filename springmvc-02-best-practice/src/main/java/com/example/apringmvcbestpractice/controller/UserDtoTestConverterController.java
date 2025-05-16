package com.example.apringmvcbestpractice.controller;

import com.example.apringmvcbestpractice.bean.UserDtoTestConverter;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mini-zch
 * @date 2025/5/16 10:15
 */
@RestController
public class UserDtoTestConverterController {
    /*
    * 注意：
    * 1. 如果使用@Param注解，则解析时并不会使用到WebMvcConfig中自定义的Converter..
    * 2. 并且测试的请求必须是这样的字符串“http://localhost:8080/test/converter?user=zhangsan11,1”。因为
    * 注解“@RequestParam("user")”的含义是从请求头中获取user这个参数的值
    * */
    @RequestMapping("test/converter")
    public void converterTest(@RequestParam("user") UserDtoTestConverter user){
        System.out.println("user-name:"+user.getName());
        System.out.println("user-age:"+user.getAge());
    }
}
