package org.loversAPP.SheduleTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring/spring-*.xml"})
public class MySpecialSheduleTaskJobTest {


    MySpecialSheduleTaskJob mySpecialSheduleTaskJob=new MySpecialSheduleTaskJob();

    @Test
    public void test(){
        mySpecialSheduleTaskJob.testInsert();
    }

}