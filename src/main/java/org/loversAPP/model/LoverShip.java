package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

import java.util.Date;

public class LoverShip extends BaseModel {
    private Integer lovergirlid;

    private Integer loverboyid;

    private Date lovetime;

    private Integer state;

    private String loverid;

    private Integer loveindex;

    public Integer getLovergirlid() {
        return lovergirlid;
    }

    public void setLovergirlid(Integer lovergirlid) {
        this.lovergirlid = lovergirlid;
    }

    public Integer getLoverboyid() {
        return loverboyid;
    }

    public void setLoverboyid(Integer loverboyid) {
        this.loverboyid = loverboyid;
    }

    public Date getLovetime() {
        return lovetime;
    }

    public void setLovetime(Date lovetime) {
        this.lovetime = lovetime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLoverid() {
        return loverid;
    }

    public void setLoverid(String loverid) {
        this.loverid = loverid == null ? null : loverid.trim();
    }

    public Integer getLoveindex() {
        return loveindex;
    }

    public void setLoveindex(Integer loveindex) {
        this.loveindex = loveindex;
    }
}