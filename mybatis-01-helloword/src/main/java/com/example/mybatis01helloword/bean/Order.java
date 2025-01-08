package com.example.mybatis01helloword.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private Long id;
    private String address;
    private BigDecimal amount;
    private Long customerId;

    private Customer customer;      //像这种内部持有其他类型对象时，调用是依次调用该对象的tostring方法
}
