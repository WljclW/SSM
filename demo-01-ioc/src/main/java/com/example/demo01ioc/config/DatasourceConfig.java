package com.example.demo01ioc.config;

import com.example.demo01ioc.datasource.MyDatasource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DatasourceConfig {

    /**
     * 下面是不同的环境需要配置的不同的数据源，开发、生产、测试环境。希望在不同的环境下使用
     *      不同的数据源，也就是说只有在生产环境下才把pro方法对应的bean添加到ioc容器...
     *
     * */

    @Profile({"dev","default"})
    @Bean
    public MyDatasource dev(){
        MyDatasource myDatasource = new MyDatasource();
        myDatasource.setUrl("jdbc:mysql://3306/dev");
        myDatasource.setUserName("dev_user");
        myDatasource.setPassword("dev_pwd");
        return myDatasource;
    }

    @Profile("pro")
    @Bean
    public MyDatasource pro(){
        MyDatasource myDatasource = new MyDatasource();
        myDatasource.setUrl("jdbc:mysql://3306/pro");
        myDatasource.setUserName("pro_user");
        myDatasource.setPassword("pro_pwd");
        return myDatasource;
    }

    @Profile("test")
    @Bean
    public MyDatasource test(){
        MyDatasource myDatasource = new MyDatasource();
        myDatasource.setUrl("jdbc:mysql://3306/test");
        myDatasource.setUserName("test_user");
        myDatasource.setPassword("test_pwd");
        return myDatasource;
    }

}
