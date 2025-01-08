package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order getOrderByIdWithCustomer(Long id);

}
