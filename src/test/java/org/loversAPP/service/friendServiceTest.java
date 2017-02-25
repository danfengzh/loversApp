package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.DTO.FriendShip;
import org.loversAPP.service.baseService.baseServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/2/25.
 */
public class friendServiceTest extends baseServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private friendService friendService;
    @Test
    public void insertFriend() throws Exception {
        Integer count=  friendService.insertFriend(2,5);
        System.out.println("******");
    }

    @Test
    public void deleteFriend() throws Exception {
        Integer count=  friendService.deleteFriend(2,5);
        System.out.println("*********");
    }

    @Test
    public void getFriendsByUID() throws Exception {
      FriendShip friendShip= friendService.getFriendsByUID(2);
        System.out.println("************");
    }

}