package org.loversAPP.SheduleTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring/SheduleTask.xml"})
public class MySheduleTasksTest {
    @Autowired
    private MyJobTask myJobTask;
    @Test
    public void myMethod() throws Exception {

        myJobTask.job1();

    }

}