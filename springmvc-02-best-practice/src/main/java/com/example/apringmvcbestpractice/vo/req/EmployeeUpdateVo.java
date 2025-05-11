package com.example.apringmvcbestpractice.vo.req;

import com.example.apringmvcbestpractice.annotation.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeUpdateVo {
    /*更新员工时要求id必须带，其他的不带就可以，因此只需要校验有id就行*/
    @NotNull
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
