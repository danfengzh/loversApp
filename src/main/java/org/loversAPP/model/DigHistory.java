package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class DigHistory extends BaseModel {
    private Integer id;

    private Integer userid;

    private Integer treasureid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTreasureid() {
        return treasureid;
    }

    public void setTreasureid(Integer treasureid) {
        this.treasureid = treasureid;
    }
}