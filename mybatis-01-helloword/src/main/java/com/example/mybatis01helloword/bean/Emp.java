package com.example.mybatis01helloword.bean;

import lombok.Data;

@Data
public class Emp {
    //下面的字段名称 遵循 驼峰命名

    private Integer id;
    private String empName; //注意：数据库中的名字是以_分隔
    private Integer age;
    private Double empSalary;
}
