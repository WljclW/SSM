package com.example.demo01ioc.controller;

import com.example.demo01ioc.Bean.Dog;
import com.example.demo01ioc.Bean.Person;
import com.example.demo01ioc.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@Data
public class UserController {

    /**
     * 自动装配流程：
     * 1.按照类型找到这个组件
     *      1.1 如果有且只能找到一个，直接注入。名字无所谓
     *      1.2 如果有多个，则按照名字查找;变量名就是名字(bean的名字)
     *          1.2.1 如果找到，直接注入
     *          1.2.2 找不到，报错：Field person in com.example.demo01ioc.controller.UserController required a single bean, but 4 were found:
     * 	                - zhangsanName: defined by method 'zhangsan' in class path resource [com/example/demo01ioc/config/PersonConfig.class]
     * 	                - haha: defined by method 'haha' in class path resource [com/example/demo01ioc/config/PersonConfig.class]
     * 	                - bill: defined by method 'bill' in class path resource [com/example/demo01ioc/config/PersonConfig.class]
     * 	                - qiaobusi: defined by method 'qiaobusi' in class path resource [com/example/demo01ioc/config/PersonConfig.class]
     *
     * 	                Action:
     *                  Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or
     *                  using @Qualifier to identify the bean that should be consumed
     * 2. 如果按照类型就没有会找到，报错：Field person in com.example.demo01ioc.controller.UserController required a
     *          bean of type 'com.example.demo01ioc.Bean.Dog' that could not be found.
     *          Action:
     *          Consider defining a bean of type 'com.example.demo01ioc.Bean.Dog' in your configuration.
     * */
    @Autowired
    UserService userService;

    @Autowired
    Person haha;

    @Autowired
    List<Person> list;

    @Autowired
    Map<String,Person> map;
}
