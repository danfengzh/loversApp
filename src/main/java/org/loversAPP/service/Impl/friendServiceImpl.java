package org.loversAPP.service.Impl;

import org.loversAPP.DTO.FriendShip;
import org.loversAPP.DTO.TinyUser;
import org.loversAPP.dao.FriendMapper;
import org.loversAPP.model.Friend;
import org.loversAPP.model.FriendExample;
import org.loversAPP.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
@Service
public class friendServiceImpl implements friendService {
    @Autowired
    private FriendMapper friendMapper;


    public Integer insertFriend(Integer userID, Integer friendID) {
        Friend friend=new Friend();
        friend.setUserid(userID);
        friend.setFriendid(friendID);
        return friendMapper.insert(friend);
    }


    public Integer deleteFriend(Integer userID, Integer friendID) {
        FriendExample friendExample=new FriendExample();
        friendExample.createCriteria().andUseridEqualTo(userID).andFriendidEqualTo(friendID);
        return friendMapper.deleteByExample(friendExample);
    }
    /**
     *
     * @param userID
     * @return
     */

    public FriendShip getFriendsByUID(Integer userID) {
        return friendMapper.getFriendsByUID(userID);
    }


    public List<TinyUser> getAllTinyUser(int userid) {
        return friendMapper.getAllTinyUser(userid);
    }

    /**
     * 1.若userID只和friendID绑定，返回201（如userID=2，friendID=5）
     2.若userID和friendID相互绑定，返回202（如userID=2，friendID=5且userID=5，friendID=2）
     3.若userID和friendID未绑定，返回200
     * @param userid
     * @param friendID
     * @return
     */

    public int checkIsFollowed(int userid, int friendID) {

        Integer result=0;
        int temp=friendMapper.selectIsFollowed(userid,friendID);
        int another=friendMapper.selectIsFollowed(friendID,userid);
        int cooo=friendMapper.getAllFollersCount(userid);
        if(temp==0){
            //userID和friendID未绑定
            if(another==0){
                result=3;

            }
        }
        //至少这两个是绑定的
        else
        {
            if(another==1){
                //两者相互绑定
                result=2;

            }
            if(cooo==1){
                result=1;

            }
            else {
                result=1;
            }
        }
        return result;
    }
}
