package com.example.mybatis01helloword;

import com.example.mybatis01helloword.bean.Emp;
import com.example.mybatis01helloword.dao.EmpReturnValueMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Map;

@SpringBootTest
public class ReturnValueTest {

    @Autowired
    EmpReturnValueMapper empReturnValueMapper;

    @Test
    void testEmpReturnValueMapper() {
        Long aLong = empReturnValueMapper.countEmp();
        System.out.println(aLong);

        BigDecimal empSalaryById = empReturnValueMapper.getEmpSalaryById(2);
        System.out.println(empSalaryById);

        empReturnValueMapper.getAll().forEach(System.out::println);

        System.out.println("=========================");
        Map<Integer, Emp> allMap = empReturnValueMapper.getAllMap();
        System.out.println(allMap);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
        Emp emp3 = allMap.get(3);
        System.out.println(emp3.getClass());
        System.out.println(emp3);
        System.out.println(emp3.getEmpName());
        System.out.println("********************************");

        Emp emp = empReturnValueMapper.getEmpById(3);
        System.out.println(emp);
    }
}
