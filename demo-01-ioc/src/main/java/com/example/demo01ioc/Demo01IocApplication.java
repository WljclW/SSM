package com.example.demo01ioc;

import com.example.demo01ioc.Bean.*;

import com.example.demo01ioc.controller.UserController;
import com.example.demo01ioc.datasource.MyDatasource;
import com.example.demo01ioc.service.HahaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootApplication
public class Demo01IocApplication {

    public static void main(String[] args) {
        /**
         * 测试涉及到初始化方法、销毁方法的指定
         * */
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println("ioc容器初始化完成。。。。。。。。。。");
        System.out.println(ioc.getBean(User.class));
    }


    public static void test_profile(String[] args) {
        /**
         * 测试Profile注解
         * */
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println("ioc容器初始化完成。。。。。。。。。。。。。。。");
        for (String name:ioc.getBeanDefinitionNames()){
            System.out.println("name=========="+name);
        }
        System.out.println(ioc.getBeanDefinitionNames().length);
    }

    public static void test_spring(String[] args) {
        /**
         * 测试原来spring中如何得到ioc容器
         *
         * 也可以通过FileSystemXmlApplicationContext ioc = new FileSystemXmlApplicationContext("c:\\user\\zahngsan\\myapp.xml");
         * */
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("myapplication.xml");
        System.out.println("ioc容器初始化完成。。。。。。。。。");
        for (String name:ioc.getBeanDefinitionNames()){
            System.out.println("name============"+name);
        }
        System.out.println(ioc.getBeanDefinitionNames().length);
    }

    public static void test_Profile(String[] args) {
        /**
         * 测试Profile注解指定“某环境下才注入被注解的bean”
         * */
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println("ioc容器初始化完成..........");
        System.out.println(ioc.getBean(MyDatasource.class));
    }


    public static void test_(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        Cat bean = ioc.getBean(Cat.class);
        System.out.println(bean);   //会看到bean的初始化值，初始化值配置在配置文件中
    }

    public static void test_Value(String[] args) {
        /**
         * 测试Value完成属性值的注入。见com.example.demo01ioc.Bean.Dog
         * Value完成属性注入的方式：静态赋值、SPEL表达式赋值、java语句赋值，详细可参考官方文档
         * */
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println("容器创建完成..................");
        System.out.println(ioc.getBean(Dog.class));
    }

    public static void test_Aware(String[] args) {
        /**
         * 测试xxxxAware接口的使用，通过继承于某些接口，spring能为被注解的bean
         *      注入特定的属性，比如：环境对象、当前bean(即实现BeanNameAware接
         *      口的bean)的name
         * 见com.example.demo01ioc.service.HahaService
         * */
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println("容器创建完成了==================");
//        HahaService hahaservice = ioc.getBean("hahaService");
        HahaService bean = ioc.getBean(HahaService.class);
        System.out.println("当前的操作系统："+bean.getOS());
        System.out.println(bean);
        System.out.println("myName是======="+bean.getMyName());
    }

    public static void test_setzhuru(String[] args) {
        /**
         * 通过set方法完成属性的注入。见com.example.demo01ioc.dao.UserDao
         * */
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println(ioc.getBean("userDao"));
    }

    public static void test_Qualifier(String[] args) {
        /**
         * 测试Qualifier注解的使用，在某一类的bean有多个时候，指定当前需要注入的bean，
         *      通常是指定需要注入的bean的name。
         * */
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println(ioc.getBean("userService"));
    }


    public static void test_Autowired(String[] args) {
        /**
         * 测试Autowired，完成bean中属性的注入。【注意：同一类的bean多的时候如何完成注入？
         *      结合Qualifier注解(指定需要注入的bean的name) 或者 Primary注解(在构造的同
         *      一类的多个bean中其中的一个标注，标识默认注入的就是这个bean)】
         * 见com.example.demo01ioc.controller.UserController
         * */
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println(ioc.getBean(UserController.class).toString());
    }


