package org.loversAPP.DTO;

import org.loversAPP.model.Message;
import org.loversAPP.model.User;

/**
 * Created by Administrator on 2017/3/4.
 */
public class UserMessage extends Message {
    private User user;
    private int isRead;

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
