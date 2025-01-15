package com.example.mybatis01helloword;


import com.example.mybatis01helloword.dao.EmpDynamicSqlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class DynamicSqlTest {
    @Autowired
    private EmpDynamicSqlMapper empDynamicSqlMapper;

    @Test
    public void test01() {
        empDynamicSqlMapper.queryEmpByNameAndSalary(null, new BigDecimal(1000));
    }
}
