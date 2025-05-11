package com.example.apringmvcbestpractice.config;

import com.example.apringmvcbestpractice.interceptor.MyHandlerInterceptor0;
import com.example.apringmvcbestpractice.interceptor.MyHandlerInterceptor1;
import com.example.apringmvcbestpractice.interceptor.MyHandlerInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringConfig implements WebMvcConfigurer {
    @Autowired
    MyHandlerInterceptor0 myHandlerInterceptor0;

    @Autowired
    MyHandlerInterceptor1 myHandlerInterceptor1;

    @Autowired
    MyHandlerInterceptor2 myHandlerInterceptor2;


    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor0)
                .addPathPatterns("/api/v1/**");          //**拦截任意多层路径

        registry.addInterceptor(myHandlerInterceptor1)
                .addPathPatterns("/api/v1/**");

        registry.addInterceptor(myHandlerInterceptor2)
                .addPathPatterns("/api/v1/employee/**");
    }
}
