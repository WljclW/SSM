package com.example.mybatis01helloword;

import com.example.mybatis01helloword.bean.Emp;
import com.example.mybatis01helloword.dao.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatis01HellowordApplicationTests {

    @Autowired
    EmpMapper empMapper;    //容器中放的是spring创建的代理对象，比如：class jdk.proxy2.$Proxy68


    @Test
    void testAll(){
        List<Emp> allEmp = empMapper.getAllEmp();
        for(Emp emp : allEmp){
            System.out.println(emp);
        }
    }


    @Test
    void testCRUD(){
        Emp emp = new Emp();
        emp.setId(5);
        emp.setEmpName("张三a");
        emp.setAge(20);
        emp.setEmpSalary(900.0);
//        empMapper.addEmp(emp);
//        empMapper.updateEmp(emp);
        empMapper.deleteEmpById(5);
    }


    @Test
    void contextLoads() {
        System.out.println(empMapper.getClass());
        Emp emp = empMapper.getEmpById(1);
        System.out.println(emp);
    }

}
