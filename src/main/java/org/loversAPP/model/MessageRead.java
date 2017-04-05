package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

/**
 * Created by Administrator on 2017/4/3.
 */
public class MessageRead extends BaseModel {

    private int messageID;
    private int  recieverID;
    private int isRead;

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getRecieverID() {
        return recieverID;
    }

    public void setRecieverID(int recieverID) {
        this.recieverID = recieverID;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
}
