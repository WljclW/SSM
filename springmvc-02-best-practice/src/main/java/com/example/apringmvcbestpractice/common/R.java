package com.example.apringmvcbestpractice.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    public static<T> R<T> ok(T data){
        R<T> r = new R();
        r.setMessage("ok");
        r.setData(data);
        r.setCode(200);
        return r;
    }

    public static R ok(){
        R r = new R();
        r.setMessage("ok");
        r.setCode(200);
        return r;
    }

    public static R error(int code,String message){
        R r = new R();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }


    public static R error(int i, String msg, Object data) {
        R r = new R();
        r.setCode(i);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }
}
