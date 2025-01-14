package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 测试返回结果集的封装
 * */
@Mapper
public interface EmpReturnValueMapper {

    Long countEmp();    //查询记录数

    BigDecimal getEmpSalaryById(Integer id);    //查询id这个员工的薪资

    List<Emp> getAll();

    @MapKey("id")
    Map<Integer,Emp> getAllMap();

    Emp getEmpById(Integer id);
}
