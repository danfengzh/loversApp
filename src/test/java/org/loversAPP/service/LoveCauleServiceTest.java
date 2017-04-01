package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.model.LoverCapsule;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/1.
 */
public class LoveCauleServiceTest extends baseServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoveCauleService loveCauleService;
    @Test
    public void insertCapsule() throws Exception {
        LoverCapsule  loverCapsule=new LoverCapsule();
        loverCapsule.setReceiverid(2);
        loverCapsule.setPhoto("/vvvv");
        loverCapsule.setItemid(5);
        loverCapsule.setOpenday(new Date());
        loverCapsule.setContent("vvvvv");
         loveCauleService.insertCapsule(loverCapsule);
         loverCapsule.setUserid(55);
         loverCapsule.setState("0");
        System.out.println("vvvvvvvvvvvvvvvvv");
    }

    @Test
    public void setStateByID() throws Exception {
        loveCauleService.setStateByID(1,"2");
    }

    @Test
    public void getCapsuleByID() throws Exception {
    }

}