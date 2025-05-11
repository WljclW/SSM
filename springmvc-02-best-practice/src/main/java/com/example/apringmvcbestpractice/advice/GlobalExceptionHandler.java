package com.example.apringmvcbestpractice.advice;


import com.example.apringmvcbestpractice.common.R;
import com.example.apringmvcbestpractice.exception.BizException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author: Zhou
 * @date: 2025/5/11 12:41
 * 全局异常处理
 * 如果出现了异常：本类和全局都不能处理，
 * SpringBoot底层对SpringMVC有兜底处理机制；自适应处理（浏览器响应页面、移动端会响应json）
 * 最佳实践：我们编写全局异常处理器，处理所有异常
 *
 *      前端关心异常状态，后端正确业务流程。
 * 推荐：后端只编写正确的业务逻辑，如果出现业务问题，后端通过抛异常的方式提前中断业务逻辑。前端感知异常；
 */

//@RestControllerAdvice //@RequestBody+@ControllerAdvice..有这个注解时Swagger生不成接口文档
//@ControllerAdvice /*表示处理所有controller方法的异常*/
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e) {
        System.out.println("【全局】 - ArithmeticException 处理");
        return R.error(500, e.getMessage());
    }


    @ExceptionHandler(BizException.class)
    public R handleBizException(BizException e) {
        Integer code = e.getCode();
        String msg = e.getMessage();
        return R.error(code, msg);
    }

    // 最终的兜底
    @ExceptionHandler(Throwable.class)
    public R error(Throwable e) {
        System.out.println("【全局】 - Exception处理" + e.getClass());
        return R.error(500, e.getMessage());
    }

    /**
     * @author: Zhou
     * @date: 2025/5/11 17:14
     * 对于数据校验的异常建议这麽使用。数据校验的异常类：MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R error(MethodArgumentNotValidException e){
        /*1. 拿到数据校验的结果*/
        BindingResult result = e.getBindingResult();
        /*2. 遍历发生校验错误的属性，存入map并返回*/
        HashMap<String, String> map = new HashMap<>();
        for (FieldError fieldError:result.getFieldErrors()){
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            map.put(field,defaultMessage);
        }
        return R.error(500,"校验失败",map);
    }
}
