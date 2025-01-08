package com.example.demo01ioc.config;


import ch.qos.logback.core.CoreConstants;
import com.example.demo01ioc.Bean.Car;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "com.example")
@Import({CoreConstants.class})
@Configuration
public class AppConfig {
}
