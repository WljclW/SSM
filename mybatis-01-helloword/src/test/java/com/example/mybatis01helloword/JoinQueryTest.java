package com.example.mybatis01helloword;

import com.example.mybatis01helloword.bean.Customer;
import com.example.mybatis01helloword.bean.Order;
//import com.example.mybatis01helloword.dao.CustomerMapper;
import com.example.mybatis01helloword.dao.CustomerMapper;
import com.example.mybatis01helloword.dao.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JoinQueryTest {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CustomerMapper customerMapper;

    @Test
    void testOrder() {
        Order orderByIdWithCustomer = orderMapper.getOrderByIdWithCustomer(1L);
        System.out.println(orderByIdWithCustomer);
    }

    @Test
    void testCustomer() {
        Customer customerByIdWithOrders = customerMapper.getCustomerByIdWithOrders(1L);
        System.out.println(customerByIdWithOrders);
    }
}
