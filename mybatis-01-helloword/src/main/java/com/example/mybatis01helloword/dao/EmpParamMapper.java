package com.example.mybatis01helloword.dao;

import com.example.mybatis01helloword.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * MyBatis的参数传递方式(xxxMapper接口中的参数 和 xml文件中SQL语句所使用的参数)：
 * 单个参数：
 *   1、#{参数名} 就可以取值。
 *   2、Map和JavaBean，#{key/属性名} 都可以取值。
 * 多个参数：
 *   用@Param指定参数名， #{参数名} 就可以取值。
 */


@Mapper//告诉Spring，这是MyBatis操作数据库用的接口; Mapper接口
public interface EmpParamMapper {

    Emp getEmploy(Long id);

    // 获取数组中第二个元素(id值)指定的用户
    Emp getEmploy02(List<Long> ids);

    // 对象属性取值，直接获取
    void addEmploy(Emp e);


    // map中的属性也是直接取值
    void addEmploy2(Map<String, Object> m);


    //==========以上是单个参数测试，下面是方法有多个参数的实验==============

    //  以后多个参数直接规范一点，用@Param指定参数名， #{参数名} 就可以取值。【在java中通过@Param指定参数名，在xml文件中通过这个指定的参数
    // 名就可以拿到java方法中对应的形参变量】
    Emp getEmployByIdAndName(@Param("id") Long id, @Param("empName") String name);


    // 想实现的功能：
    // select * from emp where id = #{id} and emp_name = #{从map中取到的name} and age = #{ids的第三个参数值} and salary = #{e中的salary}
    Emp getEmployHaha(@Param("id") Long id,
                      @Param("m") Map<String,Object> m,
                      @Param("ids") List<Long> ids,
                      @Param("e") Emp e);
}
