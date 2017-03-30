package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

import java.util.Date;

public class DoodlePhoto extends BaseModel {
    private Integer id;

    private Integer userid;

    private Integer useritemid;

    private Date doodletime;

    private Integer photoid;

    private String doodlephoto;

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

    public Integer getUseritemid() {
        return useritemid;
    }

    public void setUseritemid(Integer useritemid) {
        this.useritemid = useritemid;
    }

    public Date getDoodletime() {
        return doodletime;
    }

    public void setDoodletime(Date doodletime) {
        this.doodletime = doodletime;
    }

    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public String getDoodlephoto() {
        return doodlephoto;
    }

    public void setDoodlephoto(String doodlephoto) {
        this.doodlephoto = doodlephoto == null ? null : doodlephoto.trim();
    }
}