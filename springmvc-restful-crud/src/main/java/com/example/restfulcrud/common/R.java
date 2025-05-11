package com.example.restfulcrud.common;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.DeleteMapping;

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
}
