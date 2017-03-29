package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.model.SheduleTest;
import org.loversAPP.service.baseService.baseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/28.
 */
public class SheduleTestServiceTest extends baseServiceTest{
    @Autowired
    private SheduleTestService sheduleTestService;
    @Test
    public void insertSheduleTest() throws Exception {
        SheduleTest sheduleTest=new SheduleTest();
        sheduleTest.setCurrentDate(new Date());
        sheduleTest.setContent("cccc");
        sheduleTestService.insertSheduleTest(sheduleTest);
    }

    @Test
    public void updateSheduleTestInfoByID() throws Exception {
    }

}