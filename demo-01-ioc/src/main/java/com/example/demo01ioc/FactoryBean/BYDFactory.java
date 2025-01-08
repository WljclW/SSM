package com.example.demo01ioc.FactoryBean;

import com.example.demo01ioc.Bean.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class BYDFactory implements FactoryBean<Car> {
    /**
     * 返回创建的对象
     * */
    @Override
    public Car getObject() throws Exception {
        System.out.println("正在造汽车........");
        return new Car();
    }

    /**
     * 返回创建对象的类型。。是针对于 多态性 设置的一个方法，比如接口可以有很多的实现类
     * */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
}
