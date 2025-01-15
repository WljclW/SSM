package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * mybatis的动态sql实验
 * */
@Mapper
public interface EmpDynamicSqlMapper {
    List<Emp> queryEmpByNameAndSalary(@Param("name") String name,
                                      @Param("salaryy") BigDecimal salary);
}
