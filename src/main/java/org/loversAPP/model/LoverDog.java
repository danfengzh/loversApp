package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

import java.util.Date;

public class LoverDog extends BaseModel {
    private Integer id;

    private Integer useritemid;

    private Date inserttime;

    private Integer loverid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUseritemid() {
        return useritemid;
    }

    public void setUseritemid(Integer useritemid) {
        this.useritemid = useritemid;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Integer getLoverid() {
        return loverid;
    }

    public void setLoverid(Integer loverid) {
        this.loverid = loverid;
    }
}