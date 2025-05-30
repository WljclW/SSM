package com.example.apringmvcbestpractice.validator;

import com.example.apringmvcbestpractice.annotation.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Validator;

public class GenderValidator implements ConstraintValidator<Gender,String> {
    /**
     *
     * @param value 前端提交来的准备让我们进行校验的属性值
     * @param context 校验上下文
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return "男".equals(value) || "女".equals(value);
    }
}
