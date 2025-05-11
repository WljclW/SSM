package com.example.apringmvcbestpractice.exception;

import lombok.Getter;

/**
 * @author: Zhou
 * @date: 2025/5/11 15:49
 * 所有"业务异常"的枚举类。在这里列举所有的业务异常
 */
public enum BizExceptionEnume {

    /*ORDER业务的异常：ORDER_xxxx，异常码以1开始，1xxxxx*/
    ORDER_CLOSED(10001, "订单已关闭"),
    ORDER_NOT_EXIST(10002, "订单不存在"),
    ORDER_TIMEOUT(10003, "订单超时"),
    /*PRODUCT业务的异常：PRODUCT_xxxx，异常码以2开始，2xxxx*/
    PRODUCT_STOCK_NOT_ENOUGH(20003, "库存不足"),
    PRODUCT_HAS_SOLD(20002, "商品已售完"),
    PRODUCT_HAS_CLOSED(20001, "商品已下架");

    @Getter
    private Integer code;
    @Getter
    private String message;
    private BizExceptionEnume(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
