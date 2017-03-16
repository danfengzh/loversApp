package org.loversAPP.dao;

import org.junit.Test;
import org.loversAPP.DTO.UserText;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public class TextRecordsMapperTest extends baseServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TextRecordsMapper textRecordsMapper;
    @Test
    public void getTextsByRecordsID() throws Exception {
         List<UserText> texts=textRecordsMapper.getTextsByRecordsID(1);
        System.out.println("*********");
    }

}