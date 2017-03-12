package org.loversAPP.service.Impl;

import org.junit.Test;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/12.
 */
public class LoverSigninServiceTest extends baseServiceTest{
    @Autowired
    private LoverSigninService loverSigninService;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void whetherAnotherinsertLoverSignin() throws Exception {
        int cc=loverSigninService.WhetherAnotherinsertLoverSignin(2);
        System.out.println("************************"+cc);
    }

    @Test
    public void insertLoverSignin() throws Exception {
        loverSigninService.insertLoverSignin(2);
    }

}