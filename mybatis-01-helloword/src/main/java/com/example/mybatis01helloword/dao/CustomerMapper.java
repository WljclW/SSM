package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Customer;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    //根据id查询客户以及客户下的所有订单
    Customer getCustomerByIdWithOrders(Long id);
}
