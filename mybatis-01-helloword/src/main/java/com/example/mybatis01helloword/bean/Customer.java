package com.example.mybatis01helloword.bean;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Long id;
    private String customerName;
    private String phone;

    List<Order> orderds;        //用于封装此用户的所有订单
}
