package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

import java.util.Date;

public class GoDie extends BaseModel {
    private Integer id;

    private Integer useritemid;

    private Date time;

    private Integer userid;

    private Integer reciveID;

    public Integer getReciveID() {
        return reciveID;
    }

    public void setReciveID(Integer reciveID) {
        this.reciveID = reciveID;
    }

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}