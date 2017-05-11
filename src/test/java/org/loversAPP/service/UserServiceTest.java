package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.Controller.utils.DateUtil;
import org.loversAPP.DTO.PositionUser;
import org.loversAPP.DTO.StepToday;
import org.loversAPP.model.User;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */
public class UserServiceTest extends baseServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Test
    public void getUserByID() throws Exception {
      User user= userService.getUserByID(1);
        System.out.println(user+"*******************");
    }

    @Test
    public void getIDByPhoneAndPw() throws Exception {
         int result=  userService.getIDByPhoneAndPw("883883","siiwiiw");
       System.out.println(result+"***************");

    }

    @Test
    public void insertUser() throws Exception {
        List<PositionUser>  positionUsers=   userService.getAllPositionUsers();
        System.out.println(">>>>>>");
    }

    @Test
    public void updatePwByID() throws Exception {
      int count=     userService.updateSexByID(6,"男");
        System.out.println("*******************");
    }

    @Test
    public void updateAvatarByID() throws Exception {

    }

    @Test
    public void updateUserNameByID() throws Exception {
      User cou= userService.isExistUser("aaabb","13259715262");
        System.out.println("***************"+cou);
    }

    @Test
    public void getIDByInviteCode() throws Exception {
      User user=  userService.getUserByID(106);
        System.out.println();
    }

    @Test
    public void deleteUserByID() throws Exception {
        System.out.println(userService.getMaxID());
    }

    @Test
    public void getAllUsers() throws Exception {
       StepToday stepToday= userService.getSteps(104,null);
       userService.updateSteps(104, DateUtil.getDay(),20);
        System.out.println("bbbb");
    }

}