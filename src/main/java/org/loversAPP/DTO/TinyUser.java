package org.loversAPP.DTO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/15.
 */
public class TinyUser implements Serializable{
    private int userID;
    private String avatar;
    private String userName;
    private String signature;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
