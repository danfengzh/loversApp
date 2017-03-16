package org.loversAPP.SheduleTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/16.
 */
public class Client {
    public static void main(String [] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring/SheduleTask.xml");
        JobService jobService= (JobService) context.getBean("myJobTask");
        jobService.job1();
    }
}
