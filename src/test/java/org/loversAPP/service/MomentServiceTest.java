package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.model.Moment;
import org.loversAPP.service.baseService.baseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/3.
 */
public class MomentServiceTest extends baseServiceTest {
    @Autowired
    private MomentService  momentService;
    @Test
    public void insertMoment() throws Exception {
        Moment moment=new Moment();
        moment.setUserid(2);
        moment.setMomenttype(15);
        moment.setMomentimage("");
        moment.setMomentdate(new Date());
        moment.setMomentcontent("对userid为"+2+"使用了道具：“let’s狗");
        momentService.insertMoment(moment);
       //  momentService.insertMoment(moment)
    }

}