package org.loversAPP.service;

import org.loversAPP.DTO.FriendShip;
import org.loversAPP.DTO.TinyUser;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
public interface friendService {

    public Integer   insertFriend(Integer userID ,Integer friendID);

    public Integer deleteFriend(Integer userID ,Integer friendID);

    /**
     * 需要friend表和user表联合查询
     * @param userID
     * @return
     */
    public FriendShip getFriendsByUID(Integer userID);

    public List<TinyUser> getAllTinyUser(int userid);
}
