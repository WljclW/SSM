package com.example.mybatis01helloword;


import com.example.mybatis01helloword.bean.Emp;
import com.example.mybatis01helloword.dao.EmpDynamicSqlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DynamicSqlTest {
    @Autowired
    private EmpDynamicSqlMapper empDynamicSqlMapper;

    @Test   //测试查询操作
    public void test01() {
        empDynamicSqlMapper.queryEmpByNameAndSalary(null, null);
    }

    @Test //测试更新操作
    public void test02(){
        Emp emp = new Emp();
        emp.setId(3);
//        emp.setEmpName("三号");
        emp.setEmpSalary(3333.33);
        emp.setAge(33);
        empDynamicSqlMapper.updateEmp(emp);
    }

    @Test
    public void test03(){
        empDynamicSqlMapper.queryEmpByNameAndSalaryWhen("aaa",new BigDecimal(3333));
//        empDynamicSqlMapper.queryEmpByNameAndSalaryWhen(null,new BigDecimal(3333));   //name如果是null会走第二个分支
    }

    @Test   //测试批量查询操作
    public void test04(){
        List<Integer> integers = Arrays.asList(1, 3, 5);
        integers = new ArrayList<>();
        List<Emp> empByIdIn = empDynamicSqlMapper.getEmpByIdIn(integers);
        for(Emp emp:empByIdIn){
            System.out.println(emp);
        }
    }

    @Test   //测试批量插入
    public void test05(){
        ArrayList<Emp> emps = new ArrayList<>();
        for(int i=0;i<100;i++){
            Emp emp = new Emp();
            emp.setAge(i+1);
            emp.setEmpName("night"+i);
            emp.setEmpSalary(10000.0+i);
            emps.add(emp);
        }
        empDynamicSqlMapper.addEmps(emps);
    }

    @Test
    public void test06(){
        ArrayList<Emp> emps = new ArrayList<>();
        for(int i=0;i<100;i++){
            Emp emp = new Emp();
            emp.setId(i+1);
            emp.setEmpName("_night_"+i);
            emp.setEmpSalary(10000.0+i);
            emps.add(emp);
        }
        empDynamicSqlMapper.updateEmps(emps);
    }
}
