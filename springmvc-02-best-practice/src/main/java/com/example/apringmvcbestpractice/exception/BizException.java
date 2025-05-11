package com.example.apringmvcbestpractice.exception;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

/**
 * @author: Zhou
 * @date: 2025/5/11 15:51
 * 一、业务异常类型定义。
 *      code是定义的业务一场码；
 *      message是对应的异常提示信息。
 * 二、其中不同的业务模块可能有不同的异常信息标志，比如根据第一个数字来区分不同的业务系统：
 * 1、订单  1xxxx
 *      10001 订单已关闭
 *      10002 订单不存在
 *      10003 订单超时
 *      .....
 * 2、商品  2xxxx
 *       20001 商品已下架
 *       20002 商品已售完
 *       20003 商品库存不足
 *       ......
 * 3、用户
 *      30001 用户已注册
 *      30002 用户已登录
 *      30003 用户已注销
 *      30004 用户已过期
 *
 * 4、支付
 *      40001 支付失败
 *      40002 余额不足
 *      40003 支付渠道异常
 *      40004 支付超时
 */
@Data
public class BizException extends RuntimeException{
    private Integer code;
    private String message;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(BizExceptionEnume exceptionEnume) {
        super(exceptionEnume.getMessage());
        this.code = exceptionEnume.getCode();
        this.message = exceptionEnume.getMessage();
    }
}
