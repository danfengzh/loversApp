package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class ItemTreasure extends BaseModel {
    private Integer id;

    private String treasurecode;

    private Integer itemid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTreasurecode() {
        return treasurecode;
    }

    public void setTreasurecode(String treasurecode) {
        this.treasurecode = treasurecode == null ? null : treasurecode.trim();
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }
}