package com.example.mybatis01helloword;

import com.example.mybatis01helloword.bean.Emp;
import com.example.mybatis01helloword.dao.EmpParamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 测试 接口中方法的形参 和 xml文件中SQL使用变量 的对应关系
 * */
@SpringBootTest     //不加这个注解会报错：Cannot invoke "com.example.mybatis01helloword.dao.EmpParamMapper.getEmploy(java.lang.Long)" because "this.empParamMapper" is null
public class ParamTest {
    @Autowired
    EmpParamMapper empParamMapper;

    @Test
    void paramTest03(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","jerry");
        objectObjectHashMap.put("name1","jerry02");
        Emp emp = new Emp();
        emp.setEmpSalary(666.66);
        System.out.println(empParamMapper.getEmployHaha(6L, objectObjectHashMap, Arrays.asList(20L, 19L, 21L, 22L, 34L), emp));
    }


    @Test
    void paramTest02(){
        Emp zhangsan = empParamMapper.getEmployByIdAndName(2L, "jerry");
        System.out.println(zhangsan);
    }

    @Test
    void paramTestEmp(){
        Emp emp = new Emp();
        emp.setEmpName("jerry01");
        emp.setAge(21);
        emp.setEmpSalary(666.66);
        empParamMapper.addEmploy(emp);
    }

    @Test
    public void test01() {
        Emp employ = empParamMapper.getEmploy(2L);
        System.out.println(employ);
    }
}
