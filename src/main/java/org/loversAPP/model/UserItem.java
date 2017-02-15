package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class UserItem extends BaseModel {
    private Integer userId;

    private Integer itemId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}