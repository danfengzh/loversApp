package org.loversAPP.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/20.
 */
public class myserviceTest {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:Quartz/quartz.xml");
        System.out.println("test  start");
        System.out.println("test   end");

    }
}