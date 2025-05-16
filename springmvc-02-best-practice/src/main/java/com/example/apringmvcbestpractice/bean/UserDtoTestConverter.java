package com.example.apringmvcbestpractice.bean;

import lombok.Data;

/**
 * @author mini-zch
 * @date 2025/5/16 10:09
 */
@Data
public class UserDtoTestConverter {
        //用户名
        private String name;
        //年龄
        private Integer age;

        public UserDtoTestConverter(String name, Integer age) {
                this.name = name;
                this.age = age;
        }
        //省略getter、setter方法
}
