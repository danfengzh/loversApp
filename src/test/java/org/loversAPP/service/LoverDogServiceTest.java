package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.model.LoverDog;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/3.
 */
public class LoverDogServiceTest extends baseServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoverDogService  loverDogService;
    @Test
    public void test(){
        LoverDog loverDog=new LoverDog();
        loverDog.setInserttime(new Date());
        loverDog.setLoverid("vvv");
        loverDog.setUserID(2);
        loverDogService.inserLoverDog(loverDog);

        System.out.println("vvvv");
    }
}