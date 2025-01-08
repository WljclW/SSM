package com.example.demo01ioc.service;

import lombok.Data;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Data
public class HahaService implements EnvironmentAware, BeanNameAware {

    Environment ev;
    String myName;

    @Override
    public void setEnvironment(Environment environment) {
        this.ev = environment;
    }

    public String getOS(){
        return this.ev.getProperty("OS");
    }


    @Override
    public void setBeanName(String name) {
        this.myName = name;
    }
}
