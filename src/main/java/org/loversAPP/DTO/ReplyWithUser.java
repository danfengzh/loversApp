package org.loversAPP.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ReplyWithUser implements Serializable {
    public  Integer userID;

    public String avatar;

    public Date replyDate;

    public String replyContent;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}
