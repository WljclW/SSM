package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpReturnValueMapper {

    Long countEmp();

    BigDecimal getEmpSalaryById(Integer id);

    List<Emp> getAll();

    @MapKey("id")
    Map<Integer,Emp> getAllMap();

    Emp getEmpById(Integer id);
}
