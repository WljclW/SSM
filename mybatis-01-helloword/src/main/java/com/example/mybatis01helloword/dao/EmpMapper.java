package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 实现基本的crud操作
 * */
@Mapper
public interface EmpMapper {

    Emp getEmpById(Integer id);

    List<Emp> getAllEmp();  //获取该表所有的记录

    void addEmp(Emp emp);   //由于只有一个参数，因此xml中直接使用#{属性名}来拿属性就行。比如#{empName}表示拿出emp对象的empName属性

    void deleteEmpById(Integer id);

    void updateEmp(Emp emp);
}
