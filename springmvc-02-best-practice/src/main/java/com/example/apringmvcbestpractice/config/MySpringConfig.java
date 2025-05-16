package com.example.apringmvcbestpractice.config;

import com.example.apringmvcbestpractice.bean.UserDtoTestConverter;
import com.example.apringmvcbestpractice.interceptor.MyHandlerInterceptor0;
import com.example.apringmvcbestpractice.interceptor.MyHandlerInterceptor1;
import com.example.apringmvcbestpractice.interceptor.MyHandlerInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
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
                .addPathPatterns("/api/v1/employee/**")
                .addPathPatterns("/**");     /*可以添加多个路径*/
    }

    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new Converter<String, UserDtoTestConverter>() {
            @Override
            public UserDtoTestConverter convert(String source) {
                if (source==null)
                    return null;
                String[] split = source.split(",");
                String name = split[0];
                Integer age = Integer.parseInt(split[1]);
                return new UserDtoTestConverter(name,age);
            }
        });
    }
}
