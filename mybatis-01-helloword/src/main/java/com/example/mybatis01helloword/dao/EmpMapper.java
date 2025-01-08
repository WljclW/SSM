package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    Emp getEmpById(Integer id);

    List<Emp> getAllEmp();

    void addEmp(Emp emp);

    void deleteEmpById(Integer id);

    void updateEmp(Emp emp);
}
