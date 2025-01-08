package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Customer;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    Customer getCustomerByIdWithOrders(Long id);
}
