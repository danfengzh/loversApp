package org.loversAPP.Controller;

import org.junit.Test;
import org.loversAPP.DTO.UserText;
import org.loversAPP.service.UserTextService;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/6.
 */
public class activity_recordsControllerTest extends baseServiceTest {
    private final Logger  logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserTextService userTextService;
    @Test
    public void getTextsExceptOne() throws Exception {
      List<UserText> userTextList=  userTextService.getTextsExceptOne(106);
        System.out.println("vvv");
    }

}