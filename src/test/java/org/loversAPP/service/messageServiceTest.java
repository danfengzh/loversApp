package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.DTO.UserMessage;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/6.
 */
public class messageServiceTest extends baseServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private messageService  messageService;
    @Test
    public void insertMessage() throws Exception {
       List<UserMessage> messageList= messageService.getMessageByRecID(113);
        System.out.println("vvvv");
    }

}