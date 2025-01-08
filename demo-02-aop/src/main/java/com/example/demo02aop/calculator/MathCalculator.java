package com.example.demo02aop.calculator;

import org.springframework.stereotype.Component;


public interface MathCalculator {

    int add(int i,int j);

    int sub(int i,int j);

    int mutil(int i,int j);

    int dev(int i,int j);
}
