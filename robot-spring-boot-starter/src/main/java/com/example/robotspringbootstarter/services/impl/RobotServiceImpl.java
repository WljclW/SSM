package com.example.robotspringbootstarter.services.impl;

import com.example.robotspringbootstarter.properties.RobotProperties;
import com.example.robotspringbootstarter.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RobotServiceImpl implements RobotService {
    @Autowired
    RobotProperties robotProperties;

    @Override
    public String sayHello() {
        System.out.println(robotProperties.getName());
        return "机器人的名字："+robotProperties.getName()+" 机器人的型号："+robotProperties.getModel();
    }
}
