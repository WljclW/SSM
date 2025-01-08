package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Customer;
import com.example.mybatis01helloword.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderCustomerStepMapper {

    Customer gteCustomerById(Long id);

    List<Order> getOrdersByCustomerId(Long id);


    /**
     *
     * @param id 客户id
     * @return
     */
    //3、分步查询：自动做两步 = 查询客户 + 查询客户下的订单
    //这个方法去哦们希望：让mybaits来自动调用分布查询，直接返回id对应用户的所有订单
    Customer getOrdersByCustomerIdWithStep(Long id);


    /**
     *
     * @param id 订单id
     * @return
     */
    //4、分步查询：自动做两步 = 按照id查询订单 + 查询下单的客户
    Order getOrderByIdAndCustomerStep(Long id);

}
