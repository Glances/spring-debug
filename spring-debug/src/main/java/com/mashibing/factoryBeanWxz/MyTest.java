package com.mashibing.factoryBeanWxz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("factoryBeanWxz.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }
}
