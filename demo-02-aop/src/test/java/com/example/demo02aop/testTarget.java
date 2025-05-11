package com.example.demo02aop;

import com.example.demo02aop.Aspectj_review.Target;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mini-zch
 * @date 2025/5/7 9:48
 */
@SpringBootTest
public class testTarget {
    @Autowired
    Target target;

    @Test
    public void test01(){
        System.out.println(target.method01("456","123"));
    }
}
