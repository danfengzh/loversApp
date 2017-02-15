package org.loversAPP.model;

import org.loversAPP.base.BaseEntity;

public class UserItem extends BaseEntity {
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

    @Override
    public String toString() {
        return "UserItem{" +
                "userId=" + userId +
                ", itemId=" + itemId +
                '}';
    }
}