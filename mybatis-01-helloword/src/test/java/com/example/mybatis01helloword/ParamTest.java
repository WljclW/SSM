package com.example.mybatis01helloword;

import com.example.mybatis01helloword.bean.Emp;
import com.example.mybatis01helloword.dao.EmpParamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest     //不加这个注解会报错：Cannot invoke "com.example.mybatis01helloword.dao.EmpParamMapper.getEmploy(java.lang.Long)" because "this.empParamMapper" is null
public class ParamTest {
    @Autowired
    EmpParamMapper empParamMapper;

    @Test
    void paramTest03(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","jerry");
        Emp emp = new Emp();
        emp.setEmpSalary(666.66);
        empParamMapper.getEmployHaha(2L,objectObjectHashMap, Arrays.asList(20L,19L,21L,22L,34L),emp);
    }


    @Test
    void paramTest02(){
        Emp zhangsan = empParamMapper.getEmployByIdAndName(2L, "jerry");
        System.out.println(zhangsan);
    }


    @Test
    public void test01() {
        Emp employ = empParamMapper.getEmploy(2L);
        System.out.println(employ);
    }
}
