package com.example.demo02aop.service.impl;

import com.example.demo02aop.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println("UserService的方法执行-------");
    }
}
