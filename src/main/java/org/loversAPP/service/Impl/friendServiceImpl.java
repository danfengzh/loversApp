package org.loversAPP.service.Impl;

import org.loversAPP.DTO.FriendShip;
import org.loversAPP.dao.FriendMapper;
import org.loversAPP.model.Friend;
import org.loversAPP.model.FriendExample;
import org.loversAPP.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/25.
 */
@Service
public class friendServiceImpl implements friendService {
    @Autowired
    private FriendMapper friendMapper;
    @Override
    public Integer insertFriend(Integer userID, Integer friendID) {
        Friend friend=new Friend();
        friend.setUserid(userID);
        friend.setFriendid(friendID);
        return friendMapper.insert(friend);
    }

    @Override
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
    @Override
        public FriendShip getFriendsByUID(Integer userID) {
        return friendMapper.getFriendsByUID(userID);
    }
}
