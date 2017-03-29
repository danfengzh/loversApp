package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/16.
 */

public class UserTextServiceTest extends baseServiceTest{
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserTextService userTextService;
    @Test
    public void insertText() throws Exception {

    }



    @Test
    public void getTextsByRecordsID() throws Exception {
        userTextService.getTextsByRecordsID(1);
        System.out.println("**********");
    }

    @Test
    public void deleteTextByID() throws Exception {

    }

}