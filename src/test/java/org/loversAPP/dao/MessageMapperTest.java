package org.loversAPP.dao;

import org.junit.Test;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/5.
 */
public class MessageMapperTest extends baseServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageMapper messageMapper;
    @Test
    public void getMaxIDbyUserid() throws Exception {
       int res=  messageMapper.getMaxIDbyUserid();
        System.out.println("ccc");
    }

}