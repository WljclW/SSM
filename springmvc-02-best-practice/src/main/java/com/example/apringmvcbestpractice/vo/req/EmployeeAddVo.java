package com.example.apringmvcbestpractice.vo.req;

import com.example.apringmvcbestpractice.annotation.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author: Zhou
 * @date: 2025/5/11 17:53
 * 前端想add员工时会将前端传来的数据封装为EmployeeAddVo，封装的过程中需要数据校验
 */
@Data /*注意：在使用validate的相关注解时要求当前类必须标注@Data，否则所有的校验都不会通过*/
public class EmployeeAddVo {
    @Schema(description = "员工姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotNull
    @Max(value = 150,message = "年龄最大是150")
    @Min(value = 0,message = "年龄最小值是0")
    @Schema(description = "员工年龄")
    private Integer age;
    @Schema(description = "员工邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;
    @Schema(description = "员工性别")
    @Gender(message = "性别仅能是男/女")
    private String gender;
    @Schema(description = "员工地址")
    private String address;
    @Schema(description = "员工薪资")
    private BigDecimal salary;

    private Date birth;
}
