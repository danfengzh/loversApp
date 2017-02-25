package org.loversAPP.DTO;

import org.loversAPP.model.Friend;
import org.loversAPP.model.User;

/**
 * Created by Administrator on 2017/2/25.
 */
public class FriendShip extends Friend {

    private User friend;

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
