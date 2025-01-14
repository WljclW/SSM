package com.example.mybatis01helloword;

import com.example.mybatis01helloword.bean.Emp;
import com.example.mybatis01helloword.dao.EmpMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Mybatis01HellowordApplicationTests {

    @Autowired
    EmpMapper empMapper;    //容器中放的是spring创建的代理对象，比如：class jdk.proxy2.$Proxy68

    @Resource       //为什么这里换成@Autowired会出错
    DataSource dataSource;

    @Test
    void testAll(){
        List<Emp> allEmp = empMapper.getAllEmp();
        for(Emp emp : allEmp){
            System.out.println(emp);
        }
    }


    @Test
    void testCRUD(){
        Emp emp = new Emp();
        emp.setId(5);
        emp.setEmpName("张三a");
        emp.setAge(20);
        emp.setEmpSalary(900.0);
//        empMapper.addEmp(emp);
//        empMapper.updateEmp(emp);
        empMapper.deleteEmpById(5);
    }


    @Test
    void contextLoads() {
        System.out.println(empMapper.getClass());
        Emp emp = empMapper.getEmpById(1);
        System.out.println(emp);


        /**
         * #{}和${}的区别：
         * // #{}取值： 预编译方式
         *         // Preparing: select id,emp_name empName,age,emp_salary empSalary from t_emp where id = ?
         *         // Parameters: 1(Integer)
         *         // Total: 1
         *         Emp empById = empMapper.getEmpById(1);
         *
         *         // ${}取值：拼接方式
         *         // select id,emp_name empName,age,emp_salary empSalary from t_emp where id = 1
         * */
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //        //${}底层拼接方式： SQL注入问题
//        String sql2 = "select * from user where username = 'admin' and password = ' ' or 1=1 or 1='' ";
//        Statement statement = connection.createStatement();
//        statement.execute("select * from t_emp where id = " + 2);
        String sql = "select * from user where username = ? and password = ? ";
        //#{}底层预编译方式：
        PreparedStatement preparedStatement;

        {
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "admin");
                preparedStatement.setString(2, "123456");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
