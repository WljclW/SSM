package com.example.mybatis01helloword;


import com.example.mybatis01helloword.bean.Customer;
import com.example.mybatis01helloword.bean.Order;
import com.example.mybatis01helloword.dao.OrderCustomerStepMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StepTest {

    @Autowired
    OrderCustomerStepMapper orderCustomerStepMapper;

    @Test
    void test01(){
        Order orderByIdAndCustomerStep = orderCustomerStepMapper.getOrderByIdAndCustomerStep(1L);
        System.out.println(orderByIdAndCustomerStep);
    }

    @Test
    void test02(){
        Customer ordersByCustomerIdWithStep = orderCustomerStepMapper.getOrdersByCustomerIdWithStep(1L);
        System.out.println(ordersByCustomerIdWithStep);
    }




    @Test
    void test03(){
        Order orderByIdAndCustomerWithOrdersStep2 = orderCustomerStepMapper.getOrderByIdAndCustomerAndOtherOrdersStep(1L);
        System.out.println(orderByIdAndCustomerWithOrdersStep2);
    }
}
