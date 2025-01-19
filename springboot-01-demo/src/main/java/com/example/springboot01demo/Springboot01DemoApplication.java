package com.example.springboot01demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class Springboot01DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01DemoApplication.class, args);

        /**
         * 其他方法1：使用SpringApplication进行赋值并run(模仿SpringApplication.run的调用逻辑)
         * */
//        SpringApplication springApplication = new SpringApplication(Springboot01DemoApplication.class);
//        //中间进行属性设置
//        springApplication.setBanner(banner.txt);    //设置banner的位置
//        springApplication.setBannerMode(Banner.Mode.CONSOLE);   //设置banner的模式
//        springApplication.setListeners();       //设置监听器等等
//        //属性设置完成后调用run方法
//        springApplication.run(args);


        /**
         * 其他方法2：使用SpringApplicationBuilder进行链式赋值并run
         * */
//        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Springboot01DemoApplication.class);
//        springApplicationBuilder
//                .main(Springboot01DemoApplication.class)
//                .banner(banner.txt)
//                .run(args);
    }
}
