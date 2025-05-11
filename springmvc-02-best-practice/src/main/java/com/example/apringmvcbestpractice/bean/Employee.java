package com.example.apringmvcbestpractice.bean;


import com.example.apringmvcbestpractice.annotation.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author: Zhou
 * @date: 2025/5/11 17:53
 * 跟数据库交互的bean，不需要标注注解
 */
@Data
public class Employee {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
    private Date birth;
}
