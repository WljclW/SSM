package com.example.robotspringbootstarter.controller;


import com.example.robotspringbootstarter.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {
    @Autowired
    private RobotService robotService;

    @GetMapping("/robot/hello")
    public String hello(){
        return robotService.sayHello();
    }
}
