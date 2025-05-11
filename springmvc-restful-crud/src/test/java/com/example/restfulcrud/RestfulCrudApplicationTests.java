package com.example.restfulcrud;

import com.example.restfulcrud.bean.Employee;
import com.example.restfulcrud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestfulCrudApplicationTests {

    @Autowired
    EmployeeService employeeService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetEmpById(){
        Employee emp = employeeService.getEmp(1L);
        System.out.println(emp);
    }

}
