package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Customer;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    //根据id查询客户以及客户下的所有订单。。其实这里需要定义一个返回类型(这个类型需要包括客户属性 以及 该客户的订单列表)，这里为了方便直接使用Customer类来代替
    Customer getCustomerByIdWithOrders(Long id);
}
