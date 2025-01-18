package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author luck-jay
 * @date 2025/1/17 17:17
 */

@Mapper
public interface EmpDynamicSqlMapperPractice {
    List<Emp> queryEmpByNameAndSalary(@Param("name") String name,
                                      @Param("salaryy") BigDecimal salary);

    void updateEmp(Emp emp);

    List<Emp> queryEmpByNameAndSalaryWhen(@Param("name") String name,
                                          @Param("salaryy") BigDecimal salary);   //在一定条件下查询

    List<Emp> getEmpByIdIn(List<Integer> ids);  //批量查询


    void addEmps(List<Emp> emps); //批量添加
//
//    /**
//     * 批量更新操作需要在数据库连接配置中使用"allowMultiQueries=true",表示支持 一次发送多个SQL，中间分号隔开.
//     * 【注意】一次发送多个SQL，需要在配置问价中——数据库的连接配置中添加allowMultiQueries=true
//     * */
    void updateEmps(List<Emp> emps);


}
