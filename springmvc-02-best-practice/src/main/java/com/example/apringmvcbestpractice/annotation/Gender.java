package com.example.apringmvcbestpractice.annotation;


import com.example.apringmvcbestpractice.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {GenderValidator.class}) /*校验注解绑定校验器。。即告诉spring，这个注解被哪一个校验器校验,写校验器的全类名*/
public @interface Gender {
    /*
    * 校验注解必须包含下面的3个属性
    *   JSR-303 明确规定：所有自定义校验注解必须包含 message、groups 和 payload 这三个元素，否则
    * 违反接口契约，无法被校验框架识别。
    * */

    /*校验出错时的提示信息*/
    String message() default "{jakarta.validation.constraints.NotNull.message}";
    /*
    * 用于分组校验，配合 @Validated({Group1.class}) 使用，可在不同场景下控制哪些字段需要校验。
    * */
    Class<?>[] groups() default { };
    /*
    *   几乎不常用，保留给框架或扩展使用。比如，你可以自定义 Payload 来携带一些元数据、分配错误等
    * 级等。
    * */
    Class<? extends Payload>[] payload() default { };
}
