package com.example.demo02aop;/**
 * @author luck-jay
 * @date 2025/2/6 14:59
 */

import com.example.demo02aop.AspectJ.TargetClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;


/**
 * 关于AspectJ这个包程序的测试
 * @author mini-zch
 * @date 2025/2/6 14:59
 */
@SpringBootTest
public class AspectJPackageTest {

    @Autowired
    private TargetClass targetclass;

    @Test
    public void test_AspectJ(){
        System.out.println(targetclass.targetMethod("123", "456"));
    }
}
