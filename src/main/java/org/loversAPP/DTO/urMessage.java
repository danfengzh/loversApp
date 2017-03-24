package org.loversAPP.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/7.
 */
public class urMessage implements Serializable {
    private String userName;
    private Integer userID;
    private String avatar;
    private String msgType;
    private Date msgDate;
    private String msgContent;
    private int isRead;

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public urMessage(String userName, Integer userID, String avatar, String msgType, Date msgDate, String msgContent) {
        this.userName = userName;
        this.userID = userID;
        this.avatar = avatar;
        this.msgType = msgType;
        this.msgDate = msgDate;
        this.msgContent = msgContent;
    }

    public urMessage() {
    }
}
