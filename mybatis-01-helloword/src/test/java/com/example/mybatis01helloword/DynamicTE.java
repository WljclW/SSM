package com.example.mybatis01helloword;/**
 * @author luck-jay
 * @date 2025/1/17 17:23
 */

import com.example.mybatis01helloword.bean.Emp;
import com.example.mybatis01helloword.dao.EmpDynamicSqlMapperPractice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class DynamicTE {
    @Autowired
    EmpDynamicSqlMapperPractice empDynamicSqlMapperPractice;

    @Test
    public void test01(){
//        empDynamicSqlMapperPractice.queryEmpByNameAndSalary("zhangsan",new BigDecimal(1000));
        empDynamicSqlMapperPractice.queryEmpByNameAndSalary(null,new BigDecimal(1000));
        empDynamicSqlMapperPractice.queryEmpByNameAndSalary(null,null);
    }

    @Test
    public void test02(){
        Emp emp = new Emp();
        emp.setId(2);
        emp.setEmpName("zhangsan");
        emp.setEmpSalary(1212.0);
//        emp.setAge(20);
        empDynamicSqlMapperPractice.updateEmp(emp);
    }

    @Test
    public void test03(){
        Emp emp = new Emp();
//        emp.setEmpName("zhangsan");
        emp.setEmpSalary(1200.0);
        empDynamicSqlMapperPractice.queryEmpByNameAndSalaryWhen(emp.getEmpName(),new BigDecimal(emp.getEmpSalary()));
    }
    @Test
    public void test04257(){
//        List<Emp> empByIdIn = empDynamicSqlMapperPractice.getEmpByIdIn(Arrays.asList(1, 3, 7, 9));
//        List<Emp> empByIdIn = empDynamicSqlMapperPractice.getEmpByIdIn(Arrays.asList());
        List<Emp> empByIdIn = empDynamicSqlMapperPractice.getEmpByIdIn(null);
        for (Emp emp : empByIdIn) {
            System.out.println(emp);
        }
    }

    @Test
    public void test05(){
        ArrayList<Emp> emps = new ArrayList<>();
        for(int i=0;i<100;i++){
            Emp emp = new Emp();
            emp.setEmpName("luck_"+i);
            emp.setAge(66);
            emp.setEmpSalary(666.66);
            emps.add(emp);
        }
        empDynamicSqlMapperPractice.addEmps(emps);
    }

    @Test
    public void test06(){
        ArrayList<Emp> emps = new ArrayList<>();
        for(int i=0;i<100;i++){
            Emp emp = new Emp();
            emp.setEmpName("__luck__"+i);
//            emp.setAge(99);
//            emp.setEmpSalary(666.66);
//            emp.setId(i);
            emps.add(emp);
        }
        empDynamicSqlMapperPractice.updateEmps(emps);
    }

}