    public static void test01(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        ConfigurableEnvironment environment = ioc.getEnvironment();
        System.out.println(environment.getProperty("OS"));
        for (String name:ioc.getBeanDefinitionNames()){
            System.out.println("name==========="+name);
        }
        System.out.println(ioc.getBeanDefinitionNames().length);
    }


    public static void test(String[] args) {
        //run方法会返回一个ioc容器。容器在启动的过程中就会创建组件对象(看Dog的构造器执行很早)，且是单实例
        ConfigurableApplicationContext ioc = SpringApplication.run(Demo01IocApplication.class, args);
        System.out.println("ioc容器："+ioc+"....共有对象："+ioc.getBeanDefinitionNames().length+"个");   //打印容器内的对象个数，初始时默认有55个
        for (String name:ioc.getBeanDefinitionNames()){
            System.out.println("name=========="+name);
        }


        System.out.println("==========================下面是从容器中获取bean的例子=========================");
//        System.out.println(ioc.getBean(Car.class));
//        Map<String, Car> beansOfType = ioc.getBeansOfType(Car.class);
//        System.out.println(beansOfType);
//        System.out.println("1==================");
//        System.out.println(ioc.getBean("BYDFactory"));
//        Map<String, Car> beansOfType1 = ioc.getBeansOfType(Car.class);
//        System.out.println(beansOfType1);
//        System.out.println("2==================");
//        System.out.println(ioc.getBean("BYDFactory"));
//        Map<String, Car> beansOfType2 = ioc.getBeansOfType(Car.class);
//        System.out.println("beansOfType2"+beansOfType2);
//        System.out.println(ioc.getBean("zhangsanName"));
        /**
         * 组件(ioc容器中的bean就是组件)的四大特性：名字、类型、对象；
         * 组件名是全局唯一的。如果重复，
         *      容器中只会放最先声明的那个()；
         *      spring3.4.0版本，实验中发现报错(The bean 'zhangsan', defined in com.example.demo01ioc.Demo01IocApplication, could not be registered. A bean with that name has already been defined in com.example.demo01ioc.Demo01IocApplication and overriding is disabled.)
         *获取bean的方法总结：
         *      1.通过getBean指定组件名字(获取到的类型需要进行强转为实际类型)、组件类型(参数".class"要保证实例唯一)来获取；
         *      2.通过getBeansOfType指定组件类型，返回map(组件名称->组件实例)
         * 三、可能的异常信息：
         *      1.组件不存在时，NoSuchBeanDefinitionException
         *      2.通过getBean指定类型获取bean，但是这个类的bean不唯一时会报NoUniqueBeanDefinitionException
         * */

//        System.out.println("通过名字获取bean————"+ioc.getBean("zhangsan"));
//        System.out.println("通过类型来获取单个组件————"+ioc.getBean(Person.class));
//        System.out.println("通过类型来获取多个组件(返回map的映射：组件名->组件实例)————"+ioc.getBeansOfType(Person.class));
//        System.out.println("得到的是哪一个张三？————"+ioc.getBean("zhangsan"));  //自己实验时报错，版本spring3.4.0
    }

    //向容器内注册一个名字是 zhangsan 的bean。
//    @Bean("haha")
//    public Person zhangsan(){
//        Person person = new Person();
//        person.setAge(17);
//        person.setGender("nan");
//        person.setName("zhangsan2");
//        return person;
//    }

//    @Bean("zhangsan")
//    public Person haha(){
//        Person person = new Person();
//        person.setAge(17);
//        person.setGender("nan");
//        person.setName("zhangsan01");
//        return person;
//    }

//   @Bean
//    public Person haha(){
//        Person person = new Person();
//        person.setAge(17);
//        person.setGender("nan");
//        person.setName("zhangsan01");
//        return person;
//    }

//    @ConditionalOnMissingBean(name = "bill")
//    @Bean
//    public Dog dog(){
//        return new Dog();
//    }

}
