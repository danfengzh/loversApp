package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

/**
 * Created by Administrator on 2017/4/3.
 */
public class ItemCapsule extends BaseModel {

    private int love_capsule_id;

    private int userID;

    private int itemID;

    public int getLove_capsule_id() {
        return love_capsule_id;
    }

    public void setLove_capsule_id(int love_capsule_id) {
        this.love_capsule_id = love_capsule_id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
}
