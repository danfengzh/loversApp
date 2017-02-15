package org.loversAPP.service;

import org.junit.Test;
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

    }

    @Test
    public void updatePwByID() throws Exception {

    }

    @Test
    public void updateAvatarByID() throws Exception {

    }

    @Test
    public void updateUserNameByID() throws Exception {

    }

    @Test
    public void getIDByInviteCode() throws Exception {

    }

    @Test
    public void deleteUserByID() throws Exception {

    }

    @Test
    public void getAllUsers() throws Exception {
         List<User> US
        =userService.getAllUsers();
        System.out.println("");
    }

}