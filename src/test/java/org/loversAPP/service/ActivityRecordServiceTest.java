package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/6.
 */
public class ActivityRecordServiceTest  extends baseServiceTest {
   @Autowired
    private ActivityRecordService activityRecordService;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void twest(){
        activityRecordService.deleteRecordByID(10);
    }
}