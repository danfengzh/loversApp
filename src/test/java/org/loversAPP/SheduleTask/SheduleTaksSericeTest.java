package org.loversAPP.SheduleTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/Spring/spring-*.xml","classpath:/Quartz/TimeShedule.xml"})
public class SheduleTaksSericeTest {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());
   @Test
   public void test(){
       System.out.println("start  .....");
       ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:/Quartz/TimeShedule.xml");
       System.out.println("/......endd");
   }


}
