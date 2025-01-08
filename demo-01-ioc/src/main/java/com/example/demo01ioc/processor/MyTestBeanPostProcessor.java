package com.example.demo01ioc.processor;

import com.example.demo01ioc.Bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyTestBeanPostProcessor implements BeanPostProcessor {

    /**
     * 此注解的两个抽象方法是有返回值。因此可以修改bean。
     * 参数：
     *      bean————传进来的bean
     *      beanName————传进来的bean的name
     * */
    @Override   //初始化之后 的 后置处理
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization方法执行........"+beanName);
        if(bean instanceof User hello){
            hello.setUsername("初始化完成前改名字测试");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization方法执行........."+beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
