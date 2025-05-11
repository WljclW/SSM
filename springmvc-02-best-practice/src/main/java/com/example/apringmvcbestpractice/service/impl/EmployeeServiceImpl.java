package com.example.apringmvcbestpractice.service.impl;

import com.example.apringmvcbestpractice.bean.Employee;
import com.example.apringmvcbestpractice.dao.EmployeeDao;
import com.example.apringmvcbestpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao; //包装一下

    @Override
    public Employee getEmp(Long id) {
        Employee empById = employeeDao.getEmpById(id);
        return empById;
    }

    /**
     * 在dao层的基础上做了封装，保证原始内容不会北更新为null
     * @description:
     * @param employee:
     * @return void
     * @author: Zhou
     * @date: 2025/5/10 0:15
     */
    @Override
    public void updateEmp(Employee employee) {
        if (employee.getId()==null) return;
        //先根据要更新的员工对象拿到对应的id
        Employee origin = employeeDao.getEmpById(employee.getId());
        //=======以下用页面值覆盖默认值=============
        //2、把页面带来的覆盖原来的值，页面没带的自然保持原装
        if(StringUtils.hasText(employee.getName())){ //判断name有值（不是null、不是空串、不是空白字符// ）
            //把数据库的值改为页面传来的值
            origin.setName(employee.getName());
        }

        if(StringUtils.hasText(employee.getEmail())){
            origin.setEmail(employee.getEmail());
        }

        if (StringUtils.hasText(employee.getAddress())){
            origin.setAddress(employee.getAddress());
        }

        if (StringUtils.hasText(employee.getGender())){
            origin.setGender(employee.getGender());
        }

        if(employee.getAge() != null){
            origin.setAge(employee.getAge());
        }

        if(employee.getSalary() != null){
            origin.setSalary(employee.getSalary());
        }

        //以上判断，把页面提交的值，赋值给数据库的记录
        employeeDao.updateEmp(origin);
    }

    @Override
    public void saveEmp(Employee employee) {
        employeeDao.addEmp(employee);
    }

    @Override
    public void deleteEmp(Long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public List<Employee> getList() {
        return employeeDao.getList();
    }
}
