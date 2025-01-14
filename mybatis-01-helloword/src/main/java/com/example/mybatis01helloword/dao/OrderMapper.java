package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    //根据id查询订单 以及 订单对应的客户信息
    Order getOrderByIdWithCustomer(Long id);

}
